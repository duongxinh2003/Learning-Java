package com.sonnh;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sonnh.dao.AccountDAOImp;
import com.sonnh.service.AccountService;

@SpringBootApplication
public class SpringBootJdbcTransactionApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		AccountService as = (AccountService) context.getBean("accountServiceImpl");
		AccountDAOImp ai = (AccountDAOImp) context.getBean("accountDAOImp");
		System.err.println("Before transfer: " + ai.getAllAccount().toString());
		as.transfer(1, 2, BigDecimal.valueOf(50));
	}

}

