package test;

import java.util.ArrayList;

public class MyList {
	private ArrayList<MyData> list;
	
	public MyList() {
	}
	
	public MyList(ArrayList<MyData> list) {
		this.list = list;
	}

	public synchronized ArrayList<MyData> getList() {
		return list;
	}

	public synchronized void setList(ArrayList<MyData> list) {
		this.list = list;
	}

}
