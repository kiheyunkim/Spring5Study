package com.kiheyunkim.kim.Course;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class CourseConfiguration {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setAnnotatedClasses(new Class[] {Course.class});
		
		return sessionFactoryBean;
	}
	
	@Bean
	public CourseDao courseDao(SessionFactory sessionFactory) {
		return new HibernateCourseDao(sessionFactory);
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
	@Bean
	public DataSource getDataSource() {
	    HikariDataSource dataSource = new HikariDataSource();
	    dataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
	    dataSource.setJdbcUrl(
	    		"jdbc:mysql://localhost:3306/vehicle?characterEncoding=UTF-8&serverTimezone=UTC");
	    dataSource.setUsername("root");
	    dataSource.setPassword("toor");
	    return dataSource;
	}   
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty(AvailableSettings.DIALECT,MySQL5Dialect.class.getName());
		properties.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
		properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
		properties.setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/vehicle?characterEncoding=UTF-8&serverTimezone=UTC");
		return properties;
	}
}
