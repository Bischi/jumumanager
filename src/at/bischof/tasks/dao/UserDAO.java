package at.bischof.tasks.dao;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import at.bischof.tasks.vo.Right;
import at.bischof.tasks.vo.User;

public class UserDAO {

	public List<User> getAllUsers() {

		try {
			List<User> uList = new ArrayList<User>();

			String sql = "Select u.id, u.fname, u.lname, u.email, u.passwd, u.token, inst.name, grp.name, ri.name From tbl_user u inner join tbl_instrument inst ON u.tbl_instrument_id = inst.id inner join tbl_groups grp ON u.tbl_groups_id = grp.id inner join tbl_rights ri ON u.tbl_rights_id = ri.id";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return uList;
			}

			while (!rs.isAfterLast()) {
				User u = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(1),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(5));
				uList.add(u);
				rs.next();
			}

			return uList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public User getUserById(int mid) {
		String selectStatement = "SELECT u.fname, u.lname, u.email, u.passwd, u.token, inst.name, grp.name, ri.name From tbl_user u inner join tbl_instrument inst ON u.tbl_instrument_id = inst.id inner join tbl_groups grp ON u.tbl_groups_id = grp.id inner join tbl_rights ri ON u.tbl_rights_id = ri.id; WHERE u.id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(selectStatement);
			ps.setInt(1, mid);

			ResultSet rs = ps.executeQuery();
			User u = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(1),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			return u;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;

		}
	}

	public void insertUser(User u) {

		String insertStatement = "Insert INTO tbl_user (fname,lname,email,passwd,token,tbl_instrument_id,tbl_groups_id,tbl_rights_id)VALUES(?,?,?,?,?,?,?,?)";

		
		String token = UUID.randomUUID().toString().toUpperCase();
	     
		u.setToken(token);
		
		System.out.println(u.getToken());
		try{
			String value = u.getPassword();
			
			
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(value.getBytes());
		 
			byte byteData[] = md.digest();
		 
			//konvertiere byte nach hex
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) 
			{
				sb.append(Integer.toString(byteData[i]));
			}
			u.setPassword(sb.toString());
			System.out.println(u.getPassword());
		}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
		
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(insertStatement);
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getToken());
			ps.setString(6, u.getFk_instrument_id());
			ps.setString(7, u.getFk_groups_id());
			ps.setString(8, u.getFk_rights_id());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void updateUser(User u, int mid) {

		String updateStatement = "UPDATE tbl_user SET fname = ?, lname = ?, email = ?, tbl_instrument_id = ?, tbl_rights_id = ? WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(updateStatement);
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getFk_instrument_id());
			ps.setString(5, u.getFk_rights_id());
			ps.setInt(6, mid);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void deleteUser(int mid) {

		String deleteStatement = "DELETE FROM tbl_user WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(deleteStatement);
			ps.setInt(1, mid);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	
	public List<Right> getRights(){
		
		try {
			List<Right> rList = new ArrayList<Right>();

			String sql = "Select * From tbl_rights Where id != 3";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return rList;
			}

			while (!rs.isAfterLast()) {
				Right r = new Right(rs.getInt(1),rs.getString(2));
				rList.add(r);
				rs.next();
			}

			return rList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private Connection getConnection() {
		try {
			Connection conn;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/jumumanager?"
							+ "user=root&password=root123");
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
