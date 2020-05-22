<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<style>
* {
	padding: 0;
	margin: 0;
	font-family: "微软雅黑";
}

.header {
	height: 72px;
	background: #458fce;
}

.header .logo {
	color: #fff;
	line-height: 70px;
	font-size: 30px;
	margin-left: 20px;
	display: inline-block;
	text-align: center;
}

a {
	color: #000;
	text-decoration: none;
}

.header .login {
	float: right;
	color: #fff;
	line-height: 72px;
	margin-right: 2px;
	display: inline-block;
}

.banner {
	height: 380px;
	overflow: hidden;
	background: #ddd;
}
</style>
</head>
<body>
	<div class="header">
		<div class="logo">武汉商学院实训</div>
		<div class="login">
			<a href="javascript:void(0)">登录</a> <span>|</span> <a
				href="javascript:void(0)">注册</a>
		</div>
	</div>
	<!-- 使用美元符+{} ,括号中填写,后台中绑定数据的别名 -->
	<!-- 在前端页面中使用循环，需要使用el标签
	     第一步：在头部导入el标签
	     第二步：使用c:forEach标签，循环我们需要遍历的集合
	            items:获取后台绑定的集合 var:别名
	 -->
	<!--
	<br> 后台绑定的name:${aaa }
	<br> 后台绑定的pass:${bbb }
	<br> id:${u.id }
	<br> 姓名:${u.name }
	<br> 年龄:${u.age }
	 -->
	<h1>${wbu }</h1>
	<table border="1" cellspacing="10">

		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>密码</td>
			<td>年龄</td>
			<td>地址</td>
			<td></td>
			<td></td>
		</tr>
		<!--
		<tr>
			<td>${u.id }</td>
			<td>${u.name }</td>
			<td>${u.password }</td>
			<td>${u.age }</td>
		</tr>
		-->
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.password }</td>
				<td>${user.age }</td>
				<td>${user.location }</td>
				<td><a href="delete.do?isd=${user.id }">删除</a></td>
				<td><a href="update.do?id=${user.id }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="http://www.baidu.com">百度一下</a>
	<a href="http://www.runoob.com/html/html5-intro.html">runoob</a>
</body>
</html>