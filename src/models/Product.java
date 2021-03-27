package models;

public class Product {
	private int product_id;
	private String product_name;
	private String product_image;
	private String product_description;
	private int category_id;
	private int parent_id;
	public Product() {
		super();
	}
	public Product(int product_id, String product_name, String product_image,
			String product_description, int category_id, int parent_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_description = product_description;
		this.category_id = category_id;
		this.parent_id = parent_id;
	}
	public Product(int product_id, String product_name, String product_image,
			String product_description, int category_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_description = product_description;
		this.category_id = category_id;
	}
	public Product(int product_id, String product_name) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	
}
