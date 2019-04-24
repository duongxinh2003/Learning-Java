package com.sonnh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sonnh.entity.Employee;
import com.sonnh.repo.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
		Employee son = new Employee("Son");
		entityManager.persist(son);
		entityManager.flush();
		
		Employee found = employeeRepository.findByName(son.getName());
		
		assertThat(found.getName()).isEqualTo(son.getName());
	}
}
