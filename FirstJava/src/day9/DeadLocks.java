package day9;

public class DeadLocks {
	public static void main(String[] args) {
		String object1 = "Object 1";
		String object2 = "Object 2";
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (object1) {
					System.out.println("Thread 1: Synchronized object 1");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (object2) {
						System.out.println("Thread 1: Synchronized object 2");
					}
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (object2) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread 2: Synchronized object 1");
					synchronized (object1) {
						System.out.println("Thread 2: Synchronized object 2");
					}
				}
			}
		});
		thread1.start();
		thread2.start();
	}
}
