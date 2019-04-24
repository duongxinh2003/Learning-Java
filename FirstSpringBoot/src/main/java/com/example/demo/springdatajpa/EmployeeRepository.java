package com.example.demo.springdatajpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Create interface extend CRUDRepo spring data jpa
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{//Integer is type of employee id
	
	Employee findById(int id);
	List<Employee> findByFullNameLike(String fullName);
	List<Employee> findByHireDateGreaterThan(Date date);
}
