package day8;

public class SleepMethod {
	public static void main(String[] args) {
		Sleeping thread1 = new Sleeping();
		Sleeping thread2 = new Sleeping();
		thread1.start();
		thread2.start();
	}
}
class Sleeping extends Thread{
	
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}