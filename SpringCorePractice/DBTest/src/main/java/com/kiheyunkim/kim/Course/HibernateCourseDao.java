package com.kiheyunkim.kim.Course;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;


public class HibernateCourseDao implements CourseDao{

	private final SessionFactory sessionFactory;
	
	public HibernateCourseDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
			Course course = (Course) session.get(Course.class, courseId);
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
			return (Course) session.get(Course.class, courseId);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Course> findAll() {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("SELECT c FROM Course c").list();
		} finally {
			session.close();
		}
	}

}
