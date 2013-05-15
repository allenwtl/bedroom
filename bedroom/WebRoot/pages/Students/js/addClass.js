//添加学院  
$.get("college.action",function(data){
	data = eval('('+data+')');
	var obj = $("#college");
	for(var i =0; i<data.length; i++){
		obj.append("<option value="+data[i].id+">"+data[i].name+"</option>")
	}
});

function queryMajor(){
	var obj = $("#college option:selected");
	var value = obj.val();
	$.get("queryMajor.action", {id:value}, function(data){
		data = eval('('+data+')');
		var obj = $("#major");
		for(var i =0; i<data.length; i++){
			obj.append("<option value="+data[i].id+">"+data[i].name+"</option>")
		}
	});
}


$.get("queryKezhi.action",function(data){
	data = eval('('+data+')');
	var obj = $("#kezhi");
	for(var i =0; i<data.length; i++){
		obj.append("<option value="+data[i].id+">"+data[i].type+"</option>")
	}
});


function showPre(){
	var obj = $("#showPre");
	if(obj!=null){
		obj.remove();
	}
	var college = $("#college option:selected").text();
	var major   = $("#major option:selected").text();
	var year    = $("#year").val();
	var type    = $("#kezhi option:selected").text();
	var className = $("#className").val(); 
	var amount  = $("#amount").val();
	
	var html = "<table id='showPre' border='1'><tr width='1000px'><td width='100px'>学院</td><td width='200px'>所在系</td><td width='100px'>开班年份</td><td width='100px'>班级属性</td><td width='250px'>班级名称</td></tr>";
	for(var i=1; i<=amount; i++){
		if(i<10){
			html= html+"<tr><td>"+college+"</td><td>"+major+"</td><td>"+year+"</td><td>"+type+"级"+"</td><td>"+className+year.substring(2,4)+'0'+i+"</td></tr>";
		}else{
			html= html+"<tr><td>"+college+"</td><td>"+major+"</td><td>"+year+"</td><td>"+type+"</td><td>"+className+year.substring(2,4)+i+"</td></tr>";
		}
	}
	
	$("form").append(html);
}

$().ready(function(){
	var options={
		url:"addClass.action",
		type:'GET',
		success:function(data){
			if(data==""){
				alert("重新填写,再保存!!");
			}else{
				alert(data);
			}
		}
	};
	$("#myForm").ajaxForm(options);
});













