package day6;

import java.io.Serializable;

public class Information implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double score;
	private transient String gender;
	
	public Information() {
	}

	public Information(int id, String name, double score, String gender) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.gender = gender;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Information [id=" + id + ", name=" + name + ", score=" + score + ", gender= " + gender +"]";
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
