package at.bischof.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.bischof.tasks.dao.ProbentypDAO;
import at.bischof.tasks.vo.Probentyp;

@Path("types")
public class ProbentypService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Probentyp> getAllTypes() throws SQLException {
		ProbentypDAO dao = new ProbentypDAO();
		return dao.getAllTypes();
	}
}
