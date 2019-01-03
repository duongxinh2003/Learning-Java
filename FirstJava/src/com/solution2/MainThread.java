package com.solution2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javafx.util.Pair;

public class MainThread {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
		BlockingQueue<String> countFile = new LinkedBlockingQueue<>();
		BlockingQueue<String> list = new LinkedBlockingQueue<>();
		BlockingQueue<LinkedHashMap<Integer, ArrayList<String>>> data = new LinkedBlockingQueue<>();
		RandomData producer = new RandomData(blockingQueue);
		Controller consumer = new Controller(blockingQueue, data);
		PrintFile file = new PrintFile(data);
		new Thread(producer).start();
		new Thread(consumer).start();
//		new Thread(file).start();
		for (int i = 0; i < 30; i++) {
			new Thread(file,i+"").start();
		}
		
	}
}
