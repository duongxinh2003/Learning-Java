package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import day11.Information;
import javafx.util.Pair;

public class Controller implements Runnable {
	public BlockingQueue<String> drop;
	public BlockingQueue<CopyOnWriteArrayList<Information>> listThousandData;

	public Controller(BlockingQueue<String> drop, BlockingQueue<CopyOnWriteArrayList<Information>> listThousandData) {
		this.drop = drop;
		this.listThousandData = listThousandData;
	}

	@Override
	public void run() {
		try {
//			System.out.println("Preparing data ....");
			CopyOnWriteArrayList<Information> list = null;
			String message = null;
			int cnt = Integer.valueOf(Thread.currentThread().getName());
			do {
				list = listThousandData.poll(10, TimeUnit.SECONDS);
				if (list != null) {
					System.out.println("Number" + cnt + " Size: "+ list.size());
					String fileName = "src\\com\\solution3\\data\\" + String.format("%03d_", cnt)
							+ RandomData.randomBetween(10000L, 1000L) + ".txt";
					try {
						PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
						writer.write(list.toString());
						cnt += 30;
						writer.close();
//						list.removeAll(list);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} while (true);
		} catch (InterruptedException e) {
			System.out.println("Error to control data.");
			e.printStackTrace();
		}

	}

}
