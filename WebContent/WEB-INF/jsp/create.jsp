<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/boot_css.jsp"></jsp:include>
<title>スッキリ商店</title>
</head>
<body>
	<h1>スッキリ商店 ユーザー登録</h1>
	<form action="/sukkiriShop/CreateServlet" method="post" name="form1" onsubmit="return funcConfirm()">
		<table>
			<tr>
				<td><label for="userId">ユーザーID:</label></td>
				<td><input type="text" name="userId" id="userId"></td>
			</tr>
			<tr>
				<td><label for="pass">パスワード:</label></td>
				<td><input type="password" name="pass" id="pass">
			</tr>
			<tr>
				<td><label for="mail">メールアドレス:</label></td>
				<td><input type="email" name="mail" id="mail"></td>
			</tr>
			<tr>
				<td><label for="name">名前:</label></td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td><label for="age">年齢:</label></td>
				<td><input type="text" name="age" id="age"></td>
			</tr>
		</table>
		<input type="submit" value="登録"> <input type="button"
			value="Topへ" onclick="location.href='/sukkiriShop/'">
	</form>
<script type="text/javascript">
function funcConfirm(){
	//バリデーションチェック,alert処理
	if(document.form1.userId.value == '') {
		alert('ユーザーIDが入力されていません。');
		return false;
	}
	if(document.form1.pass.value == '') {
		alert('パスワードが入力されていません。');
		return false;
	}
	if(document.form1.mail.value == '') {
		alert('メールアドレスが入力されていません。');
		return false;
	}
	if(document.form1.name.value == '') {
		alert('氏名が入力されていません。');
		return false;
	}
	if(document.form1.age.value == '') {
		alert('年齢が入力されていません。');
		return false;
	}
	//文字数、半角英数
	if(!document.form1.userId.value.match(/^[a-zA-Z0-9]+$/)){
		alert('ユーザーIDは半角英数字で入力してください');
		return false;
	}
	if(!document.form1.pass.value.match(/^[\x20-\x7E]{8,}$/)){
		alert('パスワードは8文字以上の半角英数字と記号で入力してください');
		return false;
	}
	if(!document.form1.name.value.match(/^[a-zA-Zぁ-んァ-ヶー一-龠]+$/)){
		alert('氏名は英数字かなで入力してください');
		return false;
	}
	if(!document.form1.age.value.match(/^[0-9]+$/)){
		alert('年齢は0以上の数字で入力してください');
		return false;
	}
	const ageInt = parseInt(document.form1.age.value)
	if(150 < ageInt){
		alert('年齢は150以下の数字で入力してください');
		return false;
	}
}
	/* fnction check(){
	const pass = document.getElementById("pass").value;
	const passExp = /^[a-zA-Z0-9]{4,}$/;
	const result = passExp.test(pass);
	if(!result){
		alert('パスワードは4文字以上の英数字でお願いします');
	}*/

</script>
</body>
</html>