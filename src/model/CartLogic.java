package model;

import dao.CartDAO;

public class CartLogic {
	public boolean add(String userId, int productId, int quantity) {
		CartDAO dao = new CartDAO();
		boolean isAdd = dao.add(userId, productId, quantity);
		return isAdd;
	}
}
