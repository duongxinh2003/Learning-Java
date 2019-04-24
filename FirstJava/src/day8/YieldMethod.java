package day8;

import java.util.Date;

public class YieldMethod {
	public static void main(String[] args) {
		HighPriority highPriority = new HighPriority();
		highPriority.setPriority(Thread.MAX_PRIORITY);
		LowPriority lowPriority = new LowPriority();
		lowPriority.setPriority(Thread.MIN_PRIORITY);
		highPriority.start();
		lowPriority.start();
	}
}
class HighPriority extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Thread.yield();
			System.out.println(i);
		}
//		Date date = new Date();
//		System.out.println(date.getTime());
	}
	
}

class LowPriority extends Thread {

	@Override
	public void run() {
		for (int i = 2000; i < 3000; i++) {
			System.out.println(i);
		}
	}
	
}