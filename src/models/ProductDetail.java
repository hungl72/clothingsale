package models;

public class ProductDetail {
	private int product_detail_id;
	private String product_detail_brand;
	private String product_detail_color;
	private String product_detail_size;
	private String product_detail_material;
	private String product_detail_origin;
	private Double product_detail_price;
	private int product_id;
	private int product_detail_amount;
	private int categories_id;
	private int amount;
	private String product_detail_image;
	public ProductDetail() {
		super();
	}
	public ProductDetail(int product_detail_id, String product_detail_brand, String product_detail_color,
			String product_detail_size, String product_detail_material, String product_detail_origin,Double product_detail_price, int product_id,
			int product_detail_amount, int categories_id) {
		super();
		this.product_detail_id = product_detail_id;
		this.product_detail_brand = product_detail_brand;
		this.product_detail_color = product_detail_color;
		this.product_detail_size = product_detail_size;
		this.product_detail_material = product_detail_material;
		this.product_detail_origin = product_detail_origin;
		this.product_detail_price = product_detail_price;
		this.product_id = product_id;
		this.product_detail_amount = product_detail_amount;
		this.categories_id = categories_id;
	}
	public ProductDetail(int product_detail_id, String product_detail_brand, String product_detail_color,
			String product_detail_size, String product_detail_material, String product_detail_origin, int product_id,
			int product_detail_amount, int categories_id) {
		super();
		this.product_detail_id = product_detail_id;
		this.product_detail_brand = product_detail_brand;
		this.product_detail_color = product_detail_color;
		this.product_detail_size = product_detail_size;
		this.product_detail_material = product_detail_material;
		this.product_detail_origin = product_detail_origin;
		this.product_id = product_id;
		this.product_detail_amount = product_detail_amount;
		this.categories_id = categories_id;
	}
	public ProductDetail(int product_detail_id, String product_detail_brand, String product_detail_color,
			String product_detail_size, String product_detail_material, String product_detail_origin, int product_id,
			int product_detail_amount, int categories_id,int amount) {
		super();
		this.product_detail_id = product_detail_id;
		this.product_detail_brand = product_detail_brand;
		this.product_detail_color = product_detail_color;
		this.product_detail_size = product_detail_size;
		this.product_detail_material = product_detail_material;
		this.product_detail_origin = product_detail_origin;
		this.product_id = product_id;
		this.product_detail_amount = product_detail_amount;
		this.categories_id = categories_id;
		this.amount = amount;
	}
	public ProductDetail(int product_detail_id, String product_detail_brand, String product_detail_color,
			String product_detail_size, String product_detail_material, String product_detail_origin,
			int product_detail_amount, Double product_detail_price, String product_detail_image) {
		super();
		this.product_detail_id = product_detail_id;
		this.product_detail_brand = product_detail_brand;
		this.product_detail_color = product_detail_color;
		this.product_detail_size = product_detail_size;
		this.product_detail_material = product_detail_material;
		this.product_detail_origin = product_detail_origin;
		this.product_detail_amount = product_detail_amount;
		this.product_detail_price = product_detail_price;
		this.product_detail_image = product_detail_image;
	}
	public ProductDetail(int product_detail_id, String product_detail_brand, String product_detail_color,
			String product_detail_size, String product_detail_material, String product_detail_origin, int product_id,
			int product_detail_amount, int categories_id,Double product_detail_price,String product_detail_image) {
		super();
		this.product_detail_id = product_detail_id;
		this.product_detail_brand = product_detail_brand;
		this.product_detail_color = product_detail_color;
		this.product_detail_size = product_detail_size;
		this.product_detail_material = product_detail_material;
		this.product_detail_origin = product_detail_origin;
		this.product_id = product_id;
		this.product_detail_amount = product_detail_amount;
		this.categories_id = categories_id;
		this.product_detail_price = product_detail_price;
		this.product_detail_image = product_detail_image;
	}
	public ProductDetail(int product_detail_id, String product_detail_brand) {
		super();
		this.product_detail_id = product_detail_id;
		this.product_detail_brand = product_detail_brand;
	}
	public ProductDetail(String product_detail_brand) {
		super();
		this.product_detail_brand = product_detail_brand;
	}
	public int getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(int product_detail_id) {
		this.product_detail_id = product_detail_id;
	}
	public String getProduct_detail_brand() {
		return product_detail_brand;
	}
	public void setProduct_detail_brand(String product_detail_brand) {
		this.product_detail_brand = product_detail_brand;
	}
	public String getProduct_detail_color() {
		return product_detail_color;
	}
	public void setProduct_detail_color(String product_detail_color) {
		this.product_detail_color = product_detail_color;
	}
	public String getProduct_detail_size() {
		return product_detail_size;
	}
	public void setProduct_detail_size(String product_detail_size) {
		this.product_detail_size = product_detail_size;
	}
	public String getProduct_detail_material() {
		return product_detail_material;
	}
	public void setProduct_detail_material(String product_detail_material) {
		this.product_detail_material = product_detail_material;
	}
	public String getProduct_detail_origin() {
		return product_detail_origin;
	}
	public void setProduct_detail_origin(String product_detail_origin) {
		this.product_detail_origin = product_detail_origin;
	}
	public Double getProduct_detail_price() {
		return product_detail_price;
	}
	public void setProduct_detail_price(Double product_detail_price) {
		this.product_detail_price = product_detail_price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_detail_amount() {
		return product_detail_amount;
	}
	public void setProduct_detail_amount(int product_detail_amount) {
		this.product_detail_amount = product_detail_amount;
	}
	public int getCategories_id() {
		return categories_id;
	}
	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getProduct_detail_image() {
		return product_detail_image;
	}
	public void setProduct_detail_image(String product_detail_image) {
		this.product_detail_image = product_detail_image;
	}
	
}
