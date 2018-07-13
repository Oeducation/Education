<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<link rel="stylesheet" href="css/main.css">
<title>main</title>
</head>
<body>
	<div id="bg">
		<c:choose>
			<c:when test="${sessionScope.userContext != null}">
				<a href="#"><c:out value="${sessionScope.userName}"></c:out></a>
			</c:when>
			<c:otherwise>
				<a href="loginPage.html">登录</a>
				<a href="registerPage.html">注册</a>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="bt">
		<h2>
			<a href="#">政务服务</a>
		</h2>
		<h2>
			<a href="#">政务服务</a>
		</h2>
		<h2>
			<a href="#">政务服务</a>
		</h2>
		<h2>
			<a href="#">政务服务</a>
		</h2>
		<h2>
			<a href="#">政务服务</a>
		</h2>
	</div>

	<div id="main">
		<div id="left"></div>
		<div id="right"></div>
	</div>

	<div id="footer"></div>
</body>
</html>