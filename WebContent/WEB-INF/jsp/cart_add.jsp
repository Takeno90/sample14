<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%	Product product = (Product)session.getAttribute("product");
	int quantity = (int)request.getAttribute("quantity");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/boot_css.jsp"></jsp:include>
<title>スッキリ商店</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/nav.jsp"></jsp:include>
以下の商品をカートに追加しました
<table>
<thead>
	<tr>
		<th>商品ID
		<th>商品名
		<th>価格
		<th>個数
	</tr>
</thead>
<tbody>
	<tr>
		<td><%= product.getProductId() %>
		<td><%= product.getProductName() %>
		<td><%= product.getProductPrice() %>
		<td><%= quantity%>
	</tr>
</tbody>
</table>
<p><a href=/sukkiriShop/BuyServlet>購入</a></p>
<p><a href=/sukkiriShop/CartServlet>カート一覧へ</a></p>
<p><a href=/sukkiriShop/ProductServlet>商品一覧へ</a></p>
<jsp:include page="/WEB-INF/jsp/boot_js.jsp"></jsp:include>
</body>
</html>