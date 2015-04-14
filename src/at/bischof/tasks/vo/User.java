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

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFk_presence_fk_user(int fk_presence_fk_user) {
		this.fk_presence_fk_user = fk_presence_fk_user;
	}

	public void setFk_instrument_id(int fk_instrument_id) {
		this.fk_instrument_id = fk_instrument_id;
	}

	public void setFk_groups_id(int fk_groups_id) {
		this.fk_groups_id = fk_groups_id;
	}

	public void setFk_rights_id(int fk_rights_id) {
		this.fk_rights_id = fk_rights_id;
	}
	
	
	
	
	
}
