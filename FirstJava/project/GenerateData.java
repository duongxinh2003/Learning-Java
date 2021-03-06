package com.project;

import javafx.util.Pair;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.TimerTask;

public class GenerateData extends TimerTask {
    private final RandomData random = new RandomData();
    @Override
    public void run() {
        ArrayList<String> data = new ArrayList<>();
        long startTime = System.nanoTime();
        System.out.println("Generating data...");
        while (System.nanoTime() - startTime <= 5000000000L) {
            try {
				data.add(random.randomData().toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        System.out.println("Generated data!");

        int l = 0;
        ArrayList<Pair<Integer, Integer>> pos = new ArrayList<>();
        do {
            pos.add(new Pair<>(l, Math.min(l + 1000, data.size())));
            l += 1000;
        } while (l < data.size());
        for (int x = 0; x < pos.size(); x++) {
            int cnt = x;
            new Thread(new Runnable() {
				@Override
				public void run() {
	                System.out.println("Printing data " + cnt + "...");
	                String fileName = "stt-" + String.format("%03d", cnt) + ".txt";
	                try {
	                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
	                    for (int i = pos.get(cnt).getKey(); i < pos.get(cnt).getValue(); i++) {
	                        writer.write(Thread.currentThread().getName() + " " +data.get(i));
	                    }
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("Printed data " + cnt + "...");
					
				}
			}).start();
//            Runnable task = () -> {
//
//            };
//            task.run();
        }
        System.out.println("Done!");
    }
}
