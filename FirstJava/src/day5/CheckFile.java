package day5;

import java.io.File;
import java.io.IOException;

public class CheckFile {
	public static void main(String[] args) {
		File file1 = new File("src\\day5");
		File file2 = new File("src","day5\\Assertion.java");
		File file3 = new File(file1, "OverridingExceptions.java");
		File file4 = new File("src\\day5\\Test.txt");
		try {
			System.out.println(file2.getCanonicalPath());
			System.out.println(file3.getAbsolutePath());
			System.out.println(file4.getName());
			System.out.println(file4.getParent());
			String[] list = file1.list(); //get all files and directories
			for (String string : list) {
				System.out.println(string);
			}
			File[] paths = file1.listFiles(); //get all only name of files
			for (File string : paths) {
				System.out.println(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//create the directory by abstract path name
		File file5 = new File("src\\parentfolder\\child\\test");
//		System.out.println(file5.mkdirs());
		System.out.println(file5.mkdir());
		
		//rename file
		System.out.println(file4.renameTo(new File("src\\day5\\Test.txt")));
	}
}
