package com.ex2evol;

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
		BlockingQueue<CopyOnWriteArrayList<Information>> listData = new LinkedBlockingQueue<>();
//		RandomData random = new RandomData(listData);
		Controller controller = new Controller(listData);
//		new Thread(random).start();
		for (int j = 0; j < 10; j++) {
			new Thread(new RandomData(listData)).start();
		}
		for (int i = 0; i < 30; i++) {
			new Thread(controller,i+"").start();
		}
		
	}
}
