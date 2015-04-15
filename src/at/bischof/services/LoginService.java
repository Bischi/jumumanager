package at.bischof.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import at.bischof.tasks.dao.LoginDAO;
import at.bischof.tasks.vo.Login;

@Path("logincheck")
public class LoginService {
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes("application/json")
	public Response checkLogin(Login l){
		System.out.println("hit");
		LoginDAO dao = new LoginDAO();
		try {
			dao.checkLogin(l);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
}
