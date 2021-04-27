/**
 *
 */
//Element取得
//form
//const form = document.getElementById("form");
//form element
//const userId = document.getElementById("userId");
const pass = documet.getElementById("pass");
const mail = documet.getElementById("mail");
const name = documet.getElementById("name");
//const age = documet.getElementById("age");

//error message
//const userId_error_message = document.getElementById("userId_error_message")
const pass_error_message = document.getElementById("pass_error_message")
const mail_error_message = document.getElementById("mail_error_message")
const name_error_message = document.getElementById("name_error_message")
//const age_error_message = document.getElementById("age_error_message")

//button
//const btn = document.getElementById("btn")

//バリデーションパターン
//const usersIdExp = /^[a-zA-Z]$/;
const passExp = /^([a-zA-Z0-9]{6,})$/;
const mail = /^[a-z]+@[a-z]+/;
const nameExp = /^[a-zA-Z]$/;
//const ageExp = /^[0-9]$/;

//ボタン初期状態(押せない)
btn.disabled = true;

//event
//userId

//pass
pass.addEventListener("keyup", e => {
	if (passExp.test(pass.value)) {
		//class属性追加
		pass.setAttribute("class", "success");
		//spanタグのcss変更
		pass_error_message.style.display = "none";
	} else {
		pass.setAttribute("class", "error");
		pass_error_message.style.display = "inline";
	}
	console.log(name.getAttribute("class").includes("success"));

})
//name
//keyup(キーを離した時)
name.addEventListener("keyup", e => {
	if (nameExp.test(name.value)) {
		//class属性追加
		name.setAttribute("class", "success");
		//spanタグのcss変更
		name_error_message.style.display = "none";
	} else {
		name.setAttribute("class", "error");
		name_error_message.style.display = "inline";
	}
	console.log(name.getAttribute("class").includes("success"));

})

//mail
mail.addEventListener("keyup", e => {
	if (mailExp.test(mail.value)) {
		mail.setAttribute("class", "success");
		mail_error_message.style.display = "none";
	} else {
		mail.setAttribute("class", "error");
		mail_error_message.style.display = "inline";
	}
})



