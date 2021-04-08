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
				//Blob productImage = rs.getBlob("product_image");
				Product product = new Product(productId,productName,productPrice,productDescription);
				productList.add(product);
			}

		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}
		return productList;
	}

}
