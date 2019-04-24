package com.entity;

public final class ExternalBus extends Buses{
	private int totalDay;
	
	public ExternalBus() {
		super();
	}

	public ExternalBus(int busId, String owner, String route, float price, int totalDay) {
		super(busId, owner, route, price);
		this.totalDay = totalDay;
	}

	public int getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + totalDay;
	}
}
