<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>添加班级</title>
    
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
	<script type="text/javascript" src="js/addClass.js"></script>
  	<style type="text/css">
  		body {TEXT-ALIGN: center;}
		#myDiv form table tr{text-align: center}
		input{font-size: 18px;height: 30px}
		#myDiv{margin-right: auto; margin-left: auto; }
		select{width:150px}

	</style>
  	
  
  </head>
  
  <body>
    <h3 align="center">添加班级</h3>
    <div id="myDiv"  style="width: 1000px;">
    	<form id="myForm">
    		<table id="myTable" border="1">
    			<tr>
    				<th>学院</th>
    				<th>所在系</th>
    				<th>开班年份</th>
    				<th>班级属性</th>
    				<th>班级名称</th>
    				<th>班级个数</th>
    				<th colspan="2">&nbsp;</th>
    			</tr>
    			<tr>
    				<td>
    					<select id="college" name="college" onchange="queryMajor()">
    						<option>---请选择---</option>
    					</select>
    				</td>
    				<td>
    					<select id="major" name="major">
    						<option>---请选择---</option>
    					</select>
    				</td>
    				<td>
    					<input id="year" name="year" type="text" size="8"/>
    				</td>
    				<td>
    					<select id="kezhi" name="kezhi">
    						<option>---请选择---</option>
    					</select>
    				</td>
    				<td><input id="className" name="className" /></td>
    				<td><input id="amount" name="amount" size="5"/></td>
    				<td><input type="button" value="预览" onclick="showPre()"/></td>
    				<td><input type="submit" value="提交"/></td>
    			</tr>
    		</table>
    		
    		
    	</form>
    </div>
  </body>
</html>
