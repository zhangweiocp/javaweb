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
                     <i class="icon-cogs"></i>
                     选拔分流
                     <%-- ${requestScope.permissionMenu.rootName} --%>
                     <i class="icon-angle-right"></i>
                  </li>
                  <li>分流<%-- ${requestScope.permissionMenu.subName}--%></li>
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
         	<form action="selectVol.action" method="post">
	         <div class="panel panel-success">
	         	<div class="panel-heading">本人志愿</div>
	         	<div class="panel-body">
	         		<div class="container">
	         			<div class="row">
	         				<div class="col-md-4">
		         				 <div class="col-md-offset-1"><h4>第一志愿</h4></div>
		         				 <div class="form-group">
		         					<select class="form-control" name="pro1">
										<c:forEach var="major" items="${list}">
											<option>${ major.maj_Name }</option>
										</c:forEach>
		         					</select>
		         				 </div>
	         			    </div>
	         				<div class="col-md-4">
		         				 <div class="col-md-offset-1"><h4>第二志愿</h4></div>
		         				 <div class="form-group">
		         					<select class="form-control" name="pro2">
										<c:forEach var="major" items="${list}">
											<option>${ major.maj_Name }</option>
										</c:forEach>
		         					</select>
		         				 </div>
	         			    </div>
	         				<div class="col-md-4">
		         				 <div class="col-md-offset-1"><h4>第三志愿</h4></div>
		         				 <div class="form-group">
		         					<select class="form-control" name="pro3">
										<c:forEach var="major" items="${list}">
											<option>${ major.maj_Name }</option>
										</c:forEach>
		         					</select>
		         				 </div>
	         			    </div>
	         			</div>
	         		</div>
	         	</div>
	         	<div class="panel-footer">
	         		<div class="row">
		         		<div class="col-md-2 col-md-offset-5">
		         			<input type="submit" class="btn btn-success" value="提交" />
		         		</div>
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
</script>	
</body>
</html>