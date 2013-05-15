
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sd" uri="/struts-dojo-tags" %>
<sd:head /> 

<html>
  <head>   
    <title>My JSP 'empRegistInput.jsp' starting page</title>
  </head>
  <body>
  	<s:form action="regist2SuccLeAction!.action" method="post" theme="simple">
  请假类型<s:textfield name="le1vo.leavetype" leabel="请假类型"></s:textfield><!-- 请假类型 --><br>

  	允许请假的老师的编号<s:textfield name="le1vo.teacher"></s:textfield><!-- 允许请假的老师的编号 -->	
  	
  	<table width="80%" border="1" align="center"> 		
  		<thead text-align="center">湖南工业大学财经学院学生请假审批表</thead>
  		
  		<tbody align="center">
  			<tr>
  				<td>姓名</td><td><input type="text" name="studentName" size="10"></td>
  				
  				<td>班级</td><td><input type="text" name="stuName" size="10"></td>
  				<td>宿舍</td><td><input type="text" name="stuName" size="10"></td>
  			</tr>
  			<tr>
  				<td>外出时间</td><td colspan="2">  	
  				
  				<sd:datetimepicker name="le1vo.leaveBegintime" displayFormat="yyyy-MM-dd hh:mm:ss"></sd:datetimepicker>			
  				<sd:datetimepicker name="le1vo.leaveBegintime"></sd:datetimepicker> 									
  				</td>
  				<td>预计返回时间</td>
  				<td colspan="2">
  				<sd:datetimepicker name="le1vo.leaveEndtime"></sd:datetimepicker>
  				<!--<input class="Wdate" type="text" onfocus="new WdatePicker(this)" name="endTime"/> --> 				
  				</td>
  			</tr>
  			<tr>
  				<td>家庭地址</td><td colspan="2"></td>
  				<td>家庭联系方式</td><td colspan="2"><input type=text size="10" name="telephon1"></td>
  			</tr>
  			<tr>
  				<td>去向地址</td><td colspan="2"><s:textfield name="le1vo.leaveAddress"></s:textfield></td>
  				<td>本人联系方式</td><td colspan="2"><input type=text size="10" name="telephon2"></td>
  			</tr>
  			<tr>
  				<td>请假原因</td>
  				<td colspan="5">本人因：<s:textfield name="le1vo.leaveReason"></s:textfield>需请假<span id="days" style="outline: black">3</span>,望予以批准！<br>
  									请假时间：<sd:datetimepicker name="le1vo.leaveTime"></sd:datetimepicker>
  									</td>
  			</tr>
  			<tr>
  				<td>老&nbsp;师<br>意&nbsp;见</td><td colspan="6">
  				
  			签字：<br>
  			时间：年 &nbsp;月 &nbsp;日<sd:datetimepicker name="le1vo.leaveTeachertime"></sd:datetimepicker>
  				</td>
  				<td></td><td></td>
  			</tr>
  			<tr>
  				<td>学&nbsp;院<br>意&nbsp;见</td><td colspan="6">
  				
  			签字：<br>
  			时间：年 &nbsp;月 &nbsp;日<sd:datetimepicker name=""></sd:datetimepicker>
  				</td>
  				<td></td><td></td>
  			</tr> 
  				<tr>
  				<td>学生处院<br>意&nbsp;见</td><td colspan="6">
  				
  			签字：<br>
  			时间：年 &nbsp;月 &nbsp;日<sd:datetimepicker name=""></sd:datetimepicker>
  				</td>
  				<td></td><td></td>
  			</tr> 
  				<tr>
  				<td>主管学生工作校领导<br>意&nbsp;见</td><td colspan="6">
  				
  			签字：<br>
  			时间：年 &nbsp;月 &nbsp;日<sd:datetimepicker name=""></sd:datetimepicker>
  				</td>
  				<td></td><td></td>
  			</tr> 
  				<tr>
  				<td>学&nbsp;院<br>意&nbsp;见</td><td colspan="2">
  				
  			个人签名：<br>
  			时间：年 &nbsp;月 &nbsp;日<sd:datetimepicker name=""></sd:datetimepicker>
  				</td>
  				<td>销假经办人</td><td></td>
  			</tr> 	 		
  		</tbody> 	
  	</table>
  	<s:submit value="提交"></s:submit><s:reset value="重置"></s:reset>	
   </s:form>
  </body>
</html>
