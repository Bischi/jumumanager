package at.bischof.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.bischof.tasks.dao.RightDAO;
import at.bischof.tasks.vo.Right;

@Path("rights")
public class RightService {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Right> getAllUsers() throws SQLException{
		RightDAO dao = new RightDAO();
		return dao.getAllRights(); 
	}
	
}
