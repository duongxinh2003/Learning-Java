package com.entity;

public class Buses {
	private int busId;
	private String owner;
	private String route;
	private float price;
	
	public Buses() {
		
	}

	public Buses(int busId, String owner, String route, float price) {
		super();
		this.busId = busId;
		this.owner = owner;
		this.route = route;
		this.price = price;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return busId + "\t" + owner + "\r" + route;
	}
}
