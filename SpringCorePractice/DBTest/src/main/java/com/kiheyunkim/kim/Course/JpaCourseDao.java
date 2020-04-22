package com.kiheyunkim.kim.Course;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaCourseDao implements CourseDao {

	private EntityManagerFactory entityManagerFactory;
	
	
	public JpaCourseDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("course");
	}
	
	@Override
	public Course store(Course course) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			manager.merge(course);
			tx.commit();
			return course;
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}finally {
			manager.close();
		}
	}

	@Override
	public void delete(Long courseId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			manager.merge(courseId);
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Course findById(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
