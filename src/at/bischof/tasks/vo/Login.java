package at.bischof.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Login {
	
	private String email;
	private String passwd;
	private boolean check;
	
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public Login(){}
	
	public Login(String email, String passwd){
		this.email = email;
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	

	
	
}
