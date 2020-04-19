package com.kiheyunkim.kim.Vehicle.Dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		
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
		
		Vehicle vehicle2 = null;
		try {
			vehicle2 = vehicleDao.findByVehicleNo("TEM0001");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(vehicle2.getVehicleNo());
	}
}
