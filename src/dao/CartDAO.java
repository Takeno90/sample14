package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost/sukkiriShop?serverTimeZone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "";


	public boolean add(String userId, int productId, int quantity) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "INSERT INTO CART (USER_ID,PRODUCT_ID,QUANTITY) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, userId);
			pStmt.setInt(2, productId);
			pStmt.setInt(3, quantity);

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}
		return true;
	}
}
