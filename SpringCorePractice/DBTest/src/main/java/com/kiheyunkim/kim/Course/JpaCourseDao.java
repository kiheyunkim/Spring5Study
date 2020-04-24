package com.kiheyunkim.kim.Course;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//http://m.blog.daum.net/m2005m/18259549
@Repository(value = "courseDao")
public class JpaCourseDao implements CourseDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
		
	@Override
	@Transactional
	public Course store(Course course) {
		return entityManager.merge(course);
	}

	@Override
	@Transactional
	public void delete(Long courseId) {
		Course course = entityManager.find(Course.class, courseId);
		entityManager.remove(course);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Course findById(Long courseId) {
		return entityManager.find(Course.class, courseId);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Course> findAll(){
		TypedQuery<Course> query = 
				entityManager.createQuery("select c from Course c", Course.class);
		return query.getResultList();
	}
}
