package at.bischof.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Group {

	private String name; 
	private int _id; 
	
	public Group(){
		
	}
	
	public Group(int _id, String name){
		this.name = name;
		this._id = _id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId(){
		return _id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	
}
