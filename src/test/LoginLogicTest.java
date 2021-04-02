package test;

import model.Login;
import model.AccountLogic;

public class LoginLogicTest {
	public static void main(String[] args) {
		testExecute1();//ログイン成功のテスト
		testExecute2();//ログイン失敗のテスト
	}
	public static void testExecute1() {
		Login login = new Login("minato","1234");
		AccountLogic bo = new AccountLogic();
		boolean result = bo.execute(login);
		if(result) {
			System.out.println("testExecute1:成功しました");
		}else {
			System.out.println("testExecute1:失敗しました");
		}
	}
	public static void testExecute2() {
		Login login = new Login("minato","12345");
		AccountLogic bo = new AccountLogic();
		boolean result = bo.execute(login);
		if(!result) {
			System.out.println("testExecute2:成功しました");
		}else {
			System.out.println("testExecute2:失敗しました");
		}
	}
}
