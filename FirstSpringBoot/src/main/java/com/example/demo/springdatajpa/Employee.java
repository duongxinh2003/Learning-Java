package com.example.demo.springdatajpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;


@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name= "id", unique= true, precision = 10)
	private int id = 50;
	@Column(name="emp_no", length= 30)
	private String empNo;
	@Column(name="full_name", length= 100)
	private String fullName;
	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	private Date hireDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	@Override
	public String toString() {
		return "Emloyee [id=" + id + ", depNo=" + empNo + ", fullName=" + fullName + ", hireDate=" + hireDate + "]";
	}
	
	
}
