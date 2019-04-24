package com;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import day11.Information;
import javafx.util.Pair;

public class MainThread {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
		BlockingQueue<ArrayList<String>> pass = new LinkedBlockingQueue<>();
		BlockingQueue<CopyOnWriteArrayList<Information>> listThousandData = new LinkedBlockingQueue<>();
		BlockingQueue<StringBuffer> listFile = new LinkedBlockingQueue<>();
		StringBuffer file = new StringBuffer();
		BlockingQueue<ConcurrentHashMap<Integer, ArrayList<String>>> map = new LinkedBlockingQueue<>();
		RandomData random = new RandomData(blockingQueue, listThousandData);
		InputFileController fileInput = new InputFileController(file, listFile);
		Controller controller = new Controller(blockingQueue, listThousandData);
		OutputFileController fileOutput = new OutputFileController(listFile, pass);
		new Thread(random).start();
//		new Thread(fileInput).start();
		for (int i = 0; i < 30; i++) {
			new Thread(fileOutput).start();
		}
		for (int i = 0; i < 30; i++) {
			new Thread(controller,i+"").start();
		}
		
	}
}
