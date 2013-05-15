<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<head>

<script type="text/javascript" src="../jquery-1.2.6.pack.js" ></script>

<script type="text/javascript" src="../jquery.form.js" ></script>
<script type="text/javascript" src="js/getHome.js" ></script>
	
<style type="text/css">
	
		body{text-align: center;}
		#myDiv form table tr{text-align: center}
		input{font-size: 18px;height: 30px}
		#myDiv{margin:0 auto}

</style>
</head>

<body>
	<div id="myDiv"  style="width: 1000px;">
		<form id="myForm3" >
			<table  id="second"  border="1">
				<tr><td colspan="6"><font size="6">家庭成员</font></td></tr>
				<tr>
					<td width="80px">称谓</td>
					<td width="120px">姓名</td>
					<td width="150px">政治面貌</td>
					<td width="300px">工作单位</td>
					<td width="120px">联系方式</td>
					<td width="230px">操作</td>
				</tr>
				<tr id="row" class="CaseRow">
					<td width="80px"><input name="homenumberVo.homenumberTitle" type="text" size="6"/></td>
					<td width="120px"><input name="homenumberVo.homenumberName" type="text" size="10"/></td>
					<td width="150px">
						<select  class="politics" name="homenumberVo.homenumberPolitical" >
							<option >----请选择---</option>
						</select>
					</td>
					<td width="300px"><input name="homenumberVo.homenumberUnit" type="text" size="30" /></td>
					<td width="120px" ><input name="homenumberVo.homenumberPhone" type="text" size="11"/></td>
					<td width="230px"><input  type="button" value="添加一行" onclick="add(this)" /><input type="button" value="删除本行" class="imgdel" onclick="del(this)" /></td>
				</tr>
				<tr id="lastLine" style="height: 40px"><td colspan="6">正确填完后,请点击<input type="submit" value="保存" /></td></tr>
			</table>
		</form>	
		
		<table  >
			<tr id="rowHidden" class="CaseRow" style="display: none">
					<td width="80px"><input name="homenumberVo.homenumberTitle" type="text" size="6"/></td>
					<td width="120px"><input name="homenumberVo.homenumberName" type="text" size="10"/></td>
					<td width="150px">
						<select class="politics" name="homenumberVo.homenumberPolitical" >
							<option >---请选择---</option>
						</select>
					</td>
					<td width="300px"><input name="homenumberVo.homenumberUnit" type="text" size="30" /></td>
					<td width="120px" ><input name="homenumberVo.homenumberPhone" type="text" size="11"/></td>
					<td width="230px"><input  type="button" value="添加一行" onclick="add(this)" /><input type="button" value="删除本行" class="imgdel" onclick="del(this)" /></td>
			</tr>
		</table>
	</div>
</body>




