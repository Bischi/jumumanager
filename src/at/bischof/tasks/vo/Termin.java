package at.bischof.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Termin {
	
	private String name;
	private String date;
	private String starttime;
	private String endtime;
	private int id;
	private int fk_typ;
	private String color;
	private String typName;
	
	public Termin(String name, String date, String starttime, String endtime, int id, String color, String typName ){
		this.name = name;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
		this.id = id;
		this.color = color;
		this.typName = typName;
	}
	public Termin(){}
	
	
	public String getName(){
		return name;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getStarttime(){
		return starttime;
	}
	
	public String getEndtime(){
		return endtime;
	}
	
	public int getId(){
		return id;
	}
	
	public int getFkTyp(){
		return fk_typ;
	}
	
	public String getColor(){
		return color;
	}
	
	public String getTypName(){
		return typName;
	}

	public int getFk_typ() {
		return fk_typ;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setTypName(String typName) {
		this.typName = typName;
	}
	
	

}
