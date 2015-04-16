package at.bischof.tasks.dao;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import at.bischof.tasks.vo.Login;

public class LoginDAO {

	public boolean checkLogin(Login l) throws SQLException {
		
//		try{
//			String value = l.getEmail();
//			 
//			MessageDigest md = MessageDigest.getInstance("SHA-256");
//			md.update(value.getBytes());
//		 
//			byte byteData[] = md.digest();
//		 
//			//konvertiere byte nach hex
//			StringBuffer sb = new StringBuffer();
//			for (int i = 0; i < byteData.length; i++) 
//			{
//				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
//			}
//		 
//			l.setPasswd(sb.toString());
//		}
//    	catch(Exception e){
//    		
//    	}
//		System.out.println(l.getPasswd());
		
		
		
		String sql = String
				.format("Select * From tbl_user WHERE email = \"%s\" AND passwd = \"%s\"",
						l.getEmail(),l.getPasswd());
		

		ResultSet s = getConnection().createStatement().executeQuery(sql);

		while (s.next()) {
			s.getString(1);
		}
		return s.first();

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
