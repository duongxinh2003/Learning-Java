package com.sonnh.second.entity;

public class Second {
	
	private Long id;
	private String name;
	
	public Second() {
	}
	
	public Second(Long id, String name) {
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
		return "Second database [id=" + id + ", name=" + name + "]";
	}

}
