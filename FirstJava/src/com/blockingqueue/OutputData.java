package com.blockingqueue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class OutputData implements Runnable {
	private final RandomData random = new RandomData(null);
	public BlockingQueue<String> drop;

	public OutputData(BlockingQueue<String> drop) {
		this.drop = drop;
	}

	@Override
	public void run() {
		try {
			String message = null;
			ArrayList<String> list = new ArrayList<>();
			while (true) {
				message = drop.poll(10, TimeUnit.SECONDS);
				list.add(message);
				if(message == null) {
					int last = list.size()/1000;
					System.out.println(Thread.currentThread().getName()+" " +"BlockingQueue is empty " + list.size());
					for (int i = last*1000; i < list.size()-1; i++) {
						String fileName = "src\\com\\project\\data\\Last_" + random.randomBetween(10000L, 1000L) + ".txt";
		                try {
		                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		                    writer.write(message);
		                    writer.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
					}
					list.removeAll(list);
				}
				if(list.size() != 0 && list.size() % 1000 == 0) {
					int pos = list.size()/1000;
					System.out.println("Printing data " + pos + "...");
	                String fileName = "src\\com\\project\\data\\" + String.format("%03d_", pos)+ random.randomBetween(10000L, 1000L) + ".txt";
	                try {
	                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
	                    int end = pos*1000-1;
	                    for (int i = (pos*1000-1000); i < end; i++) {
	                        writer.write(list.get(i));
	                    }
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("Printed data " + pos + "...");
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Error consumer");
			e.printStackTrace();
		}
	}

}
