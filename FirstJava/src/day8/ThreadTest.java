package day8;

public class ThreadTest extends Thread {
	public static void main(String[] args) {
		Student student = new Student();
		ThreadTest thread1 = new ThreadTest();
		Thread thread2 = new Thread(student,"Thread student");
//		Thread thread3 = new Thread(student);
		thread1.start();
		thread2.start();
//		thread3.start();
//		thread1.run();
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}
}

class Student extends Thread {
	public void run() {
		for (int i = 10; i < 15; i++) {
			System.out.println(i);
		}
	}
}