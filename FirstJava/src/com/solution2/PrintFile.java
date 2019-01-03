package com.solution2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import javafx.util.Pair;

public class PrintFile implements Runnable {
	private final RandomData random = new RandomData(null);
	public BlockingQueue<LinkedHashMap<Integer, ArrayList<String>>> data;

	public PrintFile(BlockingQueue<LinkedHashMap<Integer, ArrayList<String>>> data) {
		this.data = data;
	}

	@Override
	public void run() {
		System.out.println("Getting data ....");
		LinkedHashMap<Integer, ArrayList<String>> record = null;
		ArrayList<LinkedHashMap<Integer, ArrayList<String>>> list = new ArrayList<>();
		try {
			do {
				record = data.poll(50, TimeUnit.SECONDS);
				if(record != null) {
					list.add(record);
					for (int i = 0; i < list.size(); i++) {
						System.out.println(Thread.currentThread().getName()+ " Printing data " + i + "......");
		                String fileName = "src\\com\\project\\data\\" + String.format("%03d_", i)+ random.randomBetween(10000L, 1000L) + ".txt";
		                try {
		                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		                    writer.write(list.get(i).get(i).toString());
		                    writer.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
					}
					list.removeAll(list);
				}
			} while (record != null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
