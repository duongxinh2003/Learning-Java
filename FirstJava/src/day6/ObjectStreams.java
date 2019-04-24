package day6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreams {
	public static void main(String[] args) throws IOException {
		//Serialization object
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("src\\day6\\Output.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			Information information = new Information(2, "Son", 15.8, "male");
			objectOutputStream.writeObject(information);
//			objectOutputStream.writeInt(123456);
			objectOutputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fileOutputStream.close();
			objectOutputStream.close();
		}
	}
}
