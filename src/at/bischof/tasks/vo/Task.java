package at.bischof.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task {

	private String name; 
	private int id; 
	
	
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	public Task(String name, int id)
	{
		this.name = name;
		this.id = id; 
		
	}

	public String getName() {
		return name;
	}
	
	


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
