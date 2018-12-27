package day11;

import java.text.ParseException;
import java.util.ArrayList;

public class MainThread {
	public static void main(String[] args) throws ParseException, InterruptedException {
		Information information = new Information();
		IOThread ioThread = new IOThread();
		RandomData randomData = new RandomData();
		randomData.runRandom(information);
		ioThread.createThreads(information);
		
	}
}
