package com.solution3;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class InputFileController implements Runnable {

	public StringBuffer inputPath = new StringBuffer();
	public BlockingQueue<StringBuffer> listFile;
	private int index = 0;

	public InputFileController(StringBuffer inputPath, BlockingQueue<StringBuffer> listFile) {
		this.inputPath = inputPath;
		this.listFile = listFile;
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		while(true) {
			synchronized (this) {
				setIndex();
			}
//			String threadName = Thread.currentThread().getName();
//			System.out.println(threadName + "\t" + getFilePath(value));
			try {
				listFile.offer(getFilePath(getIndex()), 1, TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			long end = System.currentTimeMillis();
			if (((end - start) / 1000) >= 1 && ((end - start) / 1000) % 1 == 0) {
				try {
					System.out.println("Create file is sleeping.....");
					Thread.sleep(30000);
					System.out.println("Create file wake up......");
					start = System.currentTimeMillis();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public StringBuffer getFilePath(int index) {
		String path = "src\\com\\solution3\\data\\";
		String prefix = String.format("%03d_", index);
		String suffix = String.format("%05d.txt", RandomData.randomBetween(100000L, 1000L));
		String pathName = path + prefix + suffix;
		File file = new File(pathName);
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputPath.replace(0, inputPath.length(), pathName);
	}

//	public static void main(String[] args) {
//		InputFileController ifc = new InputFileController(new StringBuffer());
//		for (int i = 0; i < 4; i++) {
//			new Thread(ifc).start();
//		}
//	}

	public synchronized int getIndex() {
		return index;
	}

	public synchronized void setIndex() {
		this.index = index + 1;
	}

}
