package model;

public class Cart {
	private int productId;
	private String productName;
	private int productPrice;
	private int quantity;
	public Cart(int productId, String productName, int productPrice, int quantity) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public int getQuantity() {
		return quantity;
	}

}
