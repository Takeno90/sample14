package model;

import java.util.List;

import dao.ProductDAO;

public class ProductLogic {
	public List<Product> findAll(){
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.findAll();
		return productList;

//		if (productList.equals(null)) {
//			return null;
//
//		}else {
//			return productList;
//		}
	}

	public Product findOne(int productId) {
		ProductDAO dao = new ProductDAO();
		Product product = dao.findOne(productId);
		return product;
	}
}
