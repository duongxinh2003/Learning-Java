package com.blockingqueue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
		BlockingQueue<String> last = new LinkedBlockingQueue<>();
		BlockingQueue<String> countFile = new LinkedBlockingQueue<>();
		RandomData producer = new RandomData(blockingQueue);
		OutputData consumer = new OutputData(blockingQueue,last, countFile);
		PrintLastFile file = new PrintLastFile(last, countFile);
		new Thread(producer).start();
		for (int i = 0; i < 30; i++) {
			new Thread(consumer,i+"").start();
		}
		new Thread(file).start();
	}
}
