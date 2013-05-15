	function clearOp(opts){
		var len = opts.options.length;
		for(var i = len -1;i>0;i--){
			opts.options.remove(i);
		}
	}
	
	//获取市级单位
	function demo2(){
		var province  = $("#province").val();
		var request=false;
		//1：创建核心对象
		try {
			request = new XMLHttpRequest();
		} catch (e) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		//2：打开并发送
		request.open("get","${pageContext.request.contextPath}/AdressAction!getCity.action?province="+province,true);
		request.send(null);
		
		//3:接收
		request.onreadystatechange = function (){
			if(request.readyState==4 && request.status ==200){
				var ret2 = request.responseText;
				if(ret2 == ""){
					alert("没有数据");
				}else{
					var jsonArray = eval('('+ret2+')');
					var obj = document.getElementById("city");
					clearOp(obj);
					for(var i=0;i<jsonArray.length;i++){
						var opt = document.createElement("option");
						opt.text= jsonArray[i].name;
						opt.value= jsonArray[i].id;
						obj.options.add(opt);
					}
				}
			}
		}
	}
	
	function demo3(){
		var cityVal  = $("#city").find("option:selected").val();
		//1:创建核心对象
		var request=false;
		try {
			request = new XMLHttpRequest;
		} catch (e) {
			request = new ActiveXObjcec("Microsoft.XMLHTTP");
		}
		
		//2:打开并发送
		request.open("get", "${pageContext.request.contextPath}/AdressAction!getDis.action?city="+cityVal, true);
		request.send(null);
		
		//3:接收
		request.onreadystatechange =function(){
			if(request.readyState==4 && request.status==200){
				var result = request.responseText;
				if(result==""){
					var obj = document.getElementById("xian");
					obj.disabled ="disabled";
					document.getElementById("tian").focus();
				}else{
					var jsonA = eval('('+result+')');
					var obj = document.getElementById("xian");
					obj.disabled =false;
					clearOp(obj);
					for(var i=0;i<jsonA.length;i++){
						var opt = document.createElement("option");
						opt.text =jsonA[i].name;
						opt.value = jsonA[i].id;
						obj.options.add(opt);
					}
				}
			}
		}
		
	}

	function go(){
		var request =false;
		try {
			request = new XMLHttpRequest();
		} catch (e) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		request.open("get","${pageContext.request.contextPath}/AdressAction!getPro.action",true);
		request.send(null);
		
		request.onreadystatechange = function (){
			if(request.readyState==4 && request.status==200){
				var ret = request.responseText;
				if(ret==""){
					alert("出错了");
				}else{
					var jsonAA = eval('('+ret+')');
					var obj = document.getElementById("province");
					for(var i=0;i<jsonAA.length;i++){
						var opt = document.createElement("option");
						opt.text =jsonAA[i].name;
						opt.value = jsonAA[i].id;
						obj.options.add(opt);
					}
				}
			}
		}
	}
	window.onload=go;
	
//得到一个学生的某些信息
	$.ajax({
		type:"Get",
		url:"getStu!getOneStu.action?number=10415400118",
		dataType:"json",
		async:true,
		success:function(data){
			$("#name").val(data.name);
			$("#number").val(data.number);
			if(data.sex==1)
				$("#sex").val("男");
			else $("#sex").val("女");
			$("#className").val(data.className);
			$("#nianzhi").val(data.nianzhi);
			$("#ke").val(data.ke);
		}
		
	});
	
	//得到所有的民族
	$.ajax({
		type:"Get",
		url:"student!getAllNations.action",
		dataType:"json",
		async:true,
		success:function(data){
			var obj = $("#nation")[0];
			for(var i=0;i<data.length;i++){
				var opt = document.createElement("option");
				opt.text  = data[i].name;
				opt.value = data[i].id;
				obj.options.add(opt);
			}
		}
		
	});
	
//得到所有的政治面貌	
	$.ajax({
		type:"Get",
		url:"student!getAllPoliticals.action",
		dataType:"json",
		async:true,
		success:function(data){
			var obj = $("#politics")[0];
			for(var i=0;i<data.length;i++){
				var opt = document.createElement("option");
				opt.text  = data[i].name;
				opt.value = data[i].id;
				obj.options.add(opt);
			}
		}
		
	});
	

   $(document).ready(function(){
	   var options = {
			   url:'addStudent!addStudent.action',
			   type:'POST',
			   success: result
	   };
	  
	  $("#myForm1").ajaxForm(options);
	  
	  
	  //上传照片
	  $("#image").click(function(){
		 $.ajax({
			 type:"POST",
			 url:"imageUpload!upLoad.action",
			 async:true,
			 success:function(data){
			 	alert("照片已保存");
		 	 }
		 });
	   });

	  
   });
   function result(){
	   alert("已经保存!!");
   }

   
  
	