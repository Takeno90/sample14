<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Cart,java.util.List" %>
<%	String userId = (String)session.getAttribute("userId");
	List<Cart> cartList = (List<Cart>)request.getAttribute("cartList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/boot_css.jsp"></jsp:include>
<link rel="stylesheet" href="/sukkiriShop/css/style.css">
<title>スッキリ商店</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/nav.jsp"></jsp:include>
	<p><%= userId %>のカート</p>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">商品ID</th>
					<th scope="col">商品名</th>
					<th scope="col">価格</th>
					<th scope="col">個数</th>
					<th scope="col">小計</th>
				</tr>
			</thead>
			<tbody>
				<% int totalPrice = 0; %>
				<% for(Cart cart : cartList){ %>
				<tr>
					<td><%= cart.getProductId()%></td>
					<td><%= cart.getProductName()%></td>
					<td><%= cart.getProductPrice()%>円</td>
					<td><%= cart.getQuantity()%>個</td>
					<%
					int subtotalPrice = cart.getProductPrice() * cart.getQuantity();
					totalPrice += subtotalPrice;
					%>
					<td><%= subtotalPrice %>円</td>

				</tr>
				<% } %>
			</tbody>
		</table>
		<h3>合計金額<%= totalPrice %>円</h3>
	</div>
	<a href="/sukkiriShop/ProductServlet">商品一覧へ</a>

<jsp:include page="/WEB-INF/jsp/boot_js.jsp"></jsp:include>
</body>
</html>