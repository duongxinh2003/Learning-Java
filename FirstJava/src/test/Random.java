package test;

import java.util.ArrayList;

public class Random {
	public MyList myList = new MyList();
	
	public void runThread(Object object) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				java.util.Random rand = new java.util.Random();
				ArrayList<MyData> list = new ArrayList<>();
				int value = rand.nextInt(1000);
				while (true) {
					synchronized (object) {
						while (list.size() == 1000) {
							try {
								object.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						list.add(new MyData(value));
//						System.out.println("Add: " + value + "\nSize is " + list.size());
						value = rand.nextInt(1000);
						myList.setList(list);
						object.notify();
						
						
						long end = System.currentTimeMillis();
						if (((end - start) / 1000) >= 5 && ((end - start) / 1000) % 5 == 0) {
							String time = (end - start) / 1000 + "";
							System.out.println(time);
							try {
								Thread.sleep(30000);
								start = System.currentTimeMillis();
								list = new ArrayList<>();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				}
			}
		}).start();
	}
}
