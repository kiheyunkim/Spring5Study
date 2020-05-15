package com.example.demo.runner;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DBRunner implements ApplicationRunner{

	private Logger logger = LoggerFactory.getLogger(DBRunner.class);
	
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info(dataSource.getClass().getName());
		// TODO Auto-generated method stub
		
	}

}
