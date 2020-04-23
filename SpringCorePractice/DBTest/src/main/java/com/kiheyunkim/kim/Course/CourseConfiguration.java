package com.kiheyunkim.kim.Course;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class CourseConfiguration {
	
	@Bean
	public CourseDao courseDao(SessionFactory sessionFactory) {
		return new HibernateCourseDao(sessionFactory);
	}
	
	@Bean 
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setAnnotatedClasses(new Class[] {Course.class});
		return sessionFactoryBean;
	}
	
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/vehicle?characterEncoding=UTF-8&serverTimezone=UTC");
		properties.setProperty(AvailableSettings.USER, "root");
		properties.setProperty(AvailableSettings.PASS, "toor");
		properties.setProperty(AvailableSettings.DRIVER, com.mysql.cj.jdbc.Driver.class.getName());
		properties.setProperty(AvailableSettings.DIALECT,MySQL5Dialect.class.getName());
		properties.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
		properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
		return properties;
	}
}
