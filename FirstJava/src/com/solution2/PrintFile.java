package com.solution2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import javafx.util.Pair;

public class PrintFile implements Runnable {
	private final RandomData random = new RandomData(null);
	public BlockingQueue<String> data;
	public BlockingQueue<ConcurrentHashMap<Integer, ArrayList<String>>> map;

	public PrintFile(BlockingQueue<String> data, BlockingQueue<ConcurrentHashMap<Integer, ArrayList<String>>> map) {
		this.data = data;
		this.map = map;
	}

	@Override
	public void run() {
		ConcurrentHashMap<Integer, ArrayList<String>> tempMap = null;
		String temp = null;
		ArrayList<String> tempList = new ArrayList<>();
		try {
			do {
				tempMap = map.poll(100, TimeUnit.SECONDS);
				if(tempMap != null) {
					ArrayList<Entry<Integer, ArrayList<String>>> entry = new ArrayList<>(tempMap.entrySet());
					Entry<Integer, ArrayList<String>> last = entry.get(entry.size()-1);
//					System.out.println(Thread.currentThread().getName() + " Key is: " + last.getKey());
//					System.out.println(Thread.currentThread().getName() + " Value is: " + last.getValue());
					System.out.println(last.getKey() + " Size is: " + last.getValue().size());
					 String fileName = "src\\com\\project\\data\\" + String.format("%03d_", last.getKey())+ random.randomBetween(10000L, 1000L) + ".txt";
		                try {
		                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		                        writer.write(last.getValue().toString());

		                    writer.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
				}
			} while (tempMap != null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
