<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

<html><head></head>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>选拔分流</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <meta name="MobileOptimized" content="320">
   
   <%@ include file="../shared/importCss.jsp"%>
   <!-- BEGIN PAGE LEVEL PLUGIN STYLES --> 
   <link href="plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
   <!-- END PAGE LEVEL PLUGIN STYLES -->
   
   <link rel="shortcut icon" href="favicon.ico" />
   <script type="text/javascript" src="js/upload.js"></script>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
   
   <%@ include file="../shared/pageHeader.jsp"%>
   
   <div class="clearfix"></div>
   <!-- BEGIN CONTAINER -->
   <div class="page-container">
      
      <%@ include file="../shared/sidebarMenu1.jsp"%>
      
      <!-- BEGIN PAGE -->
      <div class="page-content">
         
         <%@ include file="../shared/styleSet.jsp"%>
           
         <!-- BEGIN PAGE HEADER-->
         <div class="row">
            <div class="col-md-12">
               <!-- BEGIN PAGE TITLE & BREADCRUMB-->
               <h3 class="page-title">
                  武汉工程大学 <small>选拔分流系统</small>
               </h3>
               <ul class="page-breadcrumb breadcrumb">
                  <li>
                     <i class="icon-home"></i>
                     欢迎使用
                     <%-- ${requestScope.permissionMenu.rootName} --%>
                     <i class="icon-angle-right"></i>
                  </li>
                  <li>首页<%-- ${requestScope.permissionMenu.subName}--%></li>
                  <li class="pull-right">
                     <div id="dashboard-report-range" class="dashboard-date-range tooltips" data-placement="top" data-original-title="Change dashboard date range">
                        <i class="icon-calendar"></i>
                        <span></span>
                        <i class="icon-angle-down"></i>
                     </div>
                  </li>
               </ul>
               <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
         </div>
         <!-- END PAGE HEADER-->
         
         <div class="clearfix"></div>
         <div class="panel panel-warning">
         	<div class="panel-heading">修改密码</div>
         	<form action="modifyPassWord.action" method="post" id="form1" >
         	<div class="panel-body">
         	<div class="container">
	         	<div class="row">
	         		<div class="col-md-1 col-md-offset-4"><h6>学号</h6></div>
	         		<div class="col-md-3"><div class="form-group has-warning"><input class="form-control" type="text" placeholder="${sessionScope.user.userName}" readonly></div></div>
	         	</div>
	         	<div class="row">
	         		<div class="col-md-1 col-md-offset-4"><h6>姓名</h6></div>
	         		<div class="col-md-3"><div class="form-group has-warning"><input class="form-control" type="text" placeholder="${name}" readonly></div></div>
	         	</div>
	            <div class="row">
	         		<div class="col-md-1 col-md-offset-4"><h6>新密码</h6></div>
	         		<div class="col-md-3">
	         			<div class="form-group has-success has-feedback">
	         				<input class="form-control" type="password" name="password1" placeholder="新密码" id="inputSuccess2" aria-describedby="inputSuccess2Status">
	         			</div>
	         		</div>
	         	</div>
	         	<div class="row">
	         		<div class="col-md-1 col-md-offset-4"><h6>确认新密码</h6></div>
	         		<div class="col-md-3"><div class="form-group has-success has-feedback"><input class="form-control" type="password" name="password2" placeholder="确认新密码"></div></div>
	         	</div>
           </div>
         </div>
         <div class="panel-footer">
         	<div class="container">
         		<div class="row">
         			<div class="col-md-1 col-md-offset-6"><button type="button" class="btn btn-success" onclick="modify()">提交</button></div>
         		</div>
         	</div>
         </div>
         </form>
      </div>
      <!-- END PAGE -->
   </div>
   <!-- END CONTAINER -->
   <!-- BEGIN FOOTER -->
   <%@ include file="../shared/pageFooter.jsp" %>
   <!-- END FOOTER -->
   
   <%@ include file="../shared/importJs.jsp"%>
   <!-- BEGIN PAGE LEVEL PLUGINS -->
   <script src="plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script>
   <!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
   <script src="plugins/fullcalendar/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
   <script src="plugins/jquery.sparkline.min.js" type="text/javascript"></script>  
   <!-- END PAGE LEVEL PLUGINS -->
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script src="js/app.js" type="text/javascript"></script>
   <script src="js/index.js" type="text/javascript"></script>  
   <!-- END PAGE LEVEL SCRIPTS -->  
   <script type="text/javascript">
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			Index.init();
			Index.initCalendar(); // init index page's custom scripts
			Index.initPeityElements();
			Index.initKnowElements();
			Index.initDashboardDaterange();
		});
		function modify(){
			var password1 = document.getElementsByName("password1")[0].value;
			var password2 = document.getElementsByName("password2")[0].value;
			if(password1==""||password2==""){
				alert("请输入新密码");
			}else{
				if(password1==password2){
					document.getElementById("form1").submit();
				}else{
					alert("您输入的密码不一致，请重新输入");
				}
			}
		}
</script>	
</body>
</html>