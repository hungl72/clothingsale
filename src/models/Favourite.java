package models;

public class Favourite {
	private int favourite_id;
	private String favourite_name;
	private int favourite_amount;
	private double favourite_price;
	public Favourite() {
		super();
	}
	public Favourite(int favourite_id, String favourite_name, int favourite_amount, double favourite_price) {
		super();
		this.favourite_id = favourite_id;
		this.favourite_name = favourite_name;
		this.favourite_amount = favourite_amount;
		this.favourite_price = favourite_price;
	}
	public int getFavourite_id() {
		return favourite_id;
	}
	public void setFavourite_id(int favourite_id) {
		this.favourite_id = favourite_id;
	}
	public String getFavourite_name() {
		return favourite_name;
	}
	public void setFavourite_name(String favourite_name) {
		this.favourite_name = favourite_name;
	}
	public int getFavourite_amount() {
		return favourite_amount;
	}
	public void setFavourite_amount(int favourite_amount) {
		this.favourite_amount = favourite_amount;
	}
	public double getFavourite_price() {
		return favourite_price;
	}
	public void setFavourite_price(double favourite_price) {
		this.favourite_price = favourite_price;
	}
	
}
