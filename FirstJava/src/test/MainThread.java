package test;

import java.util.ArrayList;

public class MainThread {
	public static void main(String[] args) {
		Object object = new Object();
		MyData data = new MyData();
		MyList myList = new MyList();
		Random random = new Random();
		HandleData handle = new HandleData();
		random.runThread(object);
		handle.createThreads(object);
//		MyData data2 = new MyData(489);
//		ArrayList<MyData> list = new ArrayList<>();
//		list.add(data2);
//		list.add(data2);
//		list.add(data2);
//		int size = list.size();
//		System.out.println(list.get(size-2)== list.get(size-1));
	}
}
