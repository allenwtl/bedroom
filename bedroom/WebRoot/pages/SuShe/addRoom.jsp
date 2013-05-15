<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<link href="pages/SuShe/css/flexigrid.css" rel="stylesheet" type="text/css" />
<script language="javascprit" src="pages/jquery-1.4.2.min.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="pages/SuShe/js/flexigrid.js"></script>
<script language="javascript" src="pages/jquery.form.js" type="text/javascript"></script>
<script language='javascript' src='pages/SuShe/js/jquery.corner.js'></script>
<script language="javascprit" src="pages/SuShe/js/addRoomJS.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="pages/SuShe/css/addRoomCSS.css"/>
<body>

<div id="adTop">宿舍分配</div>
<div  id="arf">
<s:form id="myform" theme="simple"  >
	
	<div id="arfcmc">
		学院	：<s:select id="mycolleges" onchange="javascript:getMajorByCollege()"  list="#colleges" listKey="key" listValue="value" name="collegeId"  ></s:select>
		专业：<s:select id="mymajors" 	onchange="javascript:getClassesByMajor()" list="#firstMajors" listValue="majorName" name="majorId" listKey="majorId"  ></s:select>
		年份: <s:select id="arnianfen"  onchange="javascript:getClassesByNianfen()" list="1" name="nianfen"></s:select> 
		班级：<s:select id="myclasses"list="#firstClasses" listKey="class_id" listValue="class_name" name="classes"  ></s:select>
		性别：<s:radio list="#{1:'男',2:'女'}" name='sex' ></s:radio>
	</div>
	<div id="arFormDong">楼栋：<s:select id="mydongs"   list="#dongs" name="dongs" ></s:select></div>
	<div id="arfs">
		<s:submit value="提交"></s:submit>
	</div>
</s:form>

<div id="adShowNumber">
	剩余人数
</div>
 <div id="adShowEmptyRooms">
 	<table id="adShowEmptyRoomsTab">
		
 	</table>
 </div>
 

 </div>
  <div class='inforOfChuang'>
  	<s:form id='myform2'>
  		<input type="submit" value="提交"/>
  	</s:form>
  </div>
  </body>

