package com.kiheyunkim.kim.Course;

import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
	public static void main(String[] args) {
		//ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		
		CourseDao courseDao = new JpaCourseDao();
		
		Course course= new Course();
		course.setTitle("Core Spring");
		course.setBeginDate(new GregorianCalendar(2007,8,1).getTime());
		course.setEndDate(new GregorianCalendar(2008,7,31).getTime());
		course.setFee(1000);
		
		System.out.println("Before persisting");
		System.out.println(course);
	
		courseDao.store(course);
		
		Long courseId = course.getId();
		System.out.println(courseId);
		System.out.println("After persisting");
		System.out.println(course);
		
		Course courseFromDb = courseDao.findById(courseId);
		
		System.out.println("fresh from DB");
		System.out.println(courseFromDb);
		
		courseDao.delete(courseId);
	}
}
