package com.kiheyunkim.kim.Vehicle.Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public interface VehicleDao {	
	void insert(Vehicle vehicle) throws SQLException;
	void insert(Iterable<Vehicle> vehicles);
	void update(Vehicle vehicle);
	void delete(Vehicle vehicle);
	Vehicle findByVehicleNo(String vehicleNo) throws SQLException;
	List<Vehicle> findAll() throws SQLException;
	public String getColor(String vehicleNo);
	public int countAll();
}
