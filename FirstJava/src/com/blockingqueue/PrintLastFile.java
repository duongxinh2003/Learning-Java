package com.blockingqueue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import javafx.util.Pair;

public class PrintLastFile implements Runnable {
	private final RandomData random = new RandomData(null);
	public BlockingQueue<String> last;
	public BlockingQueue<String> countFile;
	
	public PrintLastFile(BlockingQueue<String> last, BlockingQueue<String> countFile) {
		this.last = last;
		this.countFile = countFile;
	}

	@Override
	public void run() {
			String message = null;
			String count = null;
			ArrayList<String> data = new ArrayList<>();
			ArrayList<String> listCount = new ArrayList<>();
			
			do {
				try {
					count = countFile.poll(20, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (count != null) {
					listCount.add(count);
				}
			} while (count != null);
			Collections.sort(listCount);
			System.out.println("Current file: " +listCount.get(listCount.size()-1));
			
				do {
					try {
						message = last.poll(20, TimeUnit.SECONDS);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (message != null) {
						data.add(message);
					}
				} while (message != null);
				System.out.println("=====Last size: "+data.size());

				
		        int l = 0;
		        ArrayList<Pair<Integer, Integer>> pos = new ArrayList<>();
		        do {
		            pos.add(new Pair<>(l, Math.min(l + 1000, data.size())));
		            l += 1000;
		        } while (l < data.size());
		        int cnt = Integer.valueOf(listCount.get(listCount.size()-1));
		        
		        for (int x = 0; x < pos.size(); x++) {
			                System.out.println("Last data " + cnt + " is printing ....");
			                String fileName = "src\\com\\project\\data\\" + String.format("%03d_", cnt)+ random.randomBetween(10000L, 1000L) + ".txt";
			                try {
			                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			                    for (int i = pos.get(x).getKey(); i < pos.get(x).getValue(); i++) {
			                        writer.write(data.get(i));
			                    }
			                    writer.close();
			                } catch (IOException e) {
			                    e.printStackTrace();
			                }
			                cnt++;

		        }
		        data.removeAll(data);
		        System.out.println("====Done====");
		

	}
	
}
