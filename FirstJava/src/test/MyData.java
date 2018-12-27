 package test;

public class MyData {
	
	private int id;
	
	public MyData() {
	}

	public MyData(int id) {
		this.id = id;
	}

	
	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	@Override
	public synchronized String toString() {
		return "MyData [id=" + id + "]";
	}
}
