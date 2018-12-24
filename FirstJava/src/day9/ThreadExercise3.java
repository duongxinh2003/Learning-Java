package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Vector;

public class ThreadExercise3 implements Comparator<String>{

	public ThreadExercise3() {
	}

	public void createThreads(ArrayList<Integer> list, int numberThreads) {
		Index index = new Index();
		Vector<String> vector = new Vector<>();
		for (int i = 0; i < numberThreads; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < list.size(); j++) {
						int value= 0;
						synchronized (index) {
							value = index.getIndex();
							index.setIndex();
						}
						if(value  > list.size() -1) {
							break;
						} else {
								String threadName = Thread.currentThread().getName();
								vector.add(threadName + "\t" + value);
								System.out.println(threadName + "\t" + value);
								System.out.print("");
						}
					}
					sortList(vector);
				}
			}).start();
		}
	}
	
	public void sortList(Vector<String> vector) {
//		Collections.sort(vector);
		System.out.println(vector.toString());
	}

	@Override
	public int compare(String o1, String o2) {
		String first = o1.substring(o1.indexOf("\t")+ 1);
		String last = o2.substring(o2.indexOf("\t")+ 1);
		return first.compareTo(last);
	}
	
}