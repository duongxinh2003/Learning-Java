package com.solution4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javafx.util.Pair;

public class MainThread {

	public static void main(String[] args) {
		BlockingQueue<Information> listData = new LinkedBlockingQueue<>();
		RandomData random = new RandomData(listData);
		Controller controller = new Controller(listData);
		for (int i = 0; i < 1; i++) {
			new Thread(random).start();
		}
		for (int i = 0; i < 30; i++) {
			new Thread(controller).start();
		}
	}
}
