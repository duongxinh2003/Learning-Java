package day8;

public class JoinMethod implements Runnable{
	public static void main(String[] args) {
		JoinMethod joinMethod = new JoinMethod();
		Thread thread1 = new Thread(joinMethod);
		Thread thread2 = new Thread(joinMethod);
		Thread thread3 = new Thread(joinMethod);
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		thread3.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
