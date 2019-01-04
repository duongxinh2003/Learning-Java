package com.solution2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import javafx.util.Pair;

public class MainThread {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
		BlockingQueue<String> data = new LinkedBlockingQueue<>();
		BlockingQueue<String> list = new LinkedBlockingQueue<>();
		BlockingQueue<ConcurrentHashMap<Integer, ArrayList<String>>> map = new LinkedBlockingQueue<>();
		RandomData random = new RandomData(blockingQueue);
		Controller controller = new Controller(blockingQueue, map, list);
		PrintFile file = new PrintFile(list, map);
		new Thread(random).start();
		new Thread(controller).start();
		for (int i = 0; i < 30; i++) {
			new Thread(file,i+"").start();
		}
		
	}
}
