package com.entity;

public class InternalBus extends Buses {
	private float distance;

	public InternalBus() {
		super();
	}

	public InternalBus(int busId, String owner, String route, float price, float distance) {
		super(busId, owner, route, price);
		this.distance = distance;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + distance;
	}
}
