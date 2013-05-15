<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<sd:head cache="false"/>

<head>
<title>湖南工业大学学生学籍表</title>
<style type="text/css">
	.topDiv{
		float:left;
	}
	body{
		font-weight: 800;
		font-size:medium;
	}
	input{
		font-size: medium;
		font-weight: 500;
	}
	#firstTable{
		border:1;
		margin-left: 183px;
		width: 998px;
	}
</style>
</head>

<body>

<h1 align="center">湖南工业大学学生学籍表</h1>
<s:form theme="simple" method="POST" enctype="multipart/form-data" id="formId" action="testAction_showStuInfo.action">
	<!-- 学院    专业   班级    编号 -->
	<div  id="firstDiv" style="width:1000px;height: 25x;margin-left: 183px;">
		<div class="topDiv" style=" width:200px;">
			<input name="collegeName" type="text" size="12" />学院(部)
		</div>
		<div class="topDiv" style="width:240px;padding-left: 100px;">
			<input name="major" type="text" size="20" style="height: 25px;"/>专业
		</div>
		<div class="topDiv" style="width:260px;padding-left:80px;">
			<input name="class" type="text" size="10"/>班
		</div>
		<div class="topDiv" style="padding-left:36px;">
			NO:<input name="number" type="text" size="5"/>
		</div>
	</div>
	<!--主体 -->
	<div id="mainDiv" style="width: 1000px;height: 245px;clear:both;" >
		<table id="firstTable" border="1">
			<tr>
				<td width="100px">姓名</td>
				<td width="300px"><input name="students.studentsName" type="text"/></td>
				<td width="100px">姓名拼音</td>
				<td width="200px" colspan="2"><input name="students.studentsPinyin" type="text"/></td>
				<td rowspan="5" colspan="2" width="250px"><img id="myPic"  alt="正在努力为您加载" src=""></td>
				<td rowspan="5" width="40px">
					<font size="3" color="red">照片最好在9K-50K</font><br><br>
					<input name="image" type="file" size="4"  /><br><br>
					<input type="submit" onclick="aa()" value="上传照片"/>
				</td>
			</tr>
			<tr>
				<td>学号</td>
				<td><input name="students.studentsId" type="text"/></td>
				<td>政治面貌</td>
				<td colspan="2">
					<select size="1" name="students.studentsPolitics">
						<option value="1">共青团员</option>
						<option value="2">预备党员</option>
						<option value="3">中共党员</option>
						<option value="0">少先队员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><sd:datetimepicker name="students.studentsBirthday" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td>
				<td>性别</td>
				<td colspan="2"><s:radio list="#{0:'男',1:'女'}" name="students.studentsSex" value="0"></s:radio></td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td><input name="students.studentsIdcard" type="text" maxlength="18"/></td>
				<td>民族</td>
				<td colspan="2"><input name="students.studentsNation" type="text" /></td>
			</tr>
			<tr>
				<td>生源地</td>
				<td><input name="students.studentsNativeplace" type="text"/></td>
				<td>籍贯</td>
				<td colspan="2"><input name="students.studentsNative" type="text"/></td>
			</tr>
			<tr>
				<td>家庭住址</td>
				<td colspan="2"><input name="students.studentsAddress" type="text" size="31"/></td>
				<td width="60px">邮编</td>
				<td width="140px"> <input name="students.studentsPostcode" type="text" size="6" maxlength="7"/></td>
				<td width="80px">联系电话</td>
				<td colspan="2"><input name="students.studentsPhone" type="text" maxlength="11"/></td>
			</tr>
			<tr>
				<td>考生类型</td>
				<td>
					<select name="students.studentsType">
						<option value="1">城应&nbsp;&nbsp;&nbsp;</option>
						<option value="2">城往</option>
						<option value="3">农应</option>
						<option value="4">农往</option>
					</select>
				</td>
				<td>培养层次</td>
				<td colspan="2">
					<select name="major.majorYear"><option>3&nbsp;&nbsp;</option><option>4</option><option>5</option></select>年制
					<select name="major.majorBenke"><option>本&nbsp;&nbsp;</option><option>专</option></select>科
				</td>
				<td>入学时间</td>
				<td colspan="2"><sd:datetimepicker name="students.studentsInschool" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td>
			</tr>
			<tr>
				<td>异动情况</td>
				<td colspan="7"><input name="remark.remarkTime" type="text" size="4" maxlength="4"/>年<input name="remark.remarkReason" type="text" size="2" maxlength="2"/>月因<input name="reason" type="text" size="80"/></td>
			</tr>
		</table>
	</div>
	
	<!-- 个人简历部分和家庭成员部分 -->
	<div id="secondDiv" style="width: 1000px;clear: both;height: 325px;margin-left: 183px;">
		<table id="secondTableLeft" style="width:499px; height180px; float: left;" border="1" >
			<tr><td rowspan="6" width="10px">个人简历(从小学算起)</td><td>自何年何月</td><td>至何年何月</td><td>在何地学习或工作</td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="resume.resumeLean" size="20"/></td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="" size="20"/></td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="" size="20"/></td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="" size="20"/></td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="" size="20"/></td></tr>
		</table>
		<table id="secondTableRight" style="width:492px;height180px;  float: left;" border="1" >
			<tr><td>自何年何月</td><td>至何年何月</td><td>在何地学习或工作</td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="" size="20"/></td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="" size="20"/></td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="" size="20"/></td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="" size="20"/></td></tr>
			<tr><td><sd:datetimepicker name="resume.resumeBegintime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><sd:datetimepicker name="resume.resumeEndtime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td><td><input name="" size="20"/></td></tr>
		</table>
		<table id="thirdTableLeft" style="width:499px ;height145px; float:left;" border="1">
			<tr><td rowspan="5" width="10px">家庭成员</td><td  width="20px">称谓</td><td width="40px">姓名</td><td width="40px">政治面貌</td><td width="300px">工作单位</td><td width="88px">联系电话</td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="6" maxlength="13"/></td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="6" maxlength="13"/></td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="6" maxlength="13"/></td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/><input type="hidden" id="__multiselect_formId_homenumber.homenumberTitle" value="" name="__multiselect_homenumber.homenumberTitle"/></td><td><input name="homenumber.homenumberName" size="8"/><input type="hidden" id="__multiselect_formId_homenumber.homenumberName" value="" name="__multiselect_homenumber.homenumberName"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select><input type="hidden" id="__multiselect_formId_homenumber.homenumberPolitical" value="" name="__multiselect_homenumber.homenumberPolitical"/></td><td><input name="homenumber.homenumberUnit" size="20"/><input type="hidden" id="__multiselect_formId_homenumber.homenumberUnit" value="" name="__multiselect_homenumber.homenumberUnit"/></td><td><input name="homenumber.homenumberPhone" type="text" size="6" maxlength="13"/><input type="hidden" id="__multiselect_formId_homenumber.homenumberPhone" value="" name="__multiselect_homenumber.homenumberPhone"/></td></tr>
		</table>
		<table id="thirdTableRight" style="width:490px ;height145px; float:left;" border="1">
			<tr><td width="20px">称谓</td><td width="40px">姓名</td><td width="40px">政治面貌</td><td width="300px">工作单位</td><td width="93px">联系电话</td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="8" maxlength="13"/></td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="8" maxlength="13"/></td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="8" maxlength="13"/></td></tr>
			<tr><td><input name="homenumber.homenumberTitle" size="4"/></td><td><input name="homenumber.homenumberName" size="8"/></td><td><select name="homenumber.homenumberPolitical"><option value="">群众&nbsp;&nbsp;</option><option value="">少先队员</option><option value="">团员</option><option value="">预备党员</option><option value="">党员</option></select></td><td><input name="homenumber.homenumberUnit" size="20"/></td><td><input name="homenumber.homenumberPhone" type="text" size="8" maxlength="13"/></td></tr>
		</table>
	</div>
	
	<!-- 毕业部分 -->
	<div id="thirdDiv" style="width: 1000px;clear: both;height: 95px;margin-left: 183px;">
		<table id="fourthTable" style="width:998px ;" border="1">
			<tr><td width="10px" rowspan="3">毕业</td><td width="988px">毕业时间<sd:datetimepicker name="graduate.graduateTime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td></tr>
			<tr><td>获得<select name="graduate"><option value="">专&nbsp;&nbsp;</option><option value="">本</option></select>科毕(结)业证书,证书电子注册编号为:<input name="graduate.graduateBennumber" /></td></tr>
			<tr><td>获得<input name="" />学学士学位证书,证书编号为:<input name="graduate.graduateXuenumber"/></td></tr>
		</table>
	</div>
	
	<!-- 备注部分 -->
	<div id="fourthDiv" style="width:1000px;margin-left:183px;">
		<table id="fifthTable" style="width:998px;height: 140px;" border="1" height="100px">
			<tr><td width="10px">备注</td><td><s:textarea name="" cssStyle="overflow:visible" rows="6" cols="116" ></s:textarea></td></tr>
		</table>
	</div>


	
	<div id="lastDiv" style="width:1000px;margin-left:183;" align="center">
	<input type="submit" value="调教"></input>
	</div>
	
</s:form>


</body>

<script type="text/javascript">
	function aa(){
		var value = document.getElementsByName("image")
		var  str = value[0].value;
		alert(str);
		document.getElementById("myPic").src="${pageContext.request.contextPath}/image/"+str;
	}
	
	function upload(){
		location="executeAction_showStuInfo!.action";
	}
</script>

