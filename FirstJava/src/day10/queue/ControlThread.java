package day10.queue;

public class ControlThread {

	public void createThreads(MyQueue myQueue, int numberThread) {
		for (int i = 0; i < numberThread; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						if(myQueue.negativeSize() == false) {
							return;
						}
							System.out.println(Thread.currentThread().getName() 
								+ "\t" + myQueue.deQueue());
					}
				}
			}).start();
		}
	}
}
