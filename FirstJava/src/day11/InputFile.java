package day11;

import java.io.File;
import java.io.IOException;

public class InputFile {

	public boolean checkExistFile(String path) {
		File file = new File(path);
		return file.exists() && !file.isDirectory();
	}

	public synchronized String createFile() throws IOException {
		RandomData randomId = new RandomData();
		Index index = new Index();
		long ordinalNumber;
		long indentity = randomId.randomBetween(10000L, 1000L);
		synchronized (index) {
			ordinalNumber = index.getIndex();
			index.setIndex();
		}
		String path = "src\\day11\\data\\" + ordinalNumber + "_" + indentity + ".txt";
		do {
			synchronized (index) {
				ordinalNumber = index.getIndex();
				index.setIndex();
			}
			indentity = randomId.randomBetween(10000L, 1000L);
			path = "src\\day11\\data\\" + ordinalNumber + "_" + indentity + ".txt";
			File file = new File(path);
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new IOException("Failed to create dir " + file.getParent());
			}
		} while (checkExistFile(path) == false);
		return path;
	}

	public static void main(String[] args) throws IOException {
		InputFile file = new InputFile();
		System.out.println(file.createFile());

	}
}
