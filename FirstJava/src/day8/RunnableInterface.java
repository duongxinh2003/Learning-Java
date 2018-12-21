package day8;

public class RunnableInterface {
	public static void main(String[] args) {
		CountNumber countNumber1 = new CountNumber("Thread 1:");
		CountNumber countNumber2 = new CountNumber("Thread 2:");
		CountNumber countNumber3 = new CountNumber("Thread 3:");
	}
}
class CountNumber implements Runnable {
	Thread tThread;
	public CountNumber(String name) {
		tThread = new Thread(this, name);
		tThread.start();
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(tThread.getName() + i);
		}
	}
	
}