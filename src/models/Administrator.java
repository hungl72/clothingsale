package models;

public class Administrator {
	private int user_id;
	private String full_name;
	private String email;
	private String name_per;
	private int check_action;
	private String action_code;
	public Administrator() {
		super();
	}
	public Administrator(int user_id) {
		super();
		this.user_id = user_id;
	}
	public Administrator(int user_id, String full_name, String email, String name_per, int check_action,
			String action_code) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.email = email;
		this.name_per = name_per;
		this.check_action = check_action;
		this.action_code = action_code;
	}
	public Administrator(int user_id, String full_name, String email, String name_per) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.email = email;
		this.name_per = name_per;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName_per() {
		return name_per;
	}
	public void setName_per(String name_per) {
		this.name_per = name_per;
	}
	public int getCheck_action() {
		return check_action;
	}
	public void setCheck_action(int check_action) {
		this.check_action = check_action;
	}
	public String getAction_code() {
		return action_code;
	}
	public void setAction_code(String action_code) {
		this.action_code = action_code;
	}
	
}
