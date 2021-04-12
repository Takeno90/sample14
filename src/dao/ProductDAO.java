package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost/sukkiriShop?serverTimeZone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	//商品一覧取得
	public List<Product> findAll(){
		List<Product> productList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			//SQL文
			String sql = "SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_DESCRIPTION FROM PRODUCT";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文実行、取得
			ResultSet rs = pStmt.executeQuery();

			//取得した情報を順々にProduct(Beans)に入れ、Listに加える
			while (rs.next()) {
				int productId = rs.getInt("PRODUCT_ID");
				String productName = rs.getString("PRODUCT_NAME");
				int productPrice = rs.getInt("PRODUCT_PRICE");
				String productDescription = rs.getString("PRODUCT_DESCRIPTION");
				//String productImage = rs.getString("product_image");
				Product product = new Product(productId,productName,productPrice,productDescription);
				productList.add(product);
			}

		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}
		return productList;
	}

	//商品1データ取得
	public Product findOne(int productId) {
		Product product = null;
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			//SQL文
			String sql = "SELECT PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_DESCRIPTION FROM PRODUCT WHERE PRODUCT_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, productId);

			//SQL文実行、取得
			ResultSet rs = pStmt.executeQuery();

			//取得した情報をBeansに入れる
			if(rs.next()) {
				String productName = rs.getString("PRODUCT_NAME");
				int productPrice = rs.getInt("PRODUCT_PRICE");
				String productDescription = rs.getString("PRODUCT_DESCRIPTION");
				//String productImage = rs.getString("product_image");
				product = new Product(productId,productName,productPrice,productDescription);
			}

		}catch(SQLException e){
			e.getStackTrace();
		}
		return product;
	}
}
