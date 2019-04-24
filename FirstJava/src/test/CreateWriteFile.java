package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import day11.RandomData;

public class CreateWriteFile {

	public boolean checkExistFile(String path) {
		File file = new File(path);
		return file.exists() && !file.isDirectory();
	}

	public synchronized String createFile() throws IOException {
		RandomData randomId = new RandomData(null);
		long ordinalNumber = randomId.randomBetween(100L, 1L);
		long indentity = randomId.randomBetween(10000L, 1000L);
		String path = "src\\test\\data\\" + ordinalNumber + "_" + indentity + ".txt";
		do {
			ordinalNumber = randomId.randomBetween(100L, 1L);
			indentity = randomId.randomBetween(10000L, 1000L);
			path = "src\\test\\data\\" + ordinalNumber + "_" + indentity + ".txt";
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
	
	public synchronized void writeFile(ArrayList<MyData> list) {
		try {
			String inputPath = createFile();
			FileWriter writer = new FileWriter(inputPath);
			for (MyData info : list) {
				writer.write(info.toString() + "\n");
			}
			writer.close();
//			System.out.println(Thread.currentThread().getName() + list.toString());
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}
