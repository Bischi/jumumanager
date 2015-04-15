package at.bischof.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import at.bischof.tasks.dao.LoginDAO;
import at.bischof.tasks.vo.Login;

@Path("logincheck")
public class LoginService {
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes("application/json")
	public Response checkLogin(Login l){
		System.out.println(l.getEmail());
		LoginDAO dao = new LoginDAO();
		try {
			return dao.checkLogin(l) ?  Response.ok().cookie(new NewCookie("ssid", "12345")).build() : Response.status(403).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).build();			
		} 
	}
}
