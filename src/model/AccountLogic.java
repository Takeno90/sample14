package model;

import dao.AccountDAO;

public class AccountLogic {
	//ログイン処理
	public boolean execute(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		return account != null;
	}
	//ユーザー登録処理
	public boolean create(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean isCreate = dao.create(account);
		if (isCreate) {
			return true;
		}else {
			return false;
		}
	}
}
