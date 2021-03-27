package models;

import java.util.HashMap;

public class FavouriteHandling {
	HashMap<Integer, ProductDetail> favourite;

	public FavouriteHandling() {
		super();
		favourite = new HashMap<Integer, ProductDetail>();
	}

	public FavouriteHandling(HashMap<Integer, ProductDetail> favourite) {
		super();
		this.favourite = favourite;
	}

	public HashMap<Integer, ProductDetail> getFavourite() {
		return favourite;
	}

	public void setFavourite(HashMap<Integer, ProductDetail> favourite) {
		this.favourite = favourite;
	}
	
	public int add(int favourite_id,ProductDetail f) {
		int result;
		if(favourite.containsKey(favourite_id)) {
			return result = 1;
		}else {
			favourite.put(favourite_id, f);
			return result = 2;
		}
	}
	public void del(int favourite_id) {
		if(favourite.containsKey(favourite_id)) {
			favourite.remove(favourite_id);
		}
	}
}
