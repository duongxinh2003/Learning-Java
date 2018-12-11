package com.entity;

public class ExternalBus extends Buses{
	private int totalDay;
	
	public ExternalBus() {
		super();
	}

	public ExternalBus(int busId, String owner, String route, float price) {
		super(busId, owner, route, price);
		
	}

	public int getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}
	
	
}
