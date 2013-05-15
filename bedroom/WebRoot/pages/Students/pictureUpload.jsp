<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<head>
	<style type="text/css">
		#myDiv{
			margin-left: auto;
			margin-right: auto;
			width: 300px;
		}	
		p{
			color: red;
		}
	</style>
</head>
<body>

	<div id="myDiv" align="center">
	<s:fielderror></s:fielderror>
		<form action="imageUpload!upLoad.action" method="POST" enctype="multipart/form-data">
			<input name="image" type="file"   /><p>必须是.jpg或者是.jpeg格式</p>
			<input type="submit" value="上传照片"/>
		</form>
	
	
	</div>

</body>








