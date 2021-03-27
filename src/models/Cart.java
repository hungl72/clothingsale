package models;

import java.util.HashMap;
import java.util.Map;

import com.sun.prism.Image;

public class Cart {
	private HashMap<Integer, Item> cartItem;

	public Cart() {
		super();
		cartItem = new HashMap<Integer, Item>();
	}

	public Cart(HashMap<Integer, Item> cartItem) {
		super();
		this.cartItem = cartItem;
	}

	public HashMap<Integer, Item> getCartItem() {
		return cartItem;
	}

	public void setCartItem(HashMap<Integer, Item> cartItem) {
		this.cartItem = cartItem;
	}
	public void add(Integer idProduct,Item item) {
		boolean checkId= cartItem.containsKey(idProduct);
		if(checkId) {
			item.setAmountItem(item.getAmountItem()+1);
			cartItem.put(item.getProductDetail().getProduct_detail_id(), item);
			
		}else {
			cartItem.put(item.getProductDetail().getProduct_detail_id(),item);
		}
	}
	public void del(Integer idProduct) {
		if(cartItem.containsKey(idProduct) && cartItem.get(idProduct).getAmountItem() <= 1) {
			cartItem.remove(idProduct);
		}else {
			cartItem.get(idProduct).setAmountItem(cartItem.get(idProduct).getAmountItem()-1);
		}
	}
	public int totalProduct() {
		int total = cartItem.size();
		return total;
	}
	public double totalMoney() {
		double total = 0;
		for(Map.Entry<Integer, Item> productItem : cartItem.entrySet()) {
			total += productItem.getValue().getProductDetail().getProduct_detail_price() * productItem.getValue().getAmountItem();
		}
		return total;
	}
}
