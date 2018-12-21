package day8;

public class BlockedState extends Thread{
	public static void main(String[] args) {
		BlockedState thread1 = new BlockedState();
		BlockedState thread2 = new BlockedState();
		thread1.start();
		thread2.start();
		System.out.println(thread1.getState());
	}
	
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i);
			try {
				System.out.println(Thread.currentThread().getState());
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
