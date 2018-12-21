package day9;

import java.util.ArrayList;
import java.util.List;

public class MainThread {
	
	public static void main(String[] args) {
		ArrayList<Integer> tmpList = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			tmpList.add(i);
		}
		ThreadExercise3 ex3 = new ThreadExercise3(tmpList);
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(ex3));
		}
		for (Thread thread : threads) {
			thread.start();
		}
	}
}
