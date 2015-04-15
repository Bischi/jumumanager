package at.bischof.tasks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import at.bischof.tasks.vo.Termin;



public class TerminDAO {

	public List<Termin> getAllTermins() {

		try {
			List<Termin> tList = new ArrayList<Termin>();

			String sql = "Select t.id, t.name, t.date, t.starttime, t.endtime, typ.name, typ.color From tbl_termin t inner join tbl_typ typ ON t.tbl_typ_id = typ.id ";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return tList;
			}

			while (!rs.isAfterLast()) {
				Termin t = new Termin(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(1),rs.getString(7),rs.getString(6));
				tList.add(t);
				rs.next();
			}

			return tList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public Termin getTerminById(int mid) {
		String selectStatement = "SELECT t.name, t.date, t.starttime, t.endtime, typ.name, typ.color From tbl_termin t inner join tbl_typ typ ON t.tbl_typ_id = typ.id WHERE t.id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(selectStatement);
			ps.setInt(1, mid);

			ResultSet rs = ps.executeQuery();
			Termin t = new Termin(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(1),rs.getString(7),rs.getString(6));
			return t;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;

		}
	}
	
	public void insertTermin(Termin t) {

		String insertStatement = "Insert INTO tbl_termin (name,date,startdate,enddate,tbl_typ_id)VALUES(?,?,?,?,?)";

		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(insertStatement);
			ps.setString(1, t.getName());
			ps.setString(2, t.getDate());
			ps.setString(3, t.getStarttime());
			ps.setString(4, t.getEndtime());
			ps.setInt(5, t.getFkTyp());
			

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	
	public void updateTermin(Termin t, int mid) {

		String updateStatement = "UPDATE tbl_user SET name = ?, date = ?, starttime = ?, endtime = ?, tbl_typ_id = ? WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(updateStatement);
			ps.setString(1, t.getName());
			ps.setString(2, t.getDate());
			ps.setString(3, t.getStarttime());
			ps.setString(4, t.getEndtime());
			ps.setInt(5, t.getFkTyp());
			ps.setInt(6, mid);
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void deleteTermin(int mid) {

		String deleteStatement = "DELETE FROM tbl_termin WHERE id = ?";
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
