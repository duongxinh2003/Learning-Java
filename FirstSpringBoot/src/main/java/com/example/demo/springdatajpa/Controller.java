package com.example.demo.springdatajpa;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	public final String[] names = {"Nv A", "Nv B", "cNv C", "l T A"};

	@ResponseBody
	@RequestMapping("/employee.html")
	public String showMenu() {
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/showAllEmp")
	public String showAllEmployee() {
		String html = "";
		Iterable<Employee> listEmployees = employeeRepository.findAll();
		for (Employee employee : listEmployees) {
			html += employee.toString() + "</br>";
		}
		return html;
	}
	
	@ResponseBody
	@RequestMapping("//insertEmp")
	public String insertEmployee() {
		Integer idMax = new EmployeeRepositoryCustomImpl().getMaxId();
		Employee employee = new Employee();
		int random = new Random().nextInt(4);
		int id = idMax + 1;
		String fullName = names[random] + " " + id;
		employee.setId(id);
		employee.setEmpNo("Emp_" + id);
		employee.setFullName(fullName);
		employee.setHireDate(new Date());
		this.employeeRepository.save(employee);
		
		return "Inserted: " + employee;
	}
	
	@ResponseBody
	@RequestMapping("//deleteEmp")
	public String deleteAllEmp() {
		this.employeeRepository.deleteAll();
		return "Deleted!!!";
	}
}
