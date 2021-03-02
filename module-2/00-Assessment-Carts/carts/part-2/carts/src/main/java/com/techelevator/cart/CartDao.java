package com.techelevator.cart;

import java.util.List;

import com.techelevator.cart.Cart;

public interface CartDao {

	public void save(Cart newCart);

	public List<Cart> getAllCarts();

	public void update(Cart cart);     
	
	public void delete(long id);         	
	
	
}
