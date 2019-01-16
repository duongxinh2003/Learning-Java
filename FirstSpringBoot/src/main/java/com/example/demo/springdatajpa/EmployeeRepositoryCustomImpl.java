package com.example.demo.springdatajpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public int getMaxId() {
		String sql = "select coalesce(max(e.id), 0) from employee e";
		Query query = entityManager.createQuery(sql);
		return (int) query.getSingleResult();
	}

	@Override
	public int updateEmployee(int id, String fullName, Date date) {
		Employee employee = entityManager.find(Employee.class, id);
		if(employee == null) {
			return 0;
		}
		employee.setFullName(fullName);
		employee.setHireDate(date);
		entityManager.flush();
		return 1;
	}

}
