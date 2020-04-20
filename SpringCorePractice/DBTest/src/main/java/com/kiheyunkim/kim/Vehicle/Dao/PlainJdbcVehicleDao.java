package com.kiheyunkim.kim.Vehicle.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class PlainJdbcVehicleDao extends NamedParameterJdbcDaoSupport implements VehicleDao{
	public class VehicleRowMapper implements RowMapper<Vehicle>{
		@Override
		public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
			return toVehicle(rs);
		}
	}
	
	private static final String INSERT_SQL = "INSERT INTO VEHICLE (COLOR, WHEEL,SEAT, VEHICLE_NO)"
			+ "VALUES (:color, :wheel, :seat, :vehicleNo)";
	private static final String UPDATE_SQL = "UPDATE VEHICLE SET COLOR = ?, WHEEL = ?, SEAT = ? "
			+ "WHERE VEHICLE+NO = ?";
	private static final String SELECT_ALL_SQL = "SELECT * FROM VEHICLE";
	private static final String SELECT_ONE_SQL = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
	
	private static final String COUNT_ALL_SQL = "SELECT COUNT(*) FROM VEHICLE";
	private static final String SELECT_COLOR_SQL = "SELECT COLOR FROM VEHICLE WHERE VEHICLE_NO = ?";

	public PlainJdbcVehicleDao() {
	}
	
	private Map<String,Object> toParameterMap(Vehicle vehicle){
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("VehicleNo", vehicle.getVehicleNo());
		parameters.put("color",vehicle.getColor());
		parameters.put("wheel",vehicle.getWheel());
		parameters.put("seat",vehicle.getSeat());
		return parameters;
	}
	
	@Override
	public void insert(Vehicle vehicle) throws SQLException{
		/* 1번
		getNamedParameterJdbcTemplate().update(INSERT_SQL, toParameterMap(vehicle));
		*/
		
		/* 2번
		SqlParameterSource parameterSource = new MapSqlParameterSource(toParameterMap((vehicle)));
		 */
		
		/* 3번 */
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vehicle);
		getNamedParameterJdbcTemplate().update(INSERT_SQL, parameterSource);
	}

	@Override
	public void insert(Collection<Vehicle> vehicles) {
		SqlParameterSource[] sources = vehicles.stream()
				.map(v -> new BeanPropertySqlParameterSource(v))
				.toArray(size-> new SqlParameterSource[size]);
		getNamedParameterJdbcTemplate().batchUpdate(INSERT_SQL, sources);
		
		
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
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		//3번 케이스
		return jdbcTemplate.queryForObject(SELECT_ONE_SQL, 
				BeanPropertyRowMapper.newInstance(Vehicle.class),vehicleNo);
		
		//2번 케이스
		/*
		return jdbcTemplate.queryForObject(SELECT_ONE_SQL, new VehicleRowMapper(), vehicleNo);
		*/
		
		//1번 케이스
		/*
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
		*/
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
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(SELECT_ALL_SQL);
		return rows.stream().map(row->{
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleNo((String)row.get("VEHICLE_NO"));
			vehicle.setColor((String)row.get("COLOR"));
			vehicle.setWheel((int)row.get("WHEEL"));
			vehicle.setSeat((int)row.get("SEAT"));
			return vehicle;
		}).collect(Collectors.toList());
		
		/*
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
		*/
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

	@Override
	public String getColor(String vehicleNo) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		return jdbcTemplate.queryForObject(SELECT_COLOR_SQL, String.class, vehicleNo);
	}

	@Override
	public int countAll() {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		return jdbcTemplate.queryForObject(COUNT_ALL_SQL, Integer.class);
	}

}


