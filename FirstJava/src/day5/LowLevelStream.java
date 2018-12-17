package day5;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LowLevelStream {
	public static void main(String[] args) {
		File fileInput = new File("src\\day5\\Test.txt");
		File fileOutput = new File("src\\day5\\Output.txt");
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		int c;
//		byte[] byteArray = new byte[10];
		try {
			fileInputStream = new FileInputStream(fileInput);
			fileOutput.createNewFile();
			fileOutputStream = new FileOutputStream(fileOutput);
//			FileInputStream fileInputStream2 = new FileInputStream("src\\day5\\Test.txt");
//			FileInputStream fileInputStream2 = new FileInputStream(new FileDescriptor());
//			fileInputStream.read(b);
//			System.out.println(c);
//			for (byte b : byteArray) {
//				System.out.print((char)b);
//			}
			while ((c = fileInputStream.read()) != -1) { //-1 is end of file
				System.out.print((char)c);
				fileOutputStream.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
