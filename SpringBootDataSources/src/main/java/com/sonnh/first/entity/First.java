package com.sonnh.first.entity;

public class First {
	
	private Long id;
	private String name;
	
	public First() {
	}
	
	public First(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "First database [id=" + id + ", name=" + name + "]";
	}

}
