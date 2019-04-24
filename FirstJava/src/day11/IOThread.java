package day11;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import test.MyData;

public class IOThread {
	
	public MyList myList;
	public InputFile input = new InputFile();

	public IOThread(MyList myList) {
		this.myList = myList;
	}
	
	public void writeFile(ArrayList<Information> list) {
		try {
			String inputPath = input.createFile();
			FileWriter writer = new FileWriter(inputPath);
			for (Information info : list) {
				writer.write(Thread.currentThread().getName()+ " "+info.toString() + "\n");
			}
			writer.close();
			System.out.println(Thread.currentThread().getName() + list.toString());
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public void createThreads() {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (myList) {
						ArrayList<Information> data = myList.getMyList();
						while (data.size() == 0 || data.size() < 900) {
							try {
//								System.out.println("Here");
								myList.wait(10000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println(Thread.currentThread().getName()+ " "+ data.toString());
						writeFile(data);
						data.removeAll(data);
						myList.notify();
					}
				}
			}).start();
		}
	}
}
