<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Product, java.util.List"  %>
<% List<Product> productList = (List<Product>)session.getAttribute("productList");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/sukkiriShop/ProductServlet" method="post">
	<table>
		<thead>
			<tr>
				<th>商品ID</th>
				<th>商品名</th>
				<th>価格</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<% for(Product product : productList){%>
				<tr>
					<td><%= product.getProductId() %></td>
					<td><%= product.getProductName() %></td>
					<td><%= product.getProductPrice() %>円</td>
					<td><button type="submit" name="<%= product.getProductId()%>">詳細</button>
					<!-- <td><input type="submit" value="詳細" name=""></td> -->
						<!-- <select name="count">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
						</select> -->
				</tr>
			<% } %>
		</tbody>
	</table>
	</form>
</body>
</html>