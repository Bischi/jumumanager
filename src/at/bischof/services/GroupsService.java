package at.bischof.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import at.bischof.tasks.dao.GroupDAO;
import at.bischof.tasks.vo.Group;


@Path("groups")
public class GroupsService {

	
	
		
		@GET
		public List<Group> getAllGroups() throws SQLException{
			GroupDAO dao = new GroupDAO();
			return dao.getAllGroups(); 
		}
		
		@POST
		public Response insertGroup(Group g){
			GroupDAO dao = new GroupDAO();
			try {
				dao.insertGroup(g);
				return Response.ok().build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
				
			} 
		}
		
		@PUT
		public Response updateGroup(Group g){
			GroupDAO dao = new GroupDAO();
			try {
				dao.updateGroup(g);
				return Response.ok().build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
				
			} 
		}
		
		@GET
		@Path("/{id}")
		public Group getGroupById(@PathParam("id") int mid){ //id (aus get) wird in mid gespeichert 
			GroupDAO dao = new GroupDAO();
			Group g = dao.getGroupById(mid);
			
			return g;
			
		}
		
		@DELETE
		@Path("/{id}")
		public Response deleteGroup(@PathParam("id") int mid){
			
			try {
				GroupDAO dao = new GroupDAO();
				dao.deleteGroup(mid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Response.serverError().build();
			}
			return Response.ok().build();
			
			
		}
}
