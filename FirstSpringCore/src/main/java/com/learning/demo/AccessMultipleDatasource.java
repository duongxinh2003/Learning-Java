package com.learning.demo;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@EnableAutoConfiguration
public class AccessMultipleDatasource {

	@Bean(name="ds1")
	@Primary
//	@ConfigurationProperties("son.db1")
	public DataSource firstDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/mytestdb");
		datasource.setUsername("root");
		datasource.setPassword("123456");
		return datasource;
	}
	
//	@Bean(name="ds2")
//	@ConfigurationProperties("db2.datasource")
//	public DataSource secondDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//	
//	@Bean(name="ds3")
//	public DataSource thirdDataSource() {
//		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//		dataSourceBuilder.url("jdbc:mysql://localhost/sakila");
//		dataSourceBuilder.username("root");
//		dataSourceBuilder.password("123456");
//		return dataSourceBuilder.build();
//	}
}
