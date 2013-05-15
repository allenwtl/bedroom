function  search(number){
	if(number==""){
		return;
	}
	if(isNaN(number)){
		alert("只能是数字");
	}
	
	if(number.length==11){
		//1:创建核心对象
		var  xmlHttpRequest = false;
		try {
			xmlHttpRequest = new XMLHttpRequest();
		} catch (e) {
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		//2.打开并发送
		xmlHttpRequest.open("GET", "${pageContext.request.contextPath}/student!checkStu.action?number="+number, true);
		xmlHttpRequest.send(null);
		
		//3:接收
		xmlHttpRequest.onreadystatechange  = function(){
			if(xmlHttpRequest.readyState ==4 && xmlHttpRequest.status==200){
				var ret = xmlHttpRequest.responseText;
				if(ret==""){
					alert("查询出错!请重新输入!")
				}else if(ret=="该学生不存在"){
					var obj = $("#showMessage");
					obj.show();
					obj.text(ret);
					$("#myIn").attr("disabled",true);
				}else{
					$("#showMessage").hide();
					ret = eval('('+ret+')');
					if(ret.sex==1) sex = "男";
					else sex = "女";
					var html="<table align='center' width='200px'><tr><td>姓名"+"</td><td>"+ret.name+"</td></tr>"
					+"<tr><td>性别</td><td>"+sex+"</td></tr>"
					+"<tr><td>班级</td><td>"+ret.clazz+"</td></tr></table>";
					$("#showMessage table:eq(0)").remove();
					var obj = $("#showMessage");
					obj.text("");
					obj.append(html);
					obj.show();
					$("#myIn").attr("disabled",false);
				}
			}
			
		}
	}

}


$(document).ready(function(){
	var options = {
		type:"GET",
		url:"student!modifyPass.action",
		success:function(){
		$("#myIn").attr("disabled",true);
			alert("已还原成最初密码");
		}
	};
	$("#myForm").ajaxForm(options);
});


