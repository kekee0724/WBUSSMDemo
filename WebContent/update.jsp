<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改信息</title>
</head>

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
	text-decoration: blink;
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

<body>
	<div class="header">
		<div class="logo">武汉商学院实训</div>
		<div class="login">
			<a href="javascript:void(0)">登录</a> <span>|</span> <a
				href="javascript:void(0)">注册</a>
		</div>
	</div>
	<form action="doupdate.do">
		帐号: <input type="text" id="id" name="id" value="${user.id }"> <br>
		姓名: <input type="text" id="name" name="name" value="${user.name }"> <br>
		密码: <input type="text" id="password" name="password" value="${user.password }"> <br>
		年龄: <input type="text" id="age" name="age" value="${user.age }"><br>
		地址: <input type="text" id="location" name="location" value="${user.location }"> <br>  
		<input type="submit" value="修改">
	</form>
	<br>
	<a href="doupdate.do">修改</a>
	<a href="http://www.baidu.com">百度一下</a>
	<a href="http://www.runoob.com/html/html5-intro.html">runoob</a>

</body>

</html>