package day5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HighLevelStream {
	public static void main(String[] args) throws IOException {
		//Write file
		FileOutputStream fileOutputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("src\\day5\\Highlevel.txt");
			dataOutputStream = new DataOutputStream(fileOutputStream);
			int[] id= {2,1,5};
			String[] names = {"An", "Son", "Cfga","G"};
			double[] point = {21.5, 10.9, 7};
			for (int i = 0; i < id.length; i++) {
				dataOutputStream.writeBytes(String.valueOf(id[i]));
				dataOutputStream.writeBytes(names[i]);
				dataOutputStream.writeChars(String.valueOf(point[i]));
				System.out.println(id[i]);
				System.out.println(names[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fileOutputStream.close();
			dataOutputStream.close();
		}
		
		//Read file
		FileInputStream fileInputStream = null;
		DataInputStream dataInputStream = null;
		try {
			fileInputStream = new FileInputStream("src\\day5\\Highlevel.txt");
			dataInputStream = new DataInputStream(fileInputStream);
//			while (true) {
//				int id = dataInputStream.readInt();
//				double point = dataInputStream.readDouble();
//				System.out.println(id + "\t" + point);
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fileInputStream.close();
			dataInputStream.close();
		}
		
	}
}
