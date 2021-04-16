<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Cart,java.util.List" %>
<%	String userId = (String)session.getAttribute("userId");
	List<Cart> cartList = (List<Cart>)request.getAttribute("cartList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%= userId %>のカート</p>
	<div>
		<table>
			<thead><th>商品ID</th><th>商品名</th><th>価格</th><th>個数</th><th>計</th></thead>
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

</body>
</html>