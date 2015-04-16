package at.bischof.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Probentyp {
	
	private int id;
	private String typ;
	private String color;
	
	public Probentyp(int id, String typ, String color){
		this.id = id;
		this.typ = typ;
		this.color = color;
	}
	
	public Probentyp(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
