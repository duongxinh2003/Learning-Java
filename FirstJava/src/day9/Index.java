package day9;

public class Index {
	private int index;

	public Index() {
		this.index = 0;
	}

	public synchronized int getIndex() {
		return index;
	}

	public synchronized void setIndex() {
		this.index =index +1;
	}
	
//	public static int index = 0;
//	
//	public static int getIndex() {
//		return index++;
//	}
}
