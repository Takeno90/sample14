package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost/sukkiriShop?serverTimeZone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	//ログイン処理
	public Account findByLogin(Login login) {
		Account account = null;
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			//SELECT文を準備
			String sql = "SELECT USER_ID,PASS,MAIL,NAME,AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			if(rs.next()) {
				//結果表からデータを取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				account = new Account(userId,pass,mail,name,age);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return account;
	}

	//ユーザー登録処理
	public boolean create(Account account) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "INSERT INTO ACCOUNT VALUES (?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getMail());
			pStmt.setString(4, account.getName());
			pStmt.setInt(5, account.getAge());

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
