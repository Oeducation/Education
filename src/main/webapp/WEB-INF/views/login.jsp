<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login.css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>登录</title>
</head>
<body>
	<div class="content">
		<div class="head">
			<a class="lefthead">政务服务</a>
			<div class="righthead">
				<a href="registerPage.html"><span>去注册</span></a>
			</div>
		</div>
		<div class="declear"></div>
		<div class="main">
			<div class="form">
				<span>登录<p class="remind"><c:out value="${error}"/></p></span>
				<form action="loginCheck.html" method="post">
					<div class="input">
						<input type="text" name="phone" placeholder="请输入手机号码" /> <a>手机号</a>
					</div>
					<div class="input">
						<input type="password" name="password" placeholder="请输入密码" /> <a>密码</a>
					</div>
					<div class="input button">
						<input class="submit" type="submit" value="登录" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>