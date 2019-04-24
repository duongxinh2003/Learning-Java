package day10;

import java.util.LinkedList;

public class MyData {

	public MyData() {
	}

	public void createThreads(LinkedList<Integer> queueList, int numberThreads) {
		for (int i = 0; i < numberThreads; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						int i = 0;
						if (queueList.poll() == null) {
							return;
						}
						i = queueList.poll();
						System.out.println(Thread.currentThread().getName() + "\t" + i);
					}
				}
			}).start();
		}
	}

	public void createThreads(MyLinkedList<Integer> queueList, int numberThreads) {
		for (int i = 0; i < numberThreads; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
//						if (queueList.removeFirst() == null) {
//							return;
//						}
						try {
							System.out.println(Thread.currentThread().getName() + "\t"
								+ queueList.removeFirst().getValue().getValue());
						} catch (NullPointerException e) {
							return;
						}
						
					}
				}
			}).start();
		}
	}

}
