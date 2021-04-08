package model;

import java.io.Serializable;

public class Product implements Serializable {
	private int productId;
	private String productName;
	private int productPrice;
	private String producutDescripstion;
//	private String productImage;

//	public Product(int productId, String productName, int productPrice, String producutDescripstion,
//			String productImage) {
//		this.productId = productId;
//		this.productName = productName;
//		this.productPrice = productPrice;
//		this.producutDescripstion = producutDescripstion;
//		this.productImage = productImage;
//	}

	public Product(int productId, String productName, int productPrice, String producutDescripstion) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.producutDescripstion = producutDescripstion;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProducutDescripstion() {
		return producutDescripstion;
	}

	public void setProducutDescripstion(String producutDescripstion) {
		this.producutDescripstion = producutDescripstion;
	}

//	public String getProductImage() {
//		return productImage;
//	}
//
//	public void setProductImage(String productImage) {
//		this.productImage = productImage;
//	}



}
