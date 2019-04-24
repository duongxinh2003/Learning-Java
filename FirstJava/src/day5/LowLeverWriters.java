package day5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LowLeverWriters {
	public static void main(String[] args) {
		File file = new File("src\\day5\\Highlevel.txt");
		try {
			FileWriter fileWriter = new FileWriter(file);
			int[] id = {11,5,9};
			for (int i = 0; i < id.length; i++) {
				fileWriter.write(String.valueOf(id[i]));
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
