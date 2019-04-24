package com.learning.demo;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(exclude= {AccessMultipleDatasource.class})
@EnableAutoConfiguration
public class FirstSpringCoreApplication {

	public static void main(String[] args) {
//		Application Context
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("StudentBeans.xml");
//		HelloWorld hello = (HelloWorld) context.getBean("helloWorld");
//		Student student = (Student) context.getBean("student");
//		Student student2 = (Student) context.getBean("student2");
//		hello.getMessage();
//		System.out.println(student.toString());
//		System.out.println(student2.toString());
//		context.close();
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SchoolBeans.xml");
//		School school = (School) context.getBean("schoolFPT");
//		System.out.println(school.toString());
//		context.close();
		
		SpringApplication.run(FirstSpringCoreApplication.class, args);
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AccessMultiDataSourceBeans.xml");
		AccessMultipleDatasource amd = (AccessMultipleDatasource) context.getBean("accessData");
		try {
			System.out.println(amd.firstDataSource().getConnection().getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		context.close();
	}

}

