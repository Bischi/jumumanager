package at.bischof.tasks.vo;

public class Termin {
	
	private String name;
	private String date;
	private String starttime;
	private String endtime;
	private int id;
	private int fk_typ;
	
	public Termin(String name, String date, String starttime, String endtime, int id, int fk_typ ){
		this.name = name;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
		this.id = id;
		this.fk_typ = fk_typ;
	}
	
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

}
