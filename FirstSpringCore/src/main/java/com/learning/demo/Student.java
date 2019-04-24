package com.learning.demo;

public class Student {
	
	private String studentNo;
	private int id;
	private String name;
	private String gender;
	private String className;
	
	public Student() {
	}
	
	public Student(String studentNo) {
		this.setStudentNo(studentNo);
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	@Override
	public String toString() {
		return studentNo + "[id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + className + "]";
	}
	
	
}
