<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Product, java.util.List"  %>
<% List<Product> productList = (List<Product>)session.getAttribute("productList");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/boot_css.jsp"></jsp:include>
<title>スッキリ商店</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/nav.jsp"></jsp:include>
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
					<td><button name="productId" value= "<%= product.getProductId()%>">詳細</button>
				</tr>
			<% } %>
		</tbody>
	</table>

	</form>
<jsp:include page="/WEB-INF/jsp/boot_js.jsp"></jsp:include>
</body>
</html>