//添加一行
function add(objInput){
	var obj = $(objInput);
	var num = $("#second tr").filter(".CaseRow").size();
	var rowHidden = $("#rowHidden").clone();
	rowHidden.attr("id","row"+num);
	$(rowHidden).insertBefore($("#lastLine"));
	rowHidden.show();
}

//删除一行
function del(obj) {
	var id=$(obj).parent().parent().attr("id");
	var num = $("#second tr").filter(".CaseRow").size();
	if(num<2){
		alert("不能删除");
		return false;
	}
	$("#"+id).remove();
}


$(document).ready(function (){
	var options ={
		type:'POST',
		url:'addStudent!addRelation.action',
		success: result
	};
	$("#myForm3").ajaxForm(options);
});


function result(){
	alert("已经保存");
}

//得到所有的政治面貌	
$.ajax({
	type:"Get",
	url:"student!getAllPoliticals.action",
	dataType:"json",
	async:true,
	success:function(data){
		var obj = $(".politics");
		for(var i=0;i<data.length;i++){
			obj.append("<option value="+data[i].id+">"+data[i].name+"</option>");
		}
	}
	
});



