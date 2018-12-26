package day11;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class IOThread {
	public InputFile input = new InputFile();
	public RandomData random = new  RandomData();

	public void createThreads() {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					ArrayList<Information> informations = new ArrayList<>();
					try {
						informations.add(random.randomInformation());
					} catch (ParseException e) {
						e.printStackTrace();
					}
//					if (informations.size() == 1000) {
//					synchronized (input) {
//						try {
//							String inputPath = input.createFile();
//							FileWriter writer = new FileWriter(inputPath);
//							for (Information i : informations) {
//								writer.write(i.toString());
//							}
//							writer.close();
							System.out.println(Thread.currentThread().getName()+informations.get(0).toString());
//						} catch (Exception e) {
//							System.out.println("Error");
//							e.printStackTrace();
//						}
//					}

//					}
				}
			}).start();
		}
	}
}
