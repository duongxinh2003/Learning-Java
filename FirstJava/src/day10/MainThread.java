package day10;

import java.util.LinkedList;
import java.util.Queue;

public class MainThread {
	
	public static void main(String[] args) {
//		LinkedList<Integer> queueList = new LinkedList<>();
		MyLinkedList<Integer> myQueue = new MyLinkedList<>();
		for (int i = 0; i < 50; i++) {
			myQueue.add(new Node<Integer>(i), i);
//			System.out.println(myQueue.removeFirst().getValue().getValue());
		}
//		for (int i = 0; i < 50; i++) {
//			queueList.add(i);
//			System.out.println(queueList.remove());
//		}
		MyData myData = new MyData();
//		myData.createThreads(queueList, 3);
		myData.createThreads(myQueue, 3);
	}
}
