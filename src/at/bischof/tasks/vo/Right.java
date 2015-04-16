package at.bischof.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Right {

	private String right;
	private int id;
	
	public Right (int id, String right){
		this.id = id;
		this.right = right;
	}
	
	public Right(){
		
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
