<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
			<script type="text/javascript">
		function validate(){
			var username = document.getElementsByName("username")[0];
			var password = document.getElementsByName("password")[0];
			if(username.value == ""){
				alert("请输入用户名");
				return false;
			}
			if(password.value == ""){
				alert("请输入密码");
				return false;
			}
			return true;
		}
	</script>
	</head>

	<body>
	<div style="background-color:#61B1A7;margin:auto;Width:30%;margin-top:200px;height:30%">
	<form onsubmit="return validate()" action="mylogin.action" method="post">
	<div style="margin: auto;width:50%;margin-top:30px">
		账户：<input type="text" name="username"><br>
		密码：<input type="password" name="password"><br>
		<input type="radio" name="role" checked="checked" value="student">学生&nbsp;&nbsp;<input type="radio" name="role" value="role">管理员<br>
		<input type="submit" value="登录">
	</div>
	</form>
	</div>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js">
</script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js">
</script>
	</body>
</html>
