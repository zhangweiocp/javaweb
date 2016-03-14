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
   <title>选拔分流系统</title>
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
      
      <%@ include file="../shared/sidebarMenu.jsp"%>
      
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
                  <li>专业分流<%-- ${requestScope.permissionMenu.subName}--%></li>
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
         	<div class="row">
				<div class="col-md-12">

					<div class="portlet box light-blue">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-search"></i>数据检索
							</div>
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form action="search.action" class="form-horizontal"
								method="POST">
								<div class="form-body">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-3">学号</label>
												<div class="col-md-9">
													<input name="xueHao"
														class="form-control placeholder-no-fix" autocomplete="off"
														placeholder="学号" />
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-3">姓名</label>
												<div class="col-md-9">
													<input name="name"
														class="form-control placeholder-no-fix" autocomplete="off"
														placeholder="姓名" />
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-offset-5">
												<button type="submit" class="btn btn-success">搜索</button>
											</div>
										</div>
									</div>
								</div>
							</form>
							<!-- END FORM-->
						</div>
					</div>
    <!-- BEGIN EXAMPLE TABLE PORTLET -->
					<div class="portlet box light-blue">
                  <div class="portlet-title">
                     <div class="caption"><i class="icon-table"></i>志愿列表</div>
                  </div>
                  <div class="portlet-body">
                     <div class="table-toolbar"></div>
                     <div class="dataTables_wrapper form-inline" role="grid">
	                     <div class="table-scrollable">
	                     <form action="confirmVol.action" method="post" id="form">
		                     <table class="table table-striped table-bordered table-hover" id="data-table">
		                        <thead>
		                           <tr>
		                              <th class="table-checkbox"><input type="checkbox" class="group-checkable"/></th>
		                              <th>学号</th>
		                              <th>姓名</th>
		                              <th>学院编号</th>
		                              <th>第一志愿</th>
		                              <th>第二志愿</th>
		                              <th>第三志愿</th>
		                              <th>录取志愿</th>
		                           </tr>
		                        </thead>
		                        <tbody>
		                        	<c:forEach items="${ list }" var="voluntary" >
							        <tr class="odd gradeX">
							        	<td class="check_cell"><input type="checkbox" class="checkboxes" name="Id" value="" />
									    </td>
							            <td name="XueHao">${ voluntary.xueHao }</td>
							            <td>${ voluntary.name }</td>
							            <td>${ voluntary.collegeId }</td>
							            <td><label><input type="radio" class="group-checkable" name="${voluntary.xueHao}" value="${voluntary.pro1}" onclick="checkBoxCheck(this)"/>${ voluntary.pro1 }</label></td>
							            <td><label><input type="radio" class="group-checkable" name="${voluntary.xueHao}" value="${voluntary.pro2}" onclick="checkBoxCheck(this)"/>${ voluntary.pro2 }</label></td>
							            <td><label><input type="radio" class="group-checkable" name="${voluntary.xueHao}" value="${voluntary.pro3}" onclick="checkBoxCheck(this)"/>${ voluntary.pro3 }</label></td>
							            <td id="${voluntary.xueHao}" name="Final_Pro">${ voluntary.final_pro }</td>
							        </tr>
							        </c:forEach>
		                        </tbody>
		                     </table>
		                     </form>
	                     </div>
	       				 <p:page pageNo="5" pageSize="5" totalSize="22"/>
	       				 <form name="pageForm" action="superadmin1.jsp" method="post">
	       				 	<input type="hidden" value="${pageNo}" name="pageNo" />
	       				 	<input type="hidden" value="${pageSize}" name="pageSize" />
	       				 	<input type="hidden" value="${totalSize}" name="totalSize" />
	       				 </form>
	       				 <div class="row">
	       				 	<div class="col-md-12">
								<div class="col-md-offset-5">
									<button type="button" class="btn btn-success" onclick="submitForm()">提交</button>
							    </div>
							</div>
	       				 </div>
       				 </div>
                  </div>
               </div>
					<!-- END EXAMPLE TABLE PORTLET -->
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
		function checkBoxCheck(object){
			var elementName = object.name;
			//var cbs = document.getElementsByName(elementName);
			//object.checked = true;
			var value = object.value;
			var td = document.getElementById(elementName);
			td.innerHTML = value;
		}
		function submitForm(){
			//var form = document.getElementById("form");
			//form.submit();
			var xueHaotd = document.getElementsByName("XueHao");
			var finalprotd = document.getElementsByName("Final_Pro");
			//alert(xueHaotd[0].innerText);
			//alert(xueHaotd.length);
			var string = "confirmVol.action?para=";
			for(var i = 0; i < xueHaotd.length; i++){
				string = string + xueHaotd[i].innerHTML + ";" + finalprotd[i].innerHTML + ";"; 
			}
			window.location.href=string;
		}
</script>	
</body>
</html>