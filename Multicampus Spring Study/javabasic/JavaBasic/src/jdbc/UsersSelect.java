package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import jdbc.user.vo.UserVO;

public class UsersSelect {
	
	@Test
	public void Test() throws Exception{
		try {
			//Call Class
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}	
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "Scott";
		String password = "tiger";
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			
			System.out.println(connection.getClass().getName());
			stmt = connection.createStatement();
			System.out.println(stmt.getClass().getName());
			
			String sql = "SELECT * FROM USERS";
			rs = stmt.executeQuery(sql);
			
			UserVO userVO = null;
			List<UserVO> userList = new ArrayList<UserVO>();
			
			
			while (rs.next()) {
				String userid = rs.getString("userid");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String city = rs.getString("city");
				userVO = new UserVO(userid, name, gender.charAt(0), city);
				userList.add(userVO);
				System.out.println(userVO);
			}
			System.out.println(userList);
			
		} catch (SQLTimeoutException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(rs != null) {				
				rs.close();
			}
			if(stmt != null ) {
				stmt.close();				
			}
			if(connection != null) {
				connection.close();				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
	}

}
