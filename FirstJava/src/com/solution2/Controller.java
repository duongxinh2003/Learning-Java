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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javafx.util.Pair;

public class Controller implements Runnable {
	private final RandomData random = new RandomData(null);
	public BlockingQueue<String> drop;
	public BlockingQueue<String> dataList;
	public BlockingQueue<ConcurrentHashMap<Integer, ArrayList<String>>> data;

	public Controller(BlockingQueue<String> drop, BlockingQueue<ConcurrentHashMap<Integer, ArrayList<String>>> data, BlockingQueue<String> dataList) {
		this.drop = drop;
		this.data = data;
		this.dataList = dataList;
	}

	@Override
	public void run() {
		try {
			System.out.println("Preparing data ....");
			String message = null;
			ArrayList<String> list = new ArrayList<>();
			ConcurrentHashMap<Integer, ArrayList<String>> map = new ConcurrentHashMap<>();
			int cnt = 0;
			do {
				message = drop.poll(10, TimeUnit.SECONDS);
				if(message != null) {
					list.add(message);
					if(list.size() == 1000) {
						if(map.putIfAbsent(cnt, list) == null) {
							data.offer(map, 1, TimeUnit.SECONDS);
//							System.out.println("Data has put " + cnt + " value: " + list.size());
						}
						for (int i = 0; i < list.size(); i++) {
							dataList.offer(list.get(i));
						}
						list.removeAll(list);
						cnt++;
					}
				} else {
					if(map.putIfAbsent(cnt, list) == null) {
						data.offer(map, 1, TimeUnit.SECONDS);
						System.out.println("Data has put " + cnt + " Last size: " + list.size());
					}
					for (int i = 0; i < list.size(); i++) {
						dataList.offer(list.get(i));
					}
					list.removeAll(list);
					cnt = 0;
				}
			} while (message != null);
			
		} catch (

		InterruptedException e) {
			System.out.println("Error to control data.");
			e.printStackTrace();
		}

	}

}
