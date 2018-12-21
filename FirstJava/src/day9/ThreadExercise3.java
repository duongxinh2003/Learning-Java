package day9;

import java.util.ArrayList;

public class ThreadExercise3 implements Runnable {

	public Index index = new Index();
	public ArrayList<Integer> list;
	public int temp;

	public ThreadExercise3() {
	}
	
	public ThreadExercise3(ArrayList<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		while (true) {
			int i = index.getIndex();
//			i=getIndex();
			if (i > list.size() - 1) {
				return;
			}
			System.out.println(Thread.currentThread().getName() + "\t" + list.get(index.getIndex()));
			index.setIndex();
		}
//		synchronized (index) {
//			System.out.println(Thread.currentThread().getName() + "\t" + list.get(index.getIndex()));
//		}
//		System.out.println(Thread.currentThread().getName() + "\t" + list.get(Index.getIndex()));
//		System.out.println(checkDuplicate());
	}

	public int checkDuplicate() {
		return this.temp = index.getIndex();
	}
}