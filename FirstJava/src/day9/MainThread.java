package day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainThread {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		ThreadExercise3 ex3 = new ThreadExercise3();
		ex3.createThreads(list, 4);
	}
}
