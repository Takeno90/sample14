<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%
String userId = (String)session.getAttribute("userId");
%>--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<p>ようこそ<c:out value="${userId}"/><%--<%= userId %>--%>さん</p>
<a href="/sample14/WelcomeServlet">トップへ</a>
</body>
</html>