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

import at.bischof.tasks.dao.TerminDAO;
import at.bischof.tasks.vo.Termin;

@Path("termine")
public class TerminService {

	@GET
	public List<Termin> getAllTermins() throws SQLException{
		TerminDAO dao = new TerminDAO();
		return dao.getAllTermins(); 
	}
	
	@POST
	public Response insertTermin(Termin t){
		TerminDAO dao = new TerminDAO();
		try {
			dao.insertTermin(t);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@PUT
	@Path("/{id}")
	public Response updateTermin(Termin t, @PathParam("id") int mid){
		TerminDAO dao = new TerminDAO();
		try {
			dao.updateTermin(t, mid);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@GET
	@Path("/{id}")
	public Termin getTerminById(@PathParam("id") int mid){ //id (aus get) wird in mid gespeichert 
		TerminDAO dao = new TerminDAO();
		Termin t = dao.getTerminById(mid);
		
		return t;
		
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteTermin(@PathParam("id") int mid){
		
		try {
			TerminDAO dao = new TerminDAO();
			dao.deleteTermin(mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
		
	}
	
}
