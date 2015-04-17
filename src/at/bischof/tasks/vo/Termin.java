package at.bischof.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Termin {
	
	private String name;
	private String date;
	private String starttime;
	private String endtime;
	private int id;
	private String fk_typ;
	
	
	
	
	public Termin(String name, String date, String starttime, String endtime, int id, String color,String fk_typ){
		this.name = name;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
		this.id = id;
		this.fk_typ = fk_typ;
		
		
	}
	public Termin(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFk_typ() {
		return fk_typ;
	}
	public void setFk_typ(String fk_typ) {
		this.fk_typ = fk_typ;
	}
	
	
	
	
	
	
	
	
	
	
	

}
