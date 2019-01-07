package com.solution3;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class OutputFileController implements Runnable {

	public BlockingQueue<StringBuffer> listFile;
	public BlockingQueue<ArrayList<String>> listData;

	public OutputFileController(BlockingQueue<StringBuffer> listFile, BlockingQueue<ArrayList<String>> listData) {
		this.listFile = listFile;
		this.listData = listData;
	}

	@Override
	public void run() {
		StringBuffer file = null;
		ArrayList<String> list;
		try {
			do {
				list = listData.poll(50, TimeUnit.SECONDS);
				if(list != null) {
					System.out.println(Thread.currentThread().getName()+ " " +list.size());
				}
			} while (list != null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
