package day7;

import java.util.Comparator;

public class Information implements Comparable<Information>{
	private int id;
	private String name;
	private double point;
	
	public Information() {
	}

	public Information(int id, String name, double point) {
		this.id = id;
		this.name = name;
		this.point = point;
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

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	@Override
	public int compareTo(Information o) {
		if(this.getName().compareTo(o.getName()) == 0) {
			return this.getId() - o.getId();
		} else
			return this.getName().compareTo(o.getName());
	}
	
	
}
