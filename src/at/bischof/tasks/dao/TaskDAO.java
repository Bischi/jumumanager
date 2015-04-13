package at.bischof.tasks.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import com.mysql.jdbc.Statement;

import at.bischof.tasks.vo.Task;

public class TaskDAO {
	
	public List<Task> getAllTasks() throws SQLException
	{
		List<Task> tList = new ArrayList<Task>();
		
		String sql = "SELECT * from tbl_tasks";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		if(!rs.first())
		{
			return tList;
		}
		
		while(!rs.isAfterLast())
		{
			Task t = new Task(rs.getString(2), rs.getInt(1));
			tList.add(t);
			rs.next();
		}
		
		return tList;
	}
	
	public Task getTaskById(int mid){
		String selectStatement = "SELECT from tbl_tasks WHERE id = ?";
		PreparedStatement ps;
		
		try {
			ps = getConnection().prepareStatement(selectStatement);
			ps.setInt(1, mid);
					
			ResultSet rs = ps.executeQuery();
			Task t = new Task(rs.getString(2), rs.getInt(1));
			return t;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
			
		}
	}
	
	public void insertTask(Task t){
	
		String insertStatement = "Insert INTO tbl_tasks (name)VALUES(?)";
		
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(insertStatement);
			ps.setString(1, t.getName());
					
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public void updateTask(Task t){
		
		String updateStatement = "UPDATE tbl_tasks SET name = ? WHERE id = ?";
		PreparedStatement ps;
		
		try {
			ps = getConnection().prepareStatement(updateStatement);
			ps.setString(1, t.getName());
			ps.setInt(2, t.getId());
					
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
	private Connection getConnection() 
	{
		try {
			Connection conn;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/resttask?" +
		                                   "user=root&password=");
			return conn;
		    // Do something with the Connection
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
		
	
	
	
	
}


