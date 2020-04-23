package com.kiheyunkim.kim.Course;

import java.util.List;

public interface CourseDao {
	Course store(Course course);
	void delete(Long courseId);
	Course findById(Long courseId);
	List<Course> findAll();
}
