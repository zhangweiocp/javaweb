<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../shared/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
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
<link href="plugins/data-tables/DT_bootstrap.css"
	rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL PLUGIN STYLES -->
<%@ include file="../shared/importJs.jsp"%>
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script type="text/javascript" src="plugins/data-tables/jquery.dataTables.js"></script>
   <script type="text/javascript" src="plugins/data-tables/DT_bootstrap.js"></script>
   <script type="text/javascript" src="plugins/uniform/jquery.uniform.min.js"></script>
   <script type="text/javascript" src="js/jquery.toolbarlite.js?ver=10"></script> 
   <script type="text/javascript" src="js/app.js"></script> 
   <script type="text/javascript" src="js/jquery.tableManaged.js"></script>
   <!-- END PAGE LEVEL SCRIPTS -->

<link rel="shortcut icon" href="favicon.ico" />
</head>

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
						<li><i class="icon-cogs"></i> 账号管理 <%-- ${requestScope.permissionMenu.rootName} --%>
							<i class="icon-angle-right"></i></li>
						<li>学生账号<%-- ${requestScope.permissionMenu.subName}--%>
						</li>
						<li class="pull-right">
							<div id="dashboard-report-range"
								class="dashboard-date-range tooltips" data-placement="top"
								data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i
									class="icon-angle-down"></i>
							</div></li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT -->
			<div class="row">
				<div class="col-md-12">

					<div class="portlet box light-grey">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-search"></i>数据检索
							</div>
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form action="findStudent.action" class="form-horizontal"
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
					<div class="portlet box light-grey">
                  <div class="portlet-title">
                     <div class="caption"><i class="icon-table"></i>学生列表</div>
                  </div>
                  <div class="portlet-body">
                     <div class="table-toolbar"></div>
                     <div class="dataTables_wrapper form-inline" role="grid">
	                     <div class="table-scrollable">
		                     <table class="table table-striped table-bordered table-hover" id="data-table">
		                        <thead>
		                           <tr>
		                              <th class="table-checkbox"><input type="checkbox" class="group-checkable"/></th>
		                              <th>学号</th>
		                              <th>姓名</th>
		                              <th>性别</th>
		                              <th>学院编号</th>
		                              <th>身份证</th>
		                              <th>电话</th>
		                              <th>密码</th>
		                           </tr>
		                        </thead>
		                        <tbody>
		                        	<c:forEach items="${ list }" var="role">
							        <tr class="odd gradeX">
							        	<td class="check_cell"><input type="checkbox" class="checkboxes" name="Id" value="" />
									    </td>
							            <td>${ role.xuehao }</td>
							            <td>${ role.name }</td>
							            <td>${ role.gender }</td>
							            <td>${ role.collegeId }</td>
							            <td>${ role.id_card }</td>
							            <td>${ role.phone }</td>
							            <td>${ role.password }</td>
							        </tr>
							        </c:forEach>
		                        </tbody>
		                     </table>
	                     </div>
	       				<!--  <p:page pageNo="5" pageSize="5" totalSize="22"/>
	       				 <form name="pageForm" action="superadmin1.jsp" method="post">
	       				 	<input type="hidden" value="${pageNo}" name="pageNo" />
	       				 	<input type="hidden" value="${pageSize}" name="pageSize" />
	       				 	<input type="hidden" value="${totalSize}" name="totalSize" />
	       				 </form> -->
       				 </div>
                  </div>
               </div>
					<!-- END EXAMPLE TABLE PORTLET -->
				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
    <%@ include file="../shared/pageFooter.jsp" %>
	<%@ include file="../shared/studentModal.jsp"%>
	<!-- END FOOTER -->
	<script type="text/javascript">
	$(function() {   
         App.init();
         
         $("#data-table").tableManaged();
         
         $(".table-toolbar").toolbarLite({
             items: [
                 { link: true, display: "添加", css: "icon-plus", showIcon: true, click: function(){add(this)}, url:"javascript:void(0)"},
                 { splitter: true }, 
                 { link: true, display: "删除", css: "icon-trash", showIcon: true, click: function(){trash(this)} ,selector: "#data-table .checkboxes", mustSelect: "请先选择数据！"},
                 { splitter: true }, 
                 { link: true, display: "修改", css: "icon-pencil", showIcon: true, click: function(){modify(this)}, selector: "#data-table .checkboxes", mustSelect: "请先选择数据！",singleSelect:"该操作只支持单选！"},
                 { link: true, display: "查询", css: "icon-search", showIcon: true, url:"findStudentByCollegeId.action"}
             ]
         });
      });
		function doPage(pageNo){
			document.pageForm.pageNo.value = pageNo;
			document.pageForm.submit();
			
		}
		function add(object){
			$(object).attr("data-toggle","modal");
			$(object).attr("data-target","#myModal");
		}
		function trash(object){
			var table = document.getElementById("data-table");
			var table1 = document.getElementById("data-table2");
			var tr = table.getElementsByTagName("tr");
			for(var i=1;i<tr.length;i++){
				if(tr[i].getElementsByTagName("input")[0].checked==true){
					var xueHao = tr[i].getElementsByTagName("td")[1].innerHTML;
					var name = tr[i].getElementsByTagName("td")[2].innerHTML;
					var profession = tr[i].getElementsByTagName("td")[4].innerHTML;
					var password = tr[i].getElementsByTagName("td")[7].innerHTML;
					var newtr = table1.insertRow();
					var newtd0 = newtr.insertCell();
					var newtd1 = newtr.insertCell();
					var newtd2 = newtr.insertCell();
					var newtd3 = newtr.insertCell();
					newtr.className="warning";
					newtd0.innerHTML = xueHao;
					newtd1.innerHTML = name;
					newtd2.innerHTML = profession;
					newtd3.innerHTML = password;
				}
			}
			$(object).attr("data-toggle","modal");
			$(object).attr("data-target","#myModal1");
		}
		function modify(object){
			var table = document.getElementById("data-table");
			var modalTable = document.getElementById("data-table3");
			var tr = table.getElementsByTagName("tr");
			for(var i=1;i<tr.length;i++){
				if(tr[i].getElementsByTagName("input")[0].checked==true){
					var xueHao = tr[i].getElementsByTagName("td")[1].innerHTML;
					var name = tr[i].getElementsByTagName("td")[2].innerHTML;
					var password = tr[i].getElementsByTagName("td")[7].innerHTML;
					var newtr = modalTable.insertRow();
					var newtd0 = newtr.insertCell();
					var newtd1 = newtr.insertCell();
					var newtd2 = newtr.insertCell();
					newtr.className="active"
					newtd0.innerHTML = '<input class="form-control placeholder-no-fix" autocomplete="off" disabled="disabled" value="'+xueHao+'" />';
					newtd1.innerHTML = '<input class="form-control placeholder-no-fix" autocomplete="off" disabled="disabled" value="'+name+'" />';
					newtd2.innerHTML = '<input class="form-control placeholder-no-fix" autocomplete="off" placeholder="密码" value="'+password+'" />';
				}
			}
			$(object).attr("data-toggle","modal");
			$(object).attr("data-target","#myModal2");
		}
		function deleteValue(){
			var xueHao = "";
			var table = document.getElementById("data-table2");
			var tr = table.getElementsByTagName("tr");
			for(var i=1;i<tr.length;i++){
				if(i<tr.length-1){
					xueHao = xueHao + tr[i].getElementsByTagName("td")[0].innerHTML+";";
				}else{
					xueHao = xueHao + tr[i].getElementsByTagName("td")[0].innerHTML;
				}	
			}
			window.location.href="deleteStudent.action?xueHaoString="+xueHao;
		}
		function modifyValue(){
			var table = document.getElementById("data-table3");
			var tr = table.getElementsByTagName("tr");
			var xueHao = tr[1].getElementsByTagName("input")[0].value;
			var password = tr[1].getElementsByTagName("input")[2].value;
			window.location.href="updateStudent.action?password="+password+"&xueHao="+xueHao;
		}
		function addValue(){
			var xueHao = document.getElementById("xueHao1").value;
			var name = document.getElementById("name1").value;
			//var gender = document.getElementById("gender1").value;
			var collegeId = document.getElementById("profession1").value;
			var id_card = document.getElementById("id_card1").value;
			//var phone = document.getElementById("phone1").value;
			//var password = document.getElementById("password1").value;
			if(xueHao!=""&&name!=""&&collegeId!=""&&id_card!=""){
				window.location.href="addStudent.action?xueHao="+xueHao+"&name="+name+"&collegeId="+collegeId+"&id_card="+id_card;
			}else{
				alert("存在空值");
			}
		}
	</script>
</body>
</html>

