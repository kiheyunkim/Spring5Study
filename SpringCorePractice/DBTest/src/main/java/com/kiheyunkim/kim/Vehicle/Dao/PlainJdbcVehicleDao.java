package com.kiheyunkim.kim.Vehicle.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;


public class PlainJdbcVehicleDao implements VehicleDao{
	
	private static final String INSERT_SQL = "INSERT INTO VEHICLE (COLOR, WHEEL,SEAT, VEHICLE_NO)"
			+ "VALUES (?,?,?,?)";
	private static final String UPDATE_SQL = "UPDATE VEHICLE SET COLOR = ?, WHEEL = ?, SEAT = ? "
			+ "WHERE VEHICLE+NO = ?";
	private static final String SELECT_ALL_SQL = "SELECT * FROM VEHICLE";
	private static final String SELECT_ONE_SQL = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
	
	private final DataSource dataSource;

	public PlainJdbcVehicleDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insert(Vehicle vehicle) throws SQLException{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SQL);
				preparedStatement(ps, vehicle);
				return ps;
			}
		});
		/*
		jdbcTemplate.update(con->{
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			preparedStatement(ps, vehicle);
			return ps;
		});
		*/
	}

	@Override
	public void insert(Iterable<Vehicle> vehicles) {
		vehicles.forEach(elem -> {
			try {
				insert(elem);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});				
	}

	@Override
	public Vehicle findByVehicleNo(String vehicleNo) throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		final Vehicle vehicle = new Vehicle();
		jdbcTemplate.query(SELECT_ONE_SQL, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				vehicle.setVehicleNo(rs.getString("VEHICLE_NO"));
				vehicle.setColor(rs.getString("COLOR"));
				vehicle.setWheel(rs.getInt("WHEEL"));
				vehicle.setSeat(rs.getInt("SEAT"));
			}
		},vehicleNo);
		
		return vehicle;
	}
	
	@Override
	public void update(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Vehicle> findAll() throws SQLException {
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
				ResultSet rs = ps.executeQuery()){
			
			List<Vehicle> vehicles = new ArrayList<Vehicle>();
			while (rs.next()) {
				vehicles.add(toVehicle(rs));
			}
			
			return vehicles;
		}catch (Exception e) {
			throw new SQLException();
		}
	}
	
	private Vehicle toVehicle(ResultSet rs) throws SQLException{
		Vehicle vehicle = new Vehicle();
		
		vehicle.setVehicleNo(rs.getString("VEHICLE_NO"));
		vehicle.setColor(rs.getString("COLOR"));
		vehicle.setWheel(rs.getInt("WHEEL"));
		vehicle.setSeat(rs.getInt("SEAT"));
		
		return vehicle;
	}
	
	private void preparedStatement(PreparedStatement ps, Vehicle vehicle) throws SQLException{
		ps.setString(1, vehicle.getColor());
		ps.setInt(2, vehicle.getWheel());
		ps.setInt(3, vehicle.getSeat());
		ps.setString(4, vehicle.getVehicleNo());
	}

}
