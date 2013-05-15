<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<script type="text/javascript" src="../jquery-1.4.2.min.js"></script>   
	<script type="text/javascript" src="js/Return2Original.js"></script>
	<script type="text/javascript" src="../jquery.form.js"></script> 
    <title>My JSP 'Return2Original.jsp' starting page</title>
    
   <style type="text/css">
   		#myDiv{
   			width:800px;
   			height: 200PX;
   			margin-left: auto;
   			margin-right: auto;
   		}
   		input{
		width: 225px; height: 30px;font-size: 18px;line-height: 30px;
		}
   </style>
    
    
  </head>
  
  <body >
  	  <form id="myForm" >
    		<div id="myDiv" align="center">
    			<div><input name="passw" onkeyup="search(this.value)" /></div>
    			<div id="showMessage" style="display: none;color: red;"></div>
    			<div style="margin-top: 20px"><input id="myIn" disabled="disabled" type="submit" value="恢复原始密码"/></div>
    	    </div>
      </form>
  </body>
</html>
