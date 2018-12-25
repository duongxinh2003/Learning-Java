package day10.queue;

public class MyQueue {

	private int head = 0;
	private int tail = -1;
	private int size = 0;
	private int[] queue;

	public MyQueue(int size) {
		this.size = size;
		this.queue = new int[size];
	}

	public boolean isEmpty() {
		if (head < 0 || tail < head)
			return false;
		else
			return true;
	}

	public boolean isFull() {
		return (tail == size - 1) ? true : false;
	}

	public void enQueue(int value) {
		if (isFull())
			return;
		tail = tail + 1;
		queue[tail] = value;
	}
	
	public boolean negativeSize() {
		if(queue.length-1 < 0) {
			return false;
		} else 
			return true;
	}

	public synchronized int deQueue() { // remove first and get
		int[] tempQueue = new int[queue.length - 1];
		int value = queue[head];
		for (int i = 0, k = 0; i < queue.length; i++) {
			if (i == 0) {
				continue;
			}
			tempQueue[k++] = queue[i];
		}
		queue = tempQueue;
		return value;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
