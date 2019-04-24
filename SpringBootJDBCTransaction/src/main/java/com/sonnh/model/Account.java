package com.sonnh.model;

import java.math.BigDecimal;

public class Account {
	private int id;
	private String name;
	private BigDecimal amount;
	
	public Account(int id, String name, BigDecimal amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
}
