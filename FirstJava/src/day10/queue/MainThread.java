package day10.queue;

import java.util.Queue;

public class MainThread {
	public static void main(String[] args) {
		int size = 50;
		MyQueue myQueue = new MyQueue(size);
		for (int i = 0; i < size; i++) {
			myQueue.enQueue(i);
		}
		ControlThread controlThread = new ControlThread();
		controlThread.createThreads(myQueue, 4);
	}
}
