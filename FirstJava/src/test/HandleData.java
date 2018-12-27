package test;

import java.util.ArrayList;

public class HandleData {
	MyList myList = new MyList();

	public void createThreads(Object object) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						synchronized (object) {
							ArrayList<MyData> data = myList.getList();
							while (data.size() == 0) {
								try {
									object.wait();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							System.out.println(data.toString());
							data.removeAll(data);
							object.notify();
						}

					}
				}
			}).start();
		}
	}
}
