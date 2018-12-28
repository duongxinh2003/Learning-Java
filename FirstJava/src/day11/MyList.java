package day11;

import java.util.ArrayList;

public class MyList {
	private ArrayList<Information> myList;
	
	public MyList() {
	}

	public MyList(ArrayList<Information> myList) {
		this.myList = myList;
	}

	public synchronized ArrayList<Information> getMyList() {
		return myList;
	}

	public synchronized void setMyList(ArrayList<Information> myList) {
		this.myList = myList;
	}
}
