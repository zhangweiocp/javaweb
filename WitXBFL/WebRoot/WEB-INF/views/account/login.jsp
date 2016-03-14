<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

<html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!  --><html lang="en" class="no-js"><!--<![endif]-->
<!-- BEGIN HEAD /WitXBFL/WebRoot/WEB-INF/views/shared/importCss.jsp-->
<head>
	<meta charset="utf-8" />
	<title>登录</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<meta name="MobileOptimized" content="320">
	
	<%@ include file="../shared/importCss.jsp"%>
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link href="css/pages/login.css" rel="stylesheet" type="text/css"/>
	<link href="css/pages/login.css" rel="stylesheet" type="text/css"/>
	<link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL SCRIPTS -->
	
	<%@ include file="../shared/importJs.jsp"%>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="plugins/jquery-validation/dist/jquery.validate.min.js"></script>   
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="js/app.js" type="text/javascript"></script>
	<script src="js/account.validate.js" type="text/javascript"></script> 
	<!-- END PAGE LEVEL SCRIPTS -->
	
	<link rel="shortcut icon" href="favicon.ico" />
</head>
		<!-- BEGIN BODY -->
		<body class="login">
			<!-- BEGIN LOGO -->
			<div class="logo">
				<img src="images/logo.png" alt="" />
			</div>
			<!-- END LOGO -->
			<!-- BEGIN LOGIN -->
			<div class="content">
				<!-- BEGIN LOGIN FORM -->
				<form id="contentModel" class="login-form" method="post" action="mylogin.action"
					novalidate="novalidate">
					<h3 class="form-title">
						帐号登录
					</h3>
					<div class="form-group">
						<label class="control-label visible-ie8 visible-ie9">
							用户名
						</label>
						<div class="input-icon">
							<i class="icon-user"></i>
							<input id="username" class="form-control placeholder-no-fix"
								type="text" autocomplete="off" value="" placeholder="用户名"
								name="username">
							<br>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label visible-ie8 visible-ie9">
							密码
						</label>
						<div class="input-icon">
							<i class="icon-lock"></i>
							<input id="password" class="form-control placeholder-no-fix"
								type="password" autocomplete="off" value="" placeholder="密码"
								name="password">
							<br>
						</div>
					</div>
					<div>
						<label class="radio-inline">
	  						<input type="radio" name="role" checked="checked" id="inlineRadio1" value="student"> 学生
						</label>
						<label class="radio-inline">
	  						<input type="radio" name="role" id="inlineRadio2" value="role"> 管理员
						</label>
					</div>
					<div class="form-actions">
						<label class="checkbox"><input type="checkbox" value="1"
										name="remember"> 记住我
						</label>
						<button class="btn btn-info pull-right" type="submit">
							登录
						</button>
					</div>
					<div class="forget-password">
						<h4>
							忘记密码？
						</h4>
						<p>
							别担心，点击
							<a id="forget-password" href="javascript:;">这里</a> 重置密码。
						</p>
					</div>
				</form>
				<!-- END LOGIN FORM -->
			</div>
			<!-- END LOGIN -->
			<!-- BEGIN COPYRIGHT -->
			<div class="copyright">
				2015 &copy; Wuhan Institute of Technology.
			</div>
			<!-- END COPYRIGHT -->

			<script type="text/javascript">
			$(function() {
			App.init();
			AccountValidate.handleLogin();
			});
			</script>
			<!-- END JAVASCRIPTS -->
		</body>
		<!-- END BODY -->
	</html>