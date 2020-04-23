package com.kiheyunkim.kim.Course;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateCourseDao implements CourseDao{

	private final SessionFactory sessionFactory;
	
	public HibernateCourseDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public Course store(Course course) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(course);
		session.close();
		return course;
	}

	@Override
	@Transactional
	public void delete(Long courseId) {
		Session session = sessionFactory.openSession();
		Course course = (Course) session.get(Course.class, courseId);
		session.delete(course);
	}

	@Override
	@Transactional(readOnly = true)
	public Course findById(Long courseId) {
		Session session = sessionFactory.openSession();
		return (Course) session.get(Course.class,courseId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Course> findAll() {
		Session session = sessionFactory.openSession();
		return session.createQuery("SELECT c FROM Course c").list();		
	}

}
