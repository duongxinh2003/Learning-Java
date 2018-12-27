package day11;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class IOThread {
	public InputFile input = new InputFile();

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

	public void createThreads(Information information) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
						synchronized (RandomData.class) {					
					ArrayList<Information> list = new ArrayList<>();
					while (true) {
							if (list.add(information) == true) {
								int length = list.size();
								if (length == 1000) {
//									synchronized (input) {
										writeFile(list);
										list.removeAll(list);
//									}
								}
							} else {
								while (list.add(information) == false) {
									try {
										wait(10000);
										if (list.add(information) == false) {
//											synchronized (input) {
												writeFile(list);
												list.removeAll(list);
												notifyAll();
//											}
										}
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}).start();
		}
	}
}
