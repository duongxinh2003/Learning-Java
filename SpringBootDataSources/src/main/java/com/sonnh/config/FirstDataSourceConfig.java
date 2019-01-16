package com.sonnh.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration //this class is a beans
public class FirstDataSourceConfig {

	@Bean(name="ds1")
	@Primary
	public DataSource firstDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/user");
		datasource.setUsername("root");
		datasource.setPassword("123456");
		return datasource;
	}
	
}
