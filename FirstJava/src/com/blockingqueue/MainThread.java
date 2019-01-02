package com.blockingqueue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
		RandomData producer = new RandomData(blockingQueue);
		OutputData consumer = new OutputData(blockingQueue);
		new Thread(producer).start();
		for (int i = 0; i < 30; i++) {
			new Thread(consumer).start();
		}
	}
}
