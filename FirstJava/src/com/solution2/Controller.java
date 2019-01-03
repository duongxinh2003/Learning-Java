package com.solution2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javafx.util.Pair;

public class Controller implements Runnable {
	private final RandomData random = new RandomData(null);
	public BlockingQueue<String> drop;
	public BlockingQueue<LinkedHashMap<Integer, ArrayList<String>>> data;

	public Controller(BlockingQueue<String> drop, BlockingQueue<LinkedHashMap<Integer, ArrayList<String>>> data) {
		this.drop = drop;
		this.data = data;
	}

	@Override
	public void run() {
		try {
			System.out.println("Preparing data ....");
			String message = null;
			ArrayList<String> list = new ArrayList<>();
			do {
				message = drop.poll(10, TimeUnit.SECONDS);
				if (message != null) {
					list.add(message);
				}
			} while (message != null);
			int l = 0;
			ArrayList<Pair<Integer, Integer>> pos = new ArrayList<>();
			do {
				pos.add(new Pair<>(l, Math.min(l + 1000, list.size())));
				l += 1000;
			} while (l < list.size());
//			BlockingQueue<LinkedHashMap<Integer, ArrayList<String>>> data = new LinkedBlockingQueue<>();
			for (int i = 0; i < pos.size(); i++) {
				ArrayList<String> tempList = new ArrayList<>();
				for (int j = pos.get(i).getKey(); j < pos.get(i).getValue(); j++) {
					tempList.add(list.get(j));
				}
				LinkedHashMap<Integer, ArrayList<String>> tempMap = new LinkedHashMap<>();
				tempMap.put(i, tempList);
				data.offer(tempMap);
			}
//			System.out.println(data.toString());

		} catch (

		InterruptedException e) {
			System.out.println("Error to control data.");
			e.printStackTrace();
		}

	}

}
