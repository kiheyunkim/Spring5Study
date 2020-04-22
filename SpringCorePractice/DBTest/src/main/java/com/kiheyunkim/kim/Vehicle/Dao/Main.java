package com.kiheyunkim.kim.Vehicle.Dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kiheyunkim.kim.Course.Course;
import com.kiheyunkim.kim.Course.CourseDao;
import com.kiheyunkim.kim.Course.JpaCourseDao;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		
		CourseDao courseDao = new JpaCourseDao();
		
		Course course = new Course();
		course.setBeginDate(new Date());
		course.setEndDate(new Date());
		course.setFee(10000);
		course.setTitle("≈∏¿Ã∆≤");
		courseDao.store(course);
		
		
		Course courseResult = courseDao.findById(4L);
		
		System.out.println(courseResult);
		
		courseDao.delete(4L);
		
		
		/*
		VehicleDao vehicleDao = context.getBean(VehicleDao.class);
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNo("TEM0001");
		vehicle.setColor("Red");
		vehicle.setWheel(4);
		vehicle.setSeat(4);
		
		try {
			vehicleDao.insert(vehicle);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Vehicle> vehicle2 = null;
		try {
			vehicle2 = vehicleDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (Vehicle vehicle3 : vehicle2) {
			System.out.println(vehicle3.getVehicleNo());			
		}
		
		int count = vehicleDao.countAll();
		System.out.println(count);
		String color = vehicleDao.getColor("TEM0001");
		System.out.println(color);
		*/
	}
}
