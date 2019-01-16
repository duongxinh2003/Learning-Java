package com.ex2evol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.*;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public BlockingQueue<CopyOnWriteArrayList<Information>> listData;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH.mm.ss");

	public Controller(BlockingQueue<CopyOnWriteArrayList<Information>> listData) {
		this.listData = listData;
	}

	@Override
	public void run() {
		try {
			CopyOnWriteArrayList<Information> list = null;
			int thread = Integer.parseInt(Thread.currentThread().getName());
			do {
				list = listData.poll(10, TimeUnit.SECONDS);
				if (list != null) {
					synchronized (listData) {
						long startWrite = System.nanoTime();
//						System.out.println(thread +  " Size: "+ list.size());
						long randomFileName = RandomData.randomBetween(1000000L, 1L);
						String randomName = "src\\com\\ex2evol\\data\\" + randomFileName +  ".txt";
						try {
							File oldFile = new File(randomName);
							PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(oldFile)));
							writer.write(list.toString());
							

						long endWrite = System.nanoTime();
						String totalTimeSeconds = String.format("%.3f", (double) (endWrite-startWrite)/1000000000);
						Date date = new Date();
						String dateTime = sdf.format(date);
						String newName = thread + "_" + dateTime + "_" + totalTimeSeconds + ".txt";
						System.out.println(newName);
						writer.close();
						Path file = Paths.get(randomName);
						Files.move(file, file.resolveSibling(newName), StandardCopyOption.REPLACE_EXISTING);
						thread+=100;
						listData.notify();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} while (true);
		} catch (InterruptedException e) {
			System.out.println("Error to control data.");
			e.printStackTrace();
		}

	}

}
