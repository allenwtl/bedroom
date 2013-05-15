<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<sd:head cache="false"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<head>
<script language="javascprit" src="../jquery-1.2.6.pack.js" type="text/javascript"></script>
<script language="javascprit" src="../jquery.form.js" type="text/javascript"></script>
<script language="javascprit" src="js/getStuInfo.js" type="text/javascript"></script>

	<style type="text/css">
		body{
			text-align: center;
		}
		.topDiv{
			width:200px;   height: 20px;
			float: left;   border: 1px ;
			 cursor: pointer;
		}
		.topDiv:HOVER{
			text-decoration: underline;
			cursor: pointer;
		}
		#MaxDiv{
			width:1000px;
			margin:0 auto;	
		}
		#secondDiv table tr{text-align: center}
		
		input{font-size: 18px;height: 30px}
	</style>
</head>

<body >

	<div id="MaxDiv" align="center">
		
		<div style="clear: both;"></div>
		<div id="secondDiv" style="width: 1000px;border: 1 yellow;">
			<form id="myForm1" >
			<table id="first" border="1" width="1000px" >
				<tr><td colspan="4" ><font size="6">完善个人信息</font></td></tr>
				<tr style="height: 40px">
					<td rowspan="5" width="250px"  ><img src="imageUpload!getImg.action" height="200px" width="180px"/></td>
					<td width="250px"  ><a href="pictureUpload.jsp" >照片上传</a></td>
					<td width="250px"  >姓名</td>
					<td width="250px"  ><input id="name" name="studentsVo.studentsName" type="text" readonly="readonly" /></td>
				</tr>
				<tr style="height: 40px" >
					<td>&nbsp;</td>
					<td>姓名拼音</td>
					<td><input name="studentsVo.studentsPinyin" type="text"/></td>
				</tr>
				<tr style="height: 40px">
					<td>&nbsp;</td>
					<td>学号</td>
					<td><input id="number" name="studentsVo.studentsNumber" type="text" readonly="readonly" /></td>
				</tr>
				<tr style="height: 40px">
					<td>&nbsp;</td>
					<td>性别</td>
					<td><input id="sex" name="studentsVo.studentsSex"  readonly="readonly" /></td>
				</tr>
				<tr style="height: 40px">
					<td>&nbsp;</td>
					<td>出生日期</td>
					<td><sd:datetimepicker name="studentsVo.studentsBirthday" displayFormat="yyyy-MM-dd"  ></sd:datetimepicker></td>
				</tr>
				<tr style="height: 40px">
					<td>民族</td>
					<td><select id="nation" name="studentsVo.studentsNation">
							<option >---请选择---</option>
						</select>
					</td>
					<td>身份证号码</td>
					<td><input  name="studentsVo.studentsIdcard" type="text" /></td>
				</tr>
				<tr style="height: 40px">
					<td>班级名称</td>
					<td><input id="className" type="text" name="studentsVo.classNumber"  readonly="readonly" /></td>
					<td>政治面貌</td>
					<td>
						<select id="politics" name="studentsVo.studentsPolitics">
							<option>---请选择---</option>
						</select>
					</td>
				</tr>
				<tr style="height: 40px">
					<td>生源地</td>
					<td><input name="studentsVo.studentsNativeplace" type="text"/></td>
					<td>籍贯</td>
					<td><input name="studentsVo.studentsNative" type="text"/></td>
				</tr>
				<tr style="height: 40px">
					<td>家庭住址</td>
					<td colspan="3">
						<select id="province" name="studentsVo.sheng" onchange="demo2()" >
							<option selected="selected">--请选择--</option>
						</select>
						<select id="city" name="studentsVo.shi" onchange="demo3()" >
							<option selected="selected">--请选择--</option>
						</select>
						<select id="xian" name="studentsVo.xian">
							<option selected="selected">--请选择--</option>
						</select>
						<input id="tian" name="studentsVo.detail" type="text" size="20" />
					</td>
				</tr>
				<tr style="height: 40px">
					<td>邮编</td>
					<td><input id="postCode" name="studentsVo.studentsPostcode" type="text"  /></td>
					<td>联系电话</td>
					<td><input name="studentsVo.studentsPhone" type="text" /></td>
				</tr>
				<tr style="height: 40px">
					<td>考生类型</td>
					<td>
						<select name="studentsVo.studentsType">
						<option value="1" selected="selected">城应&nbsp;&nbsp;&nbsp;</option>
						<option value="2">城往</option>
						<option value="3">农应</option>
						<option value="4">农往</option>
						</select>
					</td>
					<td>培养层次</td>
					<td>
						<input id="nianzhi"  readonly="readonly" size="5" />年制
						<input id="ke"   readonly="readonly" size="5"/>科
					</td>
				</tr>
				<tr style="height: 40px">
					<td>入学时间</td>
					<td><sd:datetimepicker name="studentsVo.studentsInSchool" displayFormat="yyyy-MM-dd"  ></sd:datetimepicker></td>
					<td>QQ号码</td>
					<td><input name="studentsVo.studentsQq" type="text"/></td>
				</tr> 
				<tr>
					<td>搬入寝室时间</td>
					<td><sd:datetimepicker name="studentsVo.studentsInRoomTime" displayFormat="yyyy-MM-dd"></sd:datetimepicker></td>
					<td>邮箱</td>
					<td><input name="studentsVo.studentsEmail" type="text" /></td>
				</tr>
				<tr style="height: 40px"><td><br /></td><td>正确填完后,请点击</td><td><input type="submit" value="保存"/></td><td>&nbsp;</td></tr>
			</table>
			</form>
			
		</div>
		
	</div>

</body>


