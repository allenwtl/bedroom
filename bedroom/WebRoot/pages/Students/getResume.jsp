<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<sd:head cache="false"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<head>
<script type="text/javascript" src="../jquery-1.2.6.pack.js" ></script>
<script type="text/javascript" src="../jquery.form.js" ></script>
<script type="text/javascript" src="js/getResume.js" ></script>

<style type="text/css">
		body{text-align: center;}
		#myDiv form table tr{text-align: center}
		input{font-size: 18px;height: 30px}
		#myDiv{margin:0 auto}
</style>

</head>
<body >
	<div id="myDiv" style="width: 1000px;" align="center" >
		<form id="myForm2" >
			<table id="second"  border="1" >
				<tr><td colspan="5"><font size="6">个人简历(从小学算起)</font></td></tr>
				<tr>
					<td width="150px">自何年何月</td>
					<td width="150px">至何年何月</td>
					<td width="300px">在何地学习或工作</td>
					<td width="150px">证明人</td>
					<td width="250px">操作</td>
				</tr>
				<tr id="row" class="CaseRow">
					<td width="150px"><sd:datetimepicker id="firstBegin"  name="resume.resumeBegintime" displayFormat="yyyy-MM" ></sd:datetimepicker></td>
					<td width="150px"><sd:datetimepicker id="firstEnd" name="resume.resumeEndtime" displayFormat="yyyy-MM" ></sd:datetimepicker></td>
					<td width="300px"><input name="resume.resumeLean" type="text" size="30"/></td>
					<td width="150px"><input name="resume.resumePerson" type="text" size="10" /></td>
					<td width="250px"><input type="button" value="添加一行" onclick="add(this)" /><input type="button" value="删除本行" class="imgdel" onclick="del(this)" /></td>
				</tr>
				<tr id="lastLine" style="height: 40px"><td>&nbsp;</td><td>正确填完后,请点击</td><td><input type="submit" value="保存" /></td><td>&nbsp;</td><td>&nbsp;</td></tr>
			</table>
		</form>
		
		
		<table>
			<tr id="rowHidden" class="CaseRow" style="display: none">
				<td width="150px"><input id="beginTime" name="resume.resumeBegintime" size="13"/></td>
				<td width="150px"><input id="endTime" name="resume.resumeEndtime" size="13"/></td>
				<td width="300px"><input name="resume.resumeLean" type="text" size="30"/></td>
				<td width="150px"><input name="resume.resumePerson" type="text" size="10" /></td>
				<td width="250px"><input type="button" value="添加一行" onclick="add(this)" /><input type="button" value="删除本行" class="imgdel" onclick="del(this)"/></td>
			</tr>
		</table>
		
	</div>
</body>