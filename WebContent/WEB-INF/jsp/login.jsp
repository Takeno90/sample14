<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/boot_css.jsp"></jsp:include>
<title>スッキリ商店</title>
</head>
<body>
	<form action="/sukkiriShop/LoginServlet" method="post">
		<p>
			ユーザーID:<input type="text" name="userId">
		</p>
		<p>
			パスワード:<input type="password" name="pass">
		</p>
		<input type="submit" value="ログイン"> <input type="button"
			value="Topへ" onclick="location.href='/sukkiriShop/'">
	</form>
<jsp:include page="/WEB-INF/jsp/boot_js.jsp"></jsp:include>
</body>
</html>