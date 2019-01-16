package com.solution3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import day11.Information;
import javafx.util.Pair;

public class MainThread {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
		BlockingQueue<CopyOnWriteArrayList<Information>> listThousandData = new LinkedBlockingQueue<>();
		RandomData random = new RandomData(blockingQueue, listThousandData);
		Controller controller = new Controller(blockingQueue, listThousandData);
		new Thread(random).start();
		for (int i = 0; i < 30; i++) {
			new Thread(controller,i+"-"+30).start();
		}
		
	}
}
