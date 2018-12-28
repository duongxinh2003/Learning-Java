package day11;

import java.text.ParseException;
import java.util.ArrayList;

public class MainThread {
	public static void main(String[] args) throws ParseException, InterruptedException {
		MyList myList = new MyList();
		IOThread ioThread = new IOThread(myList);
		RandomData randomData = new RandomData(myList);
		randomData.runRandom();
		ioThread.createThreads();
		
	}
}
