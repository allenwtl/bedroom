<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>

<script type="text/javascript" src="../jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="../jquery.form.js"></script>
<script type="text/javascript" src="js/modifyPassword.js"></script>
<title></title>
	<style type="text/css">
		table{
			text-align: center;
		}
		b{
			color:red;
		}
		input{
			width: 225px; height: 30px;font-size: 18px;line-height: 30px;
		}
	</style>

</head>
<body>
<form id="myForm">
		<table align="center">
			<tr>
				<td width="140px"><b>*</b>旧密码</td>
				<td width="100px"><input type="password"  id="oldPass" size="20" onblur="checkOld(this)"/></td>
				<td id="zero" width="200px">&nbsp;</td>
			</tr>
			<tr>
				<td width="140px"><b>*</b>新密码</td>
				<td width="100px"><input type="password"  id="newPass" size="20" onblur="checkPa(this)"/></td>
				<td id="fir" width="200px">密码长度在8—15位</td>
			</tr>
			<tr>
				<td><b>*</b>确认新密码</td>
				<td><input name="passw" type="password" id="newPassword"  size="20" onblur="checkPass()"/></td>
				<td id="second">&nbsp;</td>
			</tr>		
			<tr>
				<td><b>*</b>验证码</td>
				<td><input id="idcode" type="text" onkeyup="check()" size="19"/></td>
				<td id="third">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">看不清?点击图片<img id="mm" onclick="go()"  src="idCode!getIdCode.action"   style="cursor:pointer;"  /></td>
			</tr>
			<tr><td colspan="3"><input id="btn" disabled="disabled"  type="submit" value="提交" size="5px"/></td></tr>				
		</table>
		
	</form>
</body>

</html>






