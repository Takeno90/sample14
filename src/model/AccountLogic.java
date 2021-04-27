package model;

import dao.AccountDAO;

public class AccountLogic {
	//ログイン処理
	public boolean execute(Login login) {
		//暗号化
		PasswordUtil passUtil = new PasswordUtil();
		String safetyPassword = passUtil.getSafetyPassword(login.getPass(),login.getUserId());
		login.setPass(safetyPassword);

		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		return account != null;
	}
	//ユーザー登録処理
	public boolean create(Account account) {
		//パスワード暗号化
		PasswordUtil passUtil = new PasswordUtil();
		String safetyPassword = passUtil.getSafetyPassword(account.getPass(),account.getUserId());
		//パスワード上書き
		account.setPass(safetyPassword);

		AccountDAO dao = new AccountDAO();
		boolean isCreate = dao.create(account);
		if (isCreate) {
			return true;
		}else {
			return false;
		}
	}
}
