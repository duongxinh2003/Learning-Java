package day11;

import java.text.ParseException;
import java.util.ArrayList;

public class MainThread {
	public static void main(String[] args) throws ParseException, InterruptedException {
		IOThread ioThread = new IOThread();
		RandomData randomData = new RandomData();
		Thread randomThread = new Thread(randomData);
		randomThread.start();
		ioThread.createThreads();
		

//		do {
//			informations.add(randomData.randomInformation());
//		} while (((System.currentTimeMillis()-start)/1000)<=3);
	}
}
