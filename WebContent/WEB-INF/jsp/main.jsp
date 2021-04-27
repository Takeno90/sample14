<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/boot_css.jsp"></jsp:include>
<title>スッキリ商店</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/nav.jsp"></jsp:include>
	<p>ようこそ<c:out value="${userId}" />さん</p>
	<p><a href="/sukkiriShop/ProductServlet">商品一覧ページへ</a></p>
	<p><a href="/sukkiriShop/CartServlet">カートへ</a></p>
	<p><a href="/sukkiriShop/LogoutServlet">ログアウト</a></p>
<jsp:include page="/WEB-INF/jsp/boot_js.jsp"></jsp:include>
</body>
</html>