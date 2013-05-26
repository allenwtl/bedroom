<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../jquery-1.4.2.min.js"></script>
	<script src="../jquery.form.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/modifyInfo.js"></script>
	<style type="text/css">
		input{
			width: 280px; height: 40px;font-size: 15px; line-height: 40px;
		}
	</style>
	
  </head>
  
  <body>
  <p align="center" style="font-size: 30">修改个人信息</p>
  	<table width="60%"  border="1" ><tr><td id="first">个人详细信息</td><td id="second">个人简历</td><td id="third">家庭成员</td><td id="forth">社会关系</td></tr></table>
    <form id="myForm" style="padding-top: 0px">
    	<table  id="theTable" width="60%" border="1"  >
    		<tr >
    			<td>姓名</td><td><input id="name" name="name" type="text" onclick="update(this)" /></td><td>学号</td><td><input id="number" name="number" type="text" onclick="update(this)" /></td>
    		</tr>
    		<tr >
    			<td>姓名拼音</td><td><input id="namePinYin" name="pinyin" type="text" onclick="update(this)"/></td><td>性别</td><td><input id="sex" name="sex" type="text" onclick="update(this)"/></td>
   			</tr>
    		<tr >
    			<td>民族</td><td id="showNation"><input id="nation" name="nation"  type="text" onclick="update(this)"/></td><td>出生日期</td><td><input id="birthday" name="birthday" type="text" onclick="update(this)" /></td>
    		</tr>
    		<tr >
    			<td>身份证号码</td><td><input id="card" name="card" type="text" onclick="update(this)"/></td><td>政治面貌</td><td id="showPolitical"><input id="political" name="political" type="text" onclick="update(this)"/></td>
    		</tr>
    		<tr >
    			<td>所属班级</td><td><input id="clazz" name="clazz" type="text" onclick="update(this)"/></td><td>生源地</td><td><input id="origin" name="origin" type="text" onclick="update(this)" /></td>
    		</tr>
    		<tr >
    		    <td>籍贯</td><td><input id="native" name="jiguan" type="text" onclick="update(this)"/></td><td>家庭住址</td><td><input id="homeAddress" name="address" type="text" onclick="update(this)"/></td>
    		</tr>
    		<tr >
    			<td>邮编</td><td><input id="code" name="code" type="text" onclick="update(this)"/></td><td>联系方式</td><td><input id="phone" name="phone" type="text" onclick="update(this)"/></td>
    		</tr>
    		<tr >
    			<td>考生类型</td><td><input id="type" name="type" type="text" onclick="update(this)"/></td><td>邮箱</td><td><input id="email" name="email" type="text" onclick="update(this)"/></td>
    		</tr>
    		<tr >
    			<td>入学时间</td><td><input id="inSchool" name="inschool" type="text" onclick="update(this)" /></td><td>寝室详细地址</td><td><input id="bedroom" name="bedroom" type="text" onclick="update(this)"/></td>
    		</tr>
    		<tr >
    			<td>QQ号码</td><td><input id="qq" name="qq" type="text" onclick="update(this)"/></td><td>入寝室时间</td><td><input id="inBedRoom" name="inbedroom" type="text" /></td>
    		</tr>
    		<tr >
    			<td colspan="4"><input type="submit" value="提交"/></td>
    		</tr>
    	</table>
    	
    </form>
    
    
    
    <form id="myForm2" style="display: none">
    	
    </form>
    
  </body>
</html>
