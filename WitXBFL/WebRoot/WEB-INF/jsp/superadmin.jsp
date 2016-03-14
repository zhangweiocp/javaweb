<%@ page language="java" import="java.util.*,cn.wit.zhangwei.entity.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>My JSP 'login.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript">
		function addvalue(){
			var id = document.getElementById("new0").value;
			var username = document.getElementById("new1").value;
			var password = document.getElementById("new2").value;
			var rolelevel = document.getElementById("new3").value;
			var detail = document.getElementById("new4").value;
			if(username!=""&&password!=""){
				window.location.href="addrole.action?id="+id+"&username="+username+"&password="+password+"&rolelevel="+rolelevel+"&detail="+detail;
			}else{
				alert("用户名或密码不能为空");
			}
		}
		function additem(){
			var table = document.getElementById("table");
			var i = table.rows.length;
			var newtr = table.insertRow();
			var newtd0 = newtr.insertCell();
			var newtd1 = newtr.insertCell();
			var newtd2 = newtr.insertCell();
			var newtd3 = newtr.insertCell();
			newtd0.align="center";
			newtd1.align="center";
			newtd2.align="center";
			newtd3.colSpan="2";
			newtd3.align="center";
			//设置列内容和属性
			newtd0.innerHTML = '<input type="hidden" value="'+i+'" id="new0"><input type="text" id="new1"/>';
			newtd1.innerHTML = '<input type="text" id="new2"/>';
			newtd2.innerHTML = '<input type="hidden" value="1" id="new3" ><input type="text" id="new4"/>';
			newtd3.innerHTML = '<button type="button" onclick="addvalue();">提交</button>';
		}
function ask(isdelete){
		var confirm = window.confirm("确定要删除吗？");
		var idValue = isdelete.value;
		//alert(idValue);
		if(confirm){
			window.location.href="deleterole.action?id="+idValue;
		}
	}
function enable(object) {
	//document.getElementById("table").disabled="";
	var parent = object.parentNode.parentNode;
	var index = parent.rowIndex;
	for(var i=5*(index-1)+1;i<=5*index;i++){
		if(i%5<=3&&i%5>=1){
			document.getElementById(i).disabled="";
		}
		if(i%5==4){
			document.getElementById(i).style.display="none";
		}
		if(i%5==0){
			document.getElementById(i).style.display="inline";
		}
	}
	//for(var i =0;i<=2;i++){
	//document.getElementById("table").rows[list].cells[i].firstChild.readonly="";
	//alert(document.getElementById("table").rows[list].cells[i].firstChild.innerHTML);
	//}
	//var list = document.getElementsByName(index);
	//for ( var i = 0; i <= list.length; i++) {
		//if (i <= 2) {
			//list[i].disabled = "";
		//}
		//if (i == 3) {
			//list[i].style.display = "none"
		//}
		//if (i == 4) {
			//list[i].style.display = "inline"
		//}
	//}
}
</script>

	</head>

	<body>
		欢迎您：超级管理员
		<br>
		&nbsp;&nbsp;账户管理
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;院管理员
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="query.action">查询</a>
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="add.action">添加</a>
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="update.action">修改</a>
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="delete.action">删除</a>
		<br>
		<br>
		<table border="1" width=70% id="table">
			<tr>
				<th>
					用户名
				</th>
				<th>
					密码
				</th>
				<th>
					管理员
				</th>
				<td align="center" colspan="2">
					<button type="button" onclick="additem();">
						添加
					</button>
				</td>
			</tr>
			<c:set var="index" value="0" />
			<c:forEach var="role" items="${list}">
				<form action="updaterole.action" method="post">
					<input type="hidden" value="${role.id}" name="id">
					<input type="hidden" value="${role.roleLevel}" name="rolelevel" />
					<tr>
						<td align="center">
							<c:set var="index" value="${index+1}" />
							<input type="text" value="${role.userName}" id="${index}"
								name="username" disabled="disabled" />
						</td>
						<td align="center">
							<c:set var="index" value="${index+1}" />
							<input type="text" value="${role.passWord}" id="${index}"
								name="password" disabled="disabled" />
						</td>
						<td align="center">
							<c:set var="index" value="${index+1}" />
							<input type="text" value="${role.detail}" id="${index}"
								name="detail" disabled="disabled" />
						</td>
						<td align="center">
							<c:set var="index" value="${index+1}" />
							<button type="button" id="${index}" onclick="enable(this);">
								修改
							</button>
							<c:set var="index" value="${index+1}" />
							<button type="submit" id="${index}" style="display: none">
								提交
							</button>
						</td>
						<td align="center">
							<button type="button" value="${role.id}" onclick="ask(this);">
								删除
							</button>
						</td>
					</tr>
				</form>
			</c:forEach>

			<!--  <c:if test="${null!=roleList}">-->

			<!-- 	</c:if> -->
		</table>


		<%-- 			<%

				if(null!=roleList){
			for (Role role : roleList) {
		%>
		用户名：<%=role.getUserName()%><br>
		密码：<%=role.getPassWord()%><br>
		权限级别：<%=role.getRoleLevel() %><br>
		<%
			}}
		%>--%>
	</body>
</html>
