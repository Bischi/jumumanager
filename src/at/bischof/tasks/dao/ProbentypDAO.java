package at.bischof.tasks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import at.bischof.tasks.vo.Probentyp;
import at.bischof.tasks.vo.Right;

public class ProbentypDAO {

	public List<Probentyp> getAllTypes() {

		try {
			List<Probentyp> ptList = new ArrayList<Probentyp>();

			String sql = "Select * From tbl_typ";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return ptList;
			}

			while (!rs.isAfterLast()) {
				Probentyp pt = new Probentyp(rs.getInt(1), rs.getString(2),rs.getString(3));
				ptList.add(pt);
				rs.next();
			}

			return ptList;
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
