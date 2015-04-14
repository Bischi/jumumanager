package at.bischof.tasks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import at.bischof.tasks.vo.Login;

public class LoginDAO {
	
	public boolean checkLogin(Login l) throws SQLException{
		
		String sql = "Select * From tbl_user WHERE email = ? AND passwd = ?";
		PreparedStatement ps; 
		
		ps = getConnection().prepareStatement(sql);
		ps.setString(1, l.getEmail());
		ps.setString(2, l.getPasswd());
		ps.execute();
		
		if(ps.execute()==true){
		
		return true;
		}
		else{
			return false;
		}
	}
	
	private Connection getConnection() {
		try {
			Connection conn;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/jumumanager?"
							+ "user=root&password=");
			return conn;
			// Do something with the Connection
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
