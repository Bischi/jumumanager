package at.bischof.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String fname; 
	private String lname;
	private String email;
	private String password;
	private int id; 
	private int fk_presence_fk_user;
	private int fk_instrument_id;
	private int fk_groups_id;
	private int fk_rights_id;
	
		
	public User( String fame, String lname, String email, String password, int id){
		this.fname = fame;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.id = id;
		
	}
	
	public String getFname(){
		return fname;
	}
	
	public String getLname(){
		return lname;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public int getFk_presence_fk_user(){
		return fk_presence_fk_user;
	}
	
	public int getFk_instrument_id(){
		return fk_instrument_id;
	}
	
	public int getFk_groups_id(){
		return fk_groups_id;
	}
	
	public int getFk_rights_id(){
		return fk_rights_id;
	}
	
	public int getId(){
		return id;
	}
	
	
	
	
}
