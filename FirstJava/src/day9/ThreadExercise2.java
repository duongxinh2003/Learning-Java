package day9;

import java.util.ArrayList;

public class ThreadExercise2 implements Runnable {
	public ArrayList<Integer> list;

	public ThreadExercise2() {
		ArrayList<Integer> tmpList = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			tmpList.add(i);
		}
		this.list = tmpList;
	}

	public static void main(String[] args) {
		ThreadExercise2 threadExercise = new ThreadExercise2();
//		MyList myList = new MyList();d
		Thread thread1 = new Thread(threadExercise, "Thread1");
		Thread thread2 = new Thread(threadExercise, "Thread2");
		Thread thread3 = new Thread(threadExercise, "Thread3");
		Thread thread4 = new Thread(threadExercise, "Thread4");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

	@Override
	public void run() {
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (Thread.currentThread().getName().equals("Thread1") && (i%4 == 0)) {
				System.out.println("Thread 1: " + list.get(i));
			} else if (Thread.currentThread().getName().equals("Thread2") && (i%4 == 1)) {
				System.out.println("Thread 2: " + list.get(i));
			} else if (Thread.currentThread().getName().equals("Thread3") && (i%4 == 2)) {
				System.out.println("Thread 3: " + list.get(i));
			} else if (Thread.currentThread().getName().equals("Thread4") && (i%4 == 3)) {
				System.out.println("Thread 4: " + list.get(i));
			}
		}

	}

}
