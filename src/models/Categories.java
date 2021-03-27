package models;

public class Categories {
	private int categories_id;
	private String categories_name;
	private int parent_id;
	public Categories() {
		super();
	}
	public Categories(int categories_id, String categories_name, int parent_id) {
		super();
		this.categories_id = categories_id;
		this.categories_name = categories_name;
		this.parent_id = parent_id;
	}
	public Categories(int categories_id, String categories_name) {
		super();
		this.categories_id = categories_id;
		this.categories_name = categories_name;
	}
	public Categories(String categories_name) {
		super();
		this.categories_name = categories_name;
	}
	public int getCategories_id() {
		return categories_id;
	}
	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}
	public String getCategories_name() {
		return categories_name;
	}
	public void setCategories_name(String categories_name) {
		this.categories_name = categories_name;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	
}
