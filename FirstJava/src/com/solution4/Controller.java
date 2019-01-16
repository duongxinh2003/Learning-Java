package com.solution4;

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

import com.ex2evol.RandomData;

import javafx.util.Pair;

public class Controller implements Runnable {
	public BlockingQueue<Information> listData;
	public Index index = new Index();
	private SimpleDateFormat sdf = new SimpleDateFormat("HH.mm.ss");

	public Controller(BlockingQueue<Information> listData) {
		this.listData = listData;
	}

	@Override
	public void run() {
		try {
			Information info = null;
			ArrayList<Information> list = new ArrayList<>();
			do {
				info = listData.poll(5, TimeUnit.SECONDS);
				list.add(info);
				if (info != null) {
					if (list.size() == 10000) {
						index.setIndex();
						writeFile(index.getIndex(), list);
						list.removeAll(list);
					}
				} else {
					index.setIndex();
					writeFile(index.getIndex(), list);
					list.removeAll(list);
					System.out.println(Thread.currentThread().getName() + " End of Random.....");
				}
			} while (true);
		} catch (InterruptedException e) {
			System.out.println("Error to control data.");
			e.printStackTrace();
		}

	}

	private void writeFile(int index, ArrayList<Information> list) {
		long startWrite = System.nanoTime();
		long randomFileName = RandomData.randomBetween(1000000L, 1L);
		String randomName = "src\\com\\solution4\\data\\" + randomFileName + ".txt";
		try {
			File oldFile = new File(randomName);
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(oldFile)));
			writer.write(list.toString());
			long endWrite = System.nanoTime();
			String totalTimeSeconds = String.format("%.3f", (double) (endWrite - startWrite) / 1000000000);
			Date date = new Date();
			String dateTime = sdf.format(date);
			String newName = index + "_" + dateTime + "_" + totalTimeSeconds + ".txt";
			System.out.println(newName);
			writer.close();
			Path file = Paths.get(randomName);
			Files.move(file, file.resolveSibling(newName), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
