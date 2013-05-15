<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<body>


<s:form  action="testAction!.action">
		<table id="thirdTableRight" style="width:490px ;height145px; float:left;" border="1">
			<tr><td width="20px">称谓</td><td width="40px">姓名</td><td width="40px">政治面貌</td><td width="300px">工作单位</td><td width="93px">联系电话</td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="8" maxlength="13"/></td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="8" maxlength="13"/></td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="8" maxlength="13"/></td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="8" maxlength="13"/></td></tr>
		</table>
		<s:submit value="提交"></s:submit>
</s:form>
</body>

