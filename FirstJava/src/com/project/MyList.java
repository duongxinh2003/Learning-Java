package com.project;

import java.util.ArrayList;

public class MyList {
	private ArrayList<String> list;
	
	public MyList() {
	}
	
	public MyList(ArrayList<String> list) {
		this.list = list;
	}

	public synchronized ArrayList<String> getList() {
		return list;
	}

	public synchronized void setList(ArrayList<String> list) {
		this.list = list;
	}

}
