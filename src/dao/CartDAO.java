package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cart;

public class CartDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost/sukkiriShop?serverTimeZone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public boolean add(String userId, int productId, int quantity) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO CART (USER_ID,PRODUCT_ID,QUANTITY) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, userId);
			pStmt.setInt(2, productId);
			pStmt.setInt(3, quantity);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.getStackTrace();
			return false;
		}
		return true;
	}

	public List<Cart> findList(String userId) {
		List<Cart> cartList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT p.PRODUCT_ID,p.PRODUCT_NAME,p.PRODUCT_PRICE,sum(c.QUANTITY) FROM PRODUCT AS p,CART AS c WHERE c.USER_ID = ? AND p.PRODUCT_ID = c.PRODUCT_ID GROUP BY p.PRODUCT_ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, userId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("PRODUCT_ID");
				String productName = rs.getString("PRODUCT_NAME");
				int productPrice = rs.getInt("PRODUCT_PRICE");
				int quantity = rs.getInt("sum(c.QUANTITY)");

				Cart cart = new Cart(productId, productName, productPrice, quantity);
				cartList.add(cart);
			}
		}catch(SQLException e) {
			e.getStackTrace();
			System.out.print(false);
			return null;
		}
		return cartList;
	}
}
