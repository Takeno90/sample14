<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<form action="/sukkiriShop/LoginServlet" method="post">
	<p>ユーザーID:<input type="text" name="userId"></p>
	<p>パスワード:<input type="password" name="pass"></p>
	<input type="submit" value="ログイン">
</form>
</body>
</html>