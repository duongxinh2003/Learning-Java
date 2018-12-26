package day11;

import java.io.File;
import java.io.IOException;

public class InputFile {
	
	public boolean checkExistFile(String path) {
		File file = new File(path);
		return file.exists()&& !file.isDirectory();
	}
	
	public synchronized String createFile() throws IOException {
		long ordinalNumber = RandomData.randomBetween(1000L, 1L);
		long indentity = RandomData.randomBetween(1000L, 100L);
		String path = "src\\day11\\data\\" + ordinalNumber+"_"+indentity+".txt";
		do {
		ordinalNumber = RandomData.randomBetween(1000L, 1L);
		indentity = RandomData.randomBetween(1000L, 100L);
		path = "src\\day11\\data\\" + ordinalNumber+"_"+indentity+".txt";
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
