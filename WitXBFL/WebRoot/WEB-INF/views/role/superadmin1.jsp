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
						<li>管理员<%-- ${requestScope.permissionMenu.subName}--%>
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
							<form action="findAdmin.action" class="form-horizontal" method="POST">
								<div class="form-body">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-3">用户名</label>
												<div class="col-md-9">
													<input name="userName"
														class="form-control placeholder-no-fix" autocomplete="off"
														placeholder="用户名" />
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label col-md-3">学院编号</label>
												<div class="col-md-9">
													<input name="detail"
														class="form-control placeholder-no-fix" autocomplete="off"
														placeholder="学院编号" />
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
                     <div class="caption"><i class="icon-table"></i>管理员列表</div>
                  </div>
                  <div class="portlet-body">
                     <div class="table-toolbar"></div>
                     <div class="dataTables_wrapper form-inline" role="grid">
	                     <div class="table-scrollable">
		                     <table class="table table-striped table-bordered table-hover" id="data-table">
		                        <thead>
		                           <tr>
		                              <th class="table-checkbox"><input type="checkbox" class="group-checkable"/></th>
		                              <th>用户名</th>
		                              <th>密码</th>
		                              <th>学院编号</th>
		                              <th>学院</th>
		                           </tr>
		                        </thead>
		                        <tbody>
		                        	<c:forEach items="${ list }" var="role">
							        <tr class="odd gradeX">
							        	<td class="check_cell">
									        <input type="checkbox" class="checkboxes" id="checkbox" value="${ role.id }" />
									        <input type="hidden" name="rolelevel" value="${ role.roleLevel }">
									    </td>
							            <td>${ role.userName }</td>
							            <td>${ role.passWord }</td>
							            <td>${ role.collegeId }</td>
							            <td>${ role.collegeName }</td>
							        </tr>
							        </c:forEach>
		                        </tbody>
		                     </table>
	                     </div>
	       				<!--   <p:page pageNo="5" pageSize="5" totalSize="22"/>
	       				 <form name="pageForm" action="superadmin1.jsp" method="post">
	       				 	<input type="hidden" value="${pageNo}" name="pageNo" />
	       				 	<input type="hidden" value="${pageSize}" name="pageSize" />
	       				 	<input type="hidden" value="${totalSize}" name="totalSize" />
	       				 </form>-->
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
	<!-- END FOOTER -->
	<%@ include file="../shared/adminModal.jsp"%>
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
                 { link: true, display: "查询", css: "icon-search", showIcon: true, url:"superadmin.action"}
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
					var id = tr[i].getElementsByTagName("input")[0].value;
					var userName = tr[i].getElementsByTagName("td")[1].innerHTML;
					var password = tr[i].getElementsByTagName("td")[2].innerHTML;
					var detail = tr[i].getElementsByTagName("td")[4].innerHTML;
					if(1 != id){
						var newtr = table1.insertRow();
						var newtd0 = newtr.insertCell();
						var newtd1 = newtr.insertCell();
						var newtd2 = newtr.insertCell();
						newtr.className="warning";
						newtd0.innerHTML = userName;
						newtd1.innerHTML = password;
						newtd2.innerHTML = detail;
					}
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
					var id = tr[i].getElementsByTagName("input")[0].value;
					var userName = tr[i].getElementsByTagName("td")[1].innerHTML;
					var password = tr[i].getElementsByTagName("td")[2].innerHTML;
					var detail = tr[i].getElementsByTagName("td")[4].innerHTML;
					var newtr = modalTable.insertRow();
					var newtd0 = newtr.insertCell();
					var newtd1 = newtr.insertCell();
					var newtd2 = newtr.insertCell();
					newtr.className="active"
					newtd0.innerHTML = '<input class="form-control placeholder-no-fix" autocomplete="off" placeholder="用户名" value="'+userName+'" />'+'<input type="hidden" value="'+id+'" />';
					newtd1.innerHTML = '<input class="form-control placeholder-no-fix" autocomplete="off" placeholder="密码" value="'+password+'" />';
					newtd2.innerHTML = '<input class="form-control placeholder-no-fix" autocomplete="off" disabled="disabled" placeholder="学院" value="'+detail+'" />';
				}
			}
			$(object).attr("data-toggle","modal");
			$(object).attr("data-target","#myModal2");
		}
		function addValue(){
			var id = document.getElementById("id1").value;
			var username = document.getElementById("userName1").value;
			var password = document.getElementById("password1").value;
			var rolelevel = document.getElementById("roleLevel1").value;
			var detail = document.getElementById("detail1").value;
			if(username!=""&&password!=""){
				window.location.href="addAdmin.action?id="+id+"&username="+username+"&password="+password+"&rolelevel="+rolelevel+"&detail="+detail;
			}else{
				alert("用户名或密码不能为空");
			}
		}
		function deleteValue(){
			var idnum = [];
			var j = 0;
			var table = document.getElementById("data-table");
			var tr = table.getElementsByTagName("tr");
			for(var i=1;i<tr.length;i++){
				if(tr[i].getElementsByTagName("input")[0].checked==true){
					idnum[j] = tr[i].getElementsByTagName("input")[0].value;
					j++;
				}
			}
			var id ="";
			for(var k=0;k<idnum.length;k++){
			if(1!=idnum[k]){
					if(k!=idnum.length-1){
						id=id+idnum[k]+";";
					}else{
						id=id+idnum[k];
					}
			    }
				
			}
			window.location.href="deleteAdmin.action?id="+id;
		}
		function modifyValue(){
			var table = document.getElementById("data-table3");
			var tr = table.getElementsByTagName("tr");
			var userName = tr[1].getElementsByTagName("input")[0].value;
			var id = tr[1].getElementsByTagName("input")[1].value;
			var password = tr[1].getElementsByTagName("input")[2].value;
			var detail = tr[1].getElementsByTagName("input")[3].value;
			window.location.href="updateAdmin.action?id="+id+"&userName="+userName+"&password="+password+"&detail="+detail;
		}
 
	</script>
</body>
</html>
