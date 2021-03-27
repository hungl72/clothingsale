package models;

public class Comment {
	private int id;
	private String user;
	private String detail;
	private String time;
	private int idcategories;
	public Comment() {
		
	}
	public Comment(int id, String user, String detail, String time,int idcategories) {
		super();
		this.id = id;
		this.user = user;
		this.detail = detail;
		this.time = time;
		this.idcategories = idcategories;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getIdproduct() {
		return idcategories;
	}
	public void setIdproduct(int idproduct) {
		this.idcategories = idproduct;
	}	
	
	
}
