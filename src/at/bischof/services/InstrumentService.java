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
import at.bischof.tasks.dao.InstrumentDAO;
import at.bischof.tasks.vo.Group;
import at.bischof.tasks.vo.Instrument;


@Path("instruments")

public class InstrumentService {

	@GET
	public List<Instrument> getAllInstruments() throws SQLException{
		InstrumentDAO dao = new InstrumentDAO();
		return dao.getAllInstruments(); 
	}
	
	@POST
	public Response insertInstrument(Instrument i){
		InstrumentDAO dao = new InstrumentDAO();
		try {
			dao.insertInstrument(i);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@PUT
	public Response updateInstrument(Instrument i){
		InstrumentDAO dao = new InstrumentDAO();
		try {
			dao.updateInstrument(i);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@GET
	@Path("/{id}")
	public Instrument getInstrumentById(@PathParam("id") int mid){ //id (aus get) wird in mid gespeichert 
		InstrumentDAO dao = new InstrumentDAO();
		Instrument i = dao.getInstrumentById(mid);
		
		return i;
		
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteInstrument(@PathParam("id") int mid){
		
		try {
			InstrumentDAO dao = new InstrumentDAO();
			dao.deleteInstrument(mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
		
	}
		
		
	
}
