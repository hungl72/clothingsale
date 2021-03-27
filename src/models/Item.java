package models;

public class Item {
	private Product product;
	private ProductDetail productDetail;
	private int amountItem;
	public Item() {
		super();
	}
	public Item(Product product, int amountItem) {
		super();
		this.product = product;
		this.amountItem = amountItem;
	}
	public Item(ProductDetail productDetail, int amountItem) {
		super();
		this.productDetail = productDetail;
		this.amountItem = amountItem;
	}
	
	public ProductDetail getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getAmountItem() {
		return amountItem;
	}
	public void setAmountItem(int amountItem) {
		this.amountItem = amountItem;
	}
	
}
