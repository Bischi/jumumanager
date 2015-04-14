package at.bischof.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Group {

	private String name; 
	
	private int id; 
	
	public Group(){
		
	}
	
	public Group(int _id, String name){
		this.name = name;
		this.id = _id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
