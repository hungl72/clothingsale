package models;

public class Order {
	private int order_id;
	private String order_brand;
	private String order_color;
	private String order_size;
	private String order_material;
	private String order_origin;
	private int order_amount;
	private double order_total;
	private String order_message;
	private String order_user;
	private String order_address;
	public Order() {
		super();
	}
	
	public Order(int order_id,String order_brand, String order_color, String order_size, String order_material, String order_origin,
			int order_amount, double order_total, String order_message, String order_user,
			String order_address) {
		super();
		this.order_id = order_id;
		this.order_brand = order_brand;
		this.order_color = order_color;
		this.order_size = order_size;
		this.order_material = order_material;
		this.order_origin = order_origin;
		this.order_amount = order_amount;
		this.order_total = order_total;
		this.order_message = order_message;
		this.order_user = order_user;
		this.order_address = order_address;
	}
	public Order(String order_brand, String order_color, String order_size, String order_material, String order_origin,
			int order_amount, double order_total, String order_message, String order_user,
			String order_address) {
		super();
		this.order_brand = order_brand;
		this.order_color = order_color;
		this.order_size = order_size;
		this.order_material = order_material;
		this.order_origin = order_origin;
		this.order_amount = order_amount;
		this.order_total = order_total;
		this.order_message = order_message;
		this.order_user = order_user;
		this.order_address = order_address;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_brand() {
		return order_brand;
	}
	public void setOrder_brand(String order_brand) {
		this.order_brand = order_brand;
	}
	public String getOrder_color() {
		return order_color;
	}
	public void setOrder_color(String order_color) {
		this.order_color = order_color;
	}
	public String getOrder_size() {
		return order_size;
	}
	public void setOrder_size(String order_size) {
		this.order_size = order_size;
	}
	public String getOrder_material() {
		return order_material;
	}
	public void setOrder_material(String order_material) {
		this.order_material = order_material;
	}
	public String getOrder_origin() {
		return order_origin;
	}
	public void setOrder_origin(String order_origin) {
		this.order_origin = order_origin;
	}
	public int getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}
	public double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}
	public String getOrder_message() {
		return order_message;
	}
	public void setOrder_message(String order_message) {
		this.order_message = order_message;
	}
	public String getOrder_user() {
		return order_user;
	}
	public void setOrder_user(String order_user) {
		this.order_user = order_user;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	
}
