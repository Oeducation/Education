<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<link rel="stylesheet" href="css/login.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<title>注册</title>
</head>
<body>
	<div class="content">
		<div class="head">
			<a class="lefthead">政务服务</a>
			<div class="righthead">
				<a href="loginPage.html"><span class="login">去登录</span></a>
			</div>
		</div>
		<div class="declear"></div>
		<div class="main">
			<div class="form">
				<span>注册
					<p class="remind" id="info">
						<c:out value="${error}" />
					</p>
				</span>
				<form method="post" action="register.html">
					<div class="input">
						<input type="text" name="username" placeholder="请输入姓名" /> <a>姓名</a>
					</div>
					<div class="input">
						<input id="phone" type="text" name="phone" placeholder="请输入手机号码" />
						<a>手机号</a>
					</div>
					<div class="input">
						<input id="form-pwd" type="password" name="password"
							placeholder="请输入密码" /> <a>密码</a>
					</div>
					<div class="input">
						<input id="form-repwd" type="password" name="repassword"
							placeholder="确认密码" /> <a>确认密码</a>
					</div>
					<div class="input button">
						<input class="submit" type="submit" value="注册" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var repwd = document.getElementById("form-repwd");
	var pwd = document.getElementById("form-pwd");
	var span = document.getElementById("info");
	repwd.onblur = function() {
		var pwdv = pwd.value;
		var re = repwd.value;
		if (re != pwdv) {
			span.innerText = "两次输入密码不同";
		} else {
			span.innerText = "";
		}
	}
	pwd.onblur = function() {
		var pwdv = pwd.value;
		var re = repwd.value;
		if (re != pwdv) {
			span.innerText = "两次输入密码不同";
		} else {
			span.innerText = "";
		}
	}
	repwd.onfocus = function() {
		var pwdv = pwd.value;
		var re = repwd.value;
		if (re == pwdv) {
			span.innerText = "";
		}
	}
	pwd.onfocus = function() {
		var pwdv = pwd.value;
		var re = repwd.value;
		if (re == pwdv) {
			span.innerText = "";
		}
	}
	var phone = $("#phone");
	phone.blur(function() {

		var value = $(this).val();
		$.post("checkPhone.html", {
			"phone" : value
		}, function(result) {
			if (result == "no") {
				$("#info").text("该手机号已被注册!!");
			}
		});
	});
</script>
</html>