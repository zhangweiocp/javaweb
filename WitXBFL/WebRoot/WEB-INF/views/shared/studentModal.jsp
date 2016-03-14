<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!-- 添加模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">添加学生信息账号</h4>
         </div>
         <form>
         <div class="modal-body">
            <table class="table table-striped table-bordered table-hover" id="data-table1">
            	<thead>
		        	<tr>
		               <th>学号</th>
		               <th>姓名</th>
		               <th>学院</th>
		               <th>身份证&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		            </tr>
		        </thead>
		        <tr>
		        <th><input id="xueHao1" class="form-control placeholder-no-fix" autocomplete="off" placeholder="学号" /></th>
		        <th><input id="name1" class="form-control placeholder-no-fix" autocomplete="off" placeholder="姓名" /></th>
		        <!--<th><input id="gender1" class="form-control placeholder-no-fix" autocomplete="off" placeholder="性别" /></th>-->
		        <!--<th><input id="profession1" class="form-control placeholder-no-fix" autocomplete="off" placeholder="学院编号" /></th>-->
		        <th>
		        	<div class="form-group">
			        	<select class="form-control" id="profession1">
							<c:forEach var="college" items="${colList}">
								<option>${college.collegeId}${ college.collegeName }</option>
							</c:forEach>
			         	</select>
			        </div>
		        </th>
		        <th><input id="id_card1" class="form-control placeholder-no-fix" autocomplete="off" placeholder="身份证" /></th>
		        <!--<th><input id="phone1" class="form-control placeholder-no-fix" autocomplete="off" placeholder="电话" /></th>-->
		        <!--<th><input id="password1" class="form-control placeholder-no-fix" autocomplete="off" placeholder="密码" /></th>-->
		        </tr>
            </table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="addValue();">
                           提交更改
            </button>
         </div>
         </form>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
	<!-- 删除模态框（Modal） -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="clearRow('data-table2');">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">确定删除学生账号？</h4>
         </div>
         <div class="modal-body">
            <table class="table table-striped table-bordered table-hover" id="data-table2">
            	<thead>
		        	<tr>
		               <th>学号</th>
		               <th>姓名</th>
		               <th>学院编号</th>
		               <th>密码</th>
		            </tr>
		        </thead>
            </table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="clearRow('data-table2');">关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="deleteValue();">
                           提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
<!-- 修改模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true" onclick="clearRow('data-table3');">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">修改学生账号密码</h4>
         </div>
         <div class="modal-body">
            <table class="table table-striped table-bordered table-hover" id="data-table3">
            	<thead>
		        	<tr>
		               <th>学号</th>
		               <th>姓名</th>
		               <th>密码</th>
		            </tr>
		        </thead>
            </table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal" onclick="clearRow('data-table3');">关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="modifyValue();">
                           提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
<script type="text/javascript">
		function clearRow(object){
			var table = document.getElementById(object);
			var tr = table.getElementsByTagName("tr");
			var len = tr.length;
			for(var i=1;i<len;i++){
				table.deleteRow(1);
		    }
		}
</script>