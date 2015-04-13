package at.bischof.tasks.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import sun.security.action.GetIntegerAction;
import at.bischof.tasks.vo.User;

public class UserDAO {

	public List<User> getAllUsers() {

		try {
			List<User> uList = new ArrayList<User>();

			String sql = "Select u.id, u.fname, u.lname, u.email, u.passwd, inst.name, grp.name, ri.name From tbl_user u inner join tbl_instrument inst ON u.tbl_instrument_id = inst.id inner join tbl_groups grp ON u.tbl_groups_id = grp.id inner join tbl_rights ri ON u.tbl_rights_id = ri.id;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return uList;
			}

			while (!rs.isAfterLast()) {
				User u = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(1));
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
		String selectStatement = "SELECT from tbl_user WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(selectStatement);
			ps.setInt(1, mid);

			ResultSet rs = ps.executeQuery();
			User u = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(1));
			return u;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;

		}
	}

	public void insertUser(User u) {

		String insertStatement = "Insert INTO tbl_user (name)VALUES(?)";

		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(insertStatement);
			ps.setString(1, u.getFname());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void updateUser(User u) {

		String updateStatement = "UPDATE tbl_user SET name = ? WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(updateStatement);
			ps.setString(1, u.getFname());
			ps.setInt(2, u.getId());

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
