package at.bischof.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import at.bischof.tasks.dao.TaskDAO;
import at.bischof.tasks.vo.Task;


@Path("tasks")
public class TaskService {
	
	@GET
	public List<Task> getAllTasks(){
		TaskDAO dao = new TaskDAO();
		try {
			return dao.getAllTasks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@POST
	public Response insertTask(Task t){
		TaskDAO dao = new TaskDAO();
		try {
			dao.insertTask(t);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@PUT
	public Response updateTask(Task t){
		TaskDAO dao = new TaskDAO();
		try {
			dao.updateTask(t);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@GET
	@Path("/{id}")
	public Task getTaskById(@PathParam("id") int mid){ //id (aus get) wird in mid gespeichert 
		TaskDAO dao = new TaskDAO();
		Task t = dao.getTaskById(mid);
		
		return t;
		
	}
}

