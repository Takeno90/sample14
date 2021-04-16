<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import= "model.Product" %>
<% Product product = (Product)session.getAttribute("product");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(product != null){%>
			<form action="/sukkiriShop/CartServlet" method="post">
			<h1><%= product.getProductId() %> <%= product.getProductName() %></h1>
			<p><%= product.getProductPrice() %>円</p>
			<p><%= product.getProducutDescripstion() %></p>
			<p>個数
			<select name="quantity">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
			</select>
			</p>
			<p><button>カートに入れる</button></p>
			</form>

	<% }else{ %>
			<h1>問題が発生しました</h1>
			<p>もう一回やり直してください</p>
			<a href="/sukkiriShop/ProductServlet">商品一覧へ</a>
	<% } %>
</body>
</html>