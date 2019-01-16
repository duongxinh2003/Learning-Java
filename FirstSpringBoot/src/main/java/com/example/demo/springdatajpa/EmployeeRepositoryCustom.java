package com.example.demo.springdatajpa;

import java.util.Date;

public interface EmployeeRepositoryCustom {
	
	public int getMaxId();
	
	public int updateEmployee(int id, String fullName, Date date);
}
