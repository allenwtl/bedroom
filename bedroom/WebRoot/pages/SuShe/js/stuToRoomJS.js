



/**
 * author:高华锋
 * function:根据学院获得他的专业
 * return:无
 * 参数：无*/	
function getMajorByCollege(){
	var collegeId = $("#strcolleges>option:selected").val();
	//alert(123);
	$("#strclasses>option").remove();
	$.post("getAllMajorsaddRoomAction!.action?collegeId="+collegeId,function(data){
		//首先清空
		var json = eval("("+data+")");
		$("#strmajors>option").remove();
		//然后添加
		if(json!=null){
			for(var i =0 ; i<json.length; i=i+1){
			   $("#strmajors").append("<option  value='"+json[i].majorId+"'>"+json[i].majorName+"</option>"); 
			}
			getClassesByMajor();
		}
	})	
	
	
}

/**
 * author:高华锋
 * function:根据专业得到班级
 * return :无
 * parameter:无*/
function getClassesByMajor(){
			$("#strclasses>option").remove();
			var majors = $("#strmajors").val();
			var nianfen= $("#strnianfen").val();
			if(majors==null)
				majors="0";
			if(nianfen==null)
				nianfen =1;
			$.post("getClassesByMajoraddRoomAction!.action",{'majorId':majors,'nianfen':nianfen},function(data){
				var json2  = eval("("+data+")");
				for(var i = 0 ;i<json2.length;i=i+1){
				$("#strclasses").append("<option value='"+json2[i].class_id+"'>"+json2[i].class_name+"</option>");
				}
			})
			
	}

function getClassesByNianfen(){
	getClassesByMajor();
}

/**
 * author:高华锋
 * function:根据班级得到该班级的学生  还有该班的宿舍  宿舍中人员的信息
 * return:学生宿舍json对象
 * parameter:班级的编号*/
function getStudentsByClass(){
	var strClass = $("#strclasses").val();
	$.post("getStudentsByClassstuToRoomAction!.action?classes="+strClass,function(data){
		if(data=='[]')
			return false;
		else{
			var json = eval("("+data+")");
			for(var i =0 ; i<json.length;i=i+1){
				if(json[i].students_sex==1){
					$("#strnantab").append("<tr align='center' id='strnantab"+i+"'>"+
							"<td>"+json[i].students_number+"</td><td>"+json[i].students_name+"</td></tr>")
					
					
				}
				else{
					$("#strnantab2").append("<tr align='center' id='strnantab2"+i+"'>"+
							"<td>"+json[i].students_number+"</td><td>"+json[i].students_name+"</td></tr>")
				}
				
			}
		}
	})
	
	$.post("getRoomsByClassstuToRoomAction!.action?classes="+strClass,function(data){
		if(data=='[]')
			return false;
		var json = eval("("+data+")");
		for(var i =0;i<json.length;i=i+1){
			if(json[i].students_sex==1){
				$("#strstr2tab").append("<tr><td></td></tr>" +
						"<tr></tr>" +
						"<tr></tr>" +
						"<tr></tr>")
			}
		}
	})
}



$(document).ready(function(){
	
	$.post("getXueYearaddRoomAction!.action",function(data){
		var json = eval("("+data+")");
		$("#strnianfen>option").remove();
		for ( var i = 0; i < json.length; i=i+1) {
			$("#strnianfen").append("<option value="+i+">"+json[i]+"</option>");
		}
	})
})
	
