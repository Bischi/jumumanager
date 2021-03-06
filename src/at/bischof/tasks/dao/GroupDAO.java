package at.bischof.tasks.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import at.bischof.tasks.vo.Group;

public class GroupDAO {

	public List<Group> getAllGroups() {

		try {
			List<Group> gList = new ArrayList<Group>();

			String sql = "SELECT * from tbl_groups";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return gList;
			}

			while (!rs.isAfterLast()) {
				Group g = new Group(rs.getInt(1), rs.getString(2));
				gList.add(g);
				rs.next();
			}

			return gList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Group getGroupById(int mid) {
		String selectStatement = "SELECT from tbl_groups WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(selectStatement);
			ps.setInt(1, mid);

			ResultSet rs = ps.executeQuery();
			Group g = new Group(rs.getInt(1), rs.getString(2));
			return g;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;

		}
	}

	public void insertGroup(Group g) {

		String insertStatement = "Insert INTO tbl_groups (name)VALUES(?)";

		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(insertStatement);
			ps.setString(1, g.getName());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void updateGroup(Group g, int mid) {

		String updateStatement = "UPDATE tbl_groups SET name = ? WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(updateStatement);
			ps.setString(1, g.getName());
			ps.setInt(2, mid);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void deleteGroup(int mid) {

		String deleteStatement = "DELETE FROM tbl_groups WHERE id = ?";
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
