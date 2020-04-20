package com.kiheyunkim.kim.Course;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.MySQL8Dialect;


public class HibernateCourseDao implements CourseDao{

	private final SessionFactory sessionFactory;
	
	public HibernateCourseDao() {
		Configuration configuration = new Configuration()
				.setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/vehicle?characterEncoding=UTF-8&serverTimezone=UTC")
				.setProperty(AvailableSettings.USER, "root")
				.setProperty(AvailableSettings.PASS, "toor")
				.setProperty(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL57Dialect")
				.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true))
				.setProperty(AvailableSettings.HBM2DDL_AUTO, "update")
				.addClass(Course.class);
		this.sessionFactory = configuration.buildSessionFactory();
	}
	
	@Override
	public Course store(Course course) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.saveOrUpdate(course);
			tx.commit();
			return course;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public void delete(Long courseId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			Course course = session.get(Course.class, courseId);
			session.delete(course);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}

	@Override
	public Course findById(Long courseId) {
		Session session = sessionFactory.openSession();
		try {
			return session.get(Course.class, courseId);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Course> findAll() {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("SELECT c FROM Course c",Course.class).list();
		} finally {
			session.close();
		}
	}

}
