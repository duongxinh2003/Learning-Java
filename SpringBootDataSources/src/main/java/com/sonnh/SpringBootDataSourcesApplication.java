package com.sonnh;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sonnh.config.FirstDataSourceConfig;
import com.sonnh.config.SecondDataSourceConfig;
import com.sonnh.first.dao.FirstDAOImp;
import com.sonnh.second.dao.SecondDAOImp;
import com.sonnh.service.ServiceImp;

@SpringBootApplication
public class SpringBootDataSourcesApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		SpringApplication.run(SpringBootDataSourcesApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AccessMultiDataSourceBeans.xml");
		FirstDataSourceConfig data1 = (FirstDataSourceConfig) context.getBean("firstDataSourceConfig");
		SecondDataSourceConfig data2 = (SecondDataSourceConfig) context.getBean("secondDataSourceConfig");
		FirstDAOImp firstDAOImp = (FirstDAOImp) context.getBean("firstDAOImp");
		SecondDAOImp secondDAOImp = (SecondDAOImp) context.getBean("secondDAOImp");
		ServiceImp serviceImp = (ServiceImp) context.getBean("serviceImp");
		System.err.println(data1.firstDataSource().toString() + " Datasource 2: " + data2.secondDataSource().toString());
		System.err.println(firstDAOImp.getAllFirst().toString());
		System.err.println(secondDAOImp.getAllFirst().toString());
		System.err.println(serviceImp.joinByID());
	}


}

