//添加一行
function add(){
	
	var num = $("#myTable tbody tr").filter(".caseRow").size();
	var rowHidden = $("#hiddenT").clone();
	rowHidden.attr("id","row"+num);
	$(rowHidden).appendTo($("#myTable tbody"));
	rowHidden.show();
}

//删除一行
function del(obj){
	var id  = $(obj).parent().parent().attr("id");
	var num = $("#myTable tbody tr").filter(".caseRow").size();
	if(num<2){
		alert("不能删除!");
		return false;
	}
	$("#"+id).remove();
}

//得到所有的学院
$.get("college.action",function(data){
	data = eval('('+data+')');
	var obj = $(".colleges");
	for(var i=0; i<data.length; i++){
		obj.append("<option value="+data[i].id+">"+data[i].name+"</option>");
	}
});


//得到所有的系的年，专/本类型
$.get("major.action", function(data){
	data = eval('('+data+')');
	var typeObj = $(".types");
	var yearObj = $(".years");
	for(var i=0; i<data.length;i++){
		typeObj.append("<option value="+data[i].type+">"+data[i].type+"</option>");
		yearObj.append("<option value="+data[i].year+">"+data[i].year+"</option>")
	}
});



$(document).ready(function(){
	var options = {
		type:"GET",
		url:"addMajor.action",
		success:function(data){
			alert(data);
		}
	};
	
	$("#myForm").ajaxForm(options);
});









