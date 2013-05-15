<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>学院添加系</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../jquery-1.4.2.min.js" ></script>
	<script type="text/javascript" src="../jquery.form.js" ></script>
	<script type="text/javascript" src="js/addMajor.js" ></script>
	<style type="text/css">
	
		body{text-align: center;}
		#myDiv form table tr{text-align: center}
		input{font-size: 18px;height: 30px}
		#myDiv{margin:0px auto}

	</style>
  </head>
  
  <body>
    <div id="myDiv"  style="width: 1000px;">
	    <form id="myForm">
		    <table id="myTable" border="1">
		    	<thead>
		    		<tr>
		    			<th width="250px">学院</th>
		    			<th width="250px">系名称</th>
		    			<th width="300px">操作</th>
		    		</tr>
		    	</thead>
		    	
		    	<tbody  >
		    		<tr class="caseRow" id="row">
		    			<td>
		    				<select class="colleges" name="college">
		    					<option>----请选择---</option>
		    				</select>
		    			</td>
		    			<td><input type="text" name="majorName" size="23"/></td>
		    			<td><input type="button" value="添加一行" onclick="add()"/><input type="button" value="删除一行" onclick="del(this)"/></td>
		    		</tr>
		    	</tbody>
		    	<tfoot>
		    		<tr><td colspan="6" align="center"><input type="submit" value="提交"/></td></tr>
		    	</tfoot>
		    </table>
    	</form>
    	
    	<table >
    		<tbody  style="display: none" >
		    		<tr id="hiddenT" class="caseRow">
		    			<td>
		    				<select class="colleges" name="college">
		    					<option>----请选择---</option>
		    				</select>
		    			</td>
		    			<td><input type="text" name="majorName" size="23"/></td>
		    			<td><input type="button" value="添加一行" onclick="add()"/><input type="button" value="删除一行" onclick="del(this)"/></td>
		    		</tr>
		    	</tbody>
    	</table>
    	
    </div>
    
    
  </body>
</html>
