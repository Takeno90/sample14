package model;

import java.util.List;

import dao.CartDAO;

public class CartLogic {
	public boolean add(String userId, int productId, int quantity) {
		CartDAO dao = new CartDAO();
		boolean isAdd = dao.add(userId, productId, quantity);
		return isAdd;
	}
	public List<Cart> findList(String userId){
		CartDAO dao = new CartDAO();
		List<Cart> cartList = dao.findList(userId);
		return cartList;
	}
}
