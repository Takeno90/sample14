<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<h1>スッキリ商店　ユーザー登録</h1>
<form action="/sukkiriShop/CreateServlet" method="post">
	<table>
		<tr>
			<td><label for="userId">ユーザーID:</label></td>
			<td><input type="text" name="userId" id="userId"></td>
		</tr>
		<tr>
			<td><label for="pass">パスワード:</label></td>
			<td><input type="password" name="pass" id="pass"></td>
		</tr>
		<tr>
			<td><label for="mail">メールアドレス:</label></td>
			<td><input type="email" name="mail" id="mail"></td>
		</tr>
		<tr>
			<td><label for="name">名前:</label></td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td><label for="age">年齢:</label></td>
			<td><input type="text" name="age" id="age"></td>
		</tr>
	</table>
	<input type="submit" value="登録">
</form>
</body>
</html>