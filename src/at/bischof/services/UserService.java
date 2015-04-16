package at.bischof.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import at.bischof.tasks.dao.UserDAO;
import at.bischof.tasks.vo.Right;
import at.bischof.tasks.vo.User;

@Path("users")
public class UserService {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<User> getAllUsers() throws SQLException{
		UserDAO dao = new UserDAO();
		return dao.getAllUsers(); 
	}
	
	@POST
	public Response insertUser(User u){
		UserDAO dao = new UserDAO();
		try {
			dao.insertUser(u);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@PUT
	@Path("/{id}")
	public Response updateUser(User u, @PathParam("id") int mid){
		UserDAO dao = new UserDAO();
		try {
			dao.updateUser(u, mid);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("/{id}")
	public User getUserById(@PathParam("id") int mid){ //id (aus get) wird in mid gespeichert 
		UserDAO dao = new UserDAO();
		User u = dao.getUserById(mid);
		
		return u;
		
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int mid){
		
		try {
			UserDAO dao = new UserDAO();
			dao.deleteUser(mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
		
	}
	
	@GET
	@Path("rights")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Right> getRights() throws SQLException{
		UserDAO dao = new UserDAO();
		return dao.getRights(); 
	}
	

}
