package models;

public class Picture {
	private int picture_id;
	private String picture_name;
	private int product_detail_id;
	public Picture() {
		super();
	}
	public Picture(int picture_id, String picture_name, int product_detail_id) {
		super();
		this.picture_id = picture_id;
		this.picture_name = picture_name;
		this.product_detail_id = product_detail_id;
	}
	public Picture(String picture_name, int product_detail_id) {
		super();
		this.picture_name = picture_name;
		this.product_detail_id = product_detail_id;
	}
	public int getPicture_id() {
		return picture_id;
	}
	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
	}
	public String getPicture_name() {
		return picture_name;
	}
	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}
	public int getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(int product_detail_id) {
		this.product_detail_id = product_detail_id;
	}
	
}
