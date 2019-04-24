package com.project;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.util.Pair;

public class InputData extends TimerTask{

	private RandomData random = new RandomData();
	public GenerateData generateData;

	public InputData() {
	}

	public void run() {
		synchronized (generateData.myList) {
			int l = 0;
			ArrayList<Pair<Integer, Integer>> pos = new ArrayList<>();
			do {
				pos.add(new Pair<>(l, Math.min(l + 1000, generateData.myList.getList().size())));
				l += 1000;
			} while (l < generateData.myList.getList().size());
	        for (int x = 0; x < pos.size(); x++) {
          int cnt = x;
          new Thread(new Runnable() {
				@Override
				public void run() {
	                System.out.println("Printing data " + cnt + "...");
	                String fileName = "src\\com\\project\\data\\" + String.format("%03d_", cnt)+ random.randomBetween(10000L, 1000L) + ".txt";
	                try {
	                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
	                    for (int i = pos.get(cnt).getKey(); i < pos.get(cnt).getValue(); i++) {
	                        writer.write(generateData.myList.getList().get(i).toString());
	                    }
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("Printed data " + cnt + "...");
					
				}
			}).start();
      }
      System.out.println("Done!");
		}

	}
}
