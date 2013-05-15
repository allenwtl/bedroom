  function go()
  {
    document.getElementById("mm").src="idCode!getIdCode.action?x="+Math.random();  
  }
  
  function check(){
	var value= $("#idcode").val();
	if(4==value.length)
	{
		var request = false;
		try {
			request = new XMLHttpRequest();
		} catch (e) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		  
		request.open("get", "${pageContext.request.contextPath}/idCode!checkCode.action?val="+value, true);
		request.send(null);
		
		request.onreadystatechange = function(){
			if(request.readyState==4 && request.status==200){
				var ret = request.responseText;
				$("#third").html(ret);
				$("#btn").attr("disabled",false);
			}
		}
	}
  }
  
  function checkPa(object){
	  var len = $(object).val().length;
	  if(len==0){return false;}
	  if(len<7 || len>13){
		  alert("密码长度不合适!");
		 document.getElementById("newPass").focus();
	  }
  }
  
  function checkPass(){
	  var newValue = $("#newPassword").val();
	  var value = $("#newPass").val();
	  if(value==newValue){
		  
		  $("#second").html("OK");
	  }else{
		  $("#btn").attr("disabled",true);
		  $("#second").html("密码不一致");
	  }
  }
  
  $(document).ready(function(){
	  var options={
		   type:'GET',
		   url:'student!modifyPass.action',
		   success:function(){
		  		alert("修改成功");
	  	   }
	  };
	  $("#myForm").ajaxForm(options);
  });
  
  
  function checkOld(object){
	  var oldPass = $(object).val();
	  $.get(
		  "student!checkOldPass",
		  {"oldPass":oldPass},
		  function(data){
			  $("#zero").text(data);
		  }
	  );
	  
  }
  
  
  
