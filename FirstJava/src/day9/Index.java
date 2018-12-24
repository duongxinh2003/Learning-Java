package day9;

public class Index {
	private int index = 0;

	public Index() {
	}

	public Index(int index) {
		this.index = index;
	}

	public synchronized int getIndex() {
		return index;
	}

	public synchronized void setIndex() {
		this.index =index +1;
	}
}
