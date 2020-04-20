package com.kiheyunkim.kim.Vehicle.Dao;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class VehicleConfiguration {

	@Bean
	public VehicleDao vehicleDao(JdbcTemplate jdbcTemplate) {
		PlainJdbcVehicleDao vehicleDao = new PlainJdbcVehicleDao();
		vehicleDao.setDataSource(dataSource());
		return vehicleDao;
	}
	
	@Bean
	public JdbcTemplate jdbctemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/vehicle?characterEncoding=UTF-8&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("toor");
		return dataSource;
	}
	
}
