<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
	<h1>スッキリ商店ユーザー登録</h1>
	<c:choose>
		<c:when test="${isCreate == true }">
			<p>登録に成功しました</p>
		</c:when>
		<c:otherwise>
			<p>登録に失敗しました</p>
		</c:otherwise>
	</c:choose>
	<a href="/sukkiriShop/WelcomeServlet">Topへ</a>
</body>
</html>