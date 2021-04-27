<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="/sukkiriShop/MainServlet">スッキリ商店</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/sukkiriShop/ProductServlet">商品一覧</a></li>
			<li class="nav-item"><a class="nav-link" href="/sukkiriShop/CartServlet">カート</a></li>
			<li class="nav-item"><a class="nav-link" href="/sukkiriShop/LogoutServlet">ログアウト</a></li>
		</ul>
	</div>
</nav>