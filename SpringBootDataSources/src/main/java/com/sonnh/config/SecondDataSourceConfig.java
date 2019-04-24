package com.sonnh.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SecondDataSourceConfig {

	@Bean(name="ds2")
	public DataSource secondDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/mytestdb");
		datasource.setUsername("root");
		datasource.setPassword("123456");
		return datasource;
	}
	
}
