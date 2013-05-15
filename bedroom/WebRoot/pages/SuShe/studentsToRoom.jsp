<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<head></head>

<script type="text/javascript" language="javascript" src="pages/jquery-1.4.2.min.js"></script>
<script type="text/javascript" language="javascript" src="pages/jquery.form.js"></script>
<script type="text/javascript" language="javascript" src="pages/jquery.chromatable.js"></script>
<script type="text/javascript" language="javascript" src="pages/SuShe/js/studentsToRoomJS.js"></script>
<link href="pages/SuShe/css/studentsToRoomCSS.css" type="text/css" rel="stylesheet"/>
<link href="pages/SuShe/css/style.css" type="text/css" rel="stylesheet"/>
<body>
	<div class="strTop">
		<br><br><s:form id="strForm" theme="simple"  >
				<div id="str1">  
					学院	：<s:select id="mycolleges" onchange="javascript:getMajorByCollege()"  list="#colleges" listKey="key" listValue="value" name="collegeId"  ></s:select>
					专业：<s:select id="mymajors" 	onchange="javascript:getClassesByMajor()" list="#firstMajors" listValue="majorName" name="majorId" listKey="majorId"  ></s:select>
					年份: <s:select id="arnianfen"  onchange="javascript:getClassesByNianfen()" list="1" name="nianfen"></s:select> 
					班级：<s:select id="myclasses" list="#firstClasses" listKey="class_id" listValue="class_name"  name="classes"  ></s:select>
				</div>
				<div id="str2">
					<s:submit value="提交"></s:submit>
				</div>
		</s:form>
	</div>
	<div class="strInforOfStudents">
		<div>
			<span style="background-color:red;" onclick="javascript:getStuBySex(1)">男生</span>
			<span style="background-color:green;" onclick="javascript:getStuBySex(0)">女生</span>
		</div>
		<table class="strInforOfStudentsTAB">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>籍贯</th>
			</tr>
			
		</table>
	</div>
	<div class="strInforOfRoom" >
		<table width="100px">
			<tr>
				<th>宿舍号</th>
				<th>床位</th>
				<th>学院班级</th>
				<th>学号</th>
				<th>姓名</th>
				<th>籍贯</th>
			</tr>
		
		</table>
	</div>
	
	<div id="myformDiv">
		<form id="myform"></form>
	</div>
	
	<div>
		<input id='tiJiaoAnNiu' onclick='javascript:tiJiaoMyForm()' type='button' value='提交'/>
	</div>
	<div id="suiYiMode" style='display: none'>
	</div>
</body>
