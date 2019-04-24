package com.blockingqueue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class OutputData implements Runnable {
	private final RandomData random = new RandomData(null);
	public BlockingQueue<String> drop;
	public BlockingQueue<String> last;
	public BlockingQueue<String> countFile;

	public OutputData(BlockingQueue<String> drop, BlockingQueue<String> last, BlockingQueue<String> countFile) {
		this.drop = drop;
		this.last = last;
		this.countFile = countFile;
	}

	@Override
	public void run() {
			try {
				String message = null;
				int cnt = Integer.valueOf(Thread.currentThread().getName());
				ArrayList<String> list = new ArrayList<>();
				do {
					message = drop.poll(10, TimeUnit.SECONDS);
					if (message != null) {
						list.add(message);
						if (list.size() == 1000) {
							System.out.println("Thread " + Thread.currentThread().getName() + ": Printing data " + cnt + ".....");
							String fileName = "src\\com\\project\\data\\" + String.format("%03d_", cnt)
									+ random.randomBetween(10000L, 1000L) + ".txt";
							try {
								PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
								for (int i = 0; i < 1000; i++) {
									writer.write(list.get(i));
								}
								cnt+=30;
								writer.close();
								list.removeAll(list);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else {
						System.out.println(Thread.currentThread().getName() + " Last data " + cnt + ".....");
						countFile.offer(cnt+"", 10, TimeUnit.SECONDS);
						for (int i = 0; i < list.size(); i++) {
							last.offer(list.get(i), 10, TimeUnit.SECONDS);
						}
						cnt+=30;
						list.removeAll(list);
					}
				} while (message != null);

			} catch (InterruptedException e) {
				System.out.println("Error Output file");
				e.printStackTrace();
			}
		
	}

}
