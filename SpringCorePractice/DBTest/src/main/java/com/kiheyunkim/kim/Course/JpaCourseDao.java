package com.kiheyunkim.kim.Course;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
<<<<<<< HEAD

=======
//http://m.blog.daum.net/m2005m/18259549
>>>>>>> 7693aa97cb6c3669f9353477d86af0ee08591440
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
			manager.persist(course);
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
			Course course = manager.find(Course.class, courseId);
			manager.remove(course);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
<<<<<<< HEAD
		}
		finally {
=======
		} finally {
>>>>>>> 7693aa97cb6c3669f9353477d86af0ee08591440
			manager.close();
		}
	}

	@Override
	public Course findById(Long courseId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			return manager.find(Course.class, courseId);
		} finally {
			manager.close();
		}
	}

	@Override
	public List<Course> findAll() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createQuery("select course from Course course");
			return query.getResultList();
		} finally {
			manager.close();
		}
	}

	
}
