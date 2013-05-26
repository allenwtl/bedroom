$(function(){
	//给所有的tr高度
	$("table tr").css("height","40px");
	$("table tr").attr("align","center");
	$("table").attr("align","center");
	$("input[type='text']").attr("readonly","true");
	var allInput = $("input[type='text']");
	allInput.attr("title","单击修改");
	
	
	$("#first").bind("click",function(){
		$("form:visible").hide();
		$("#myForm").show();
	});
	
	$("#second").bind("click",function(){
		$("form:visible").hide();
		
		$.get("",{},function(data,status){
			
			
		});
		
		
		
		
		$("#myForm2").show();
	});
	
	$("#myForm").ajaxForm({
		success:function(){
			
		}
	});
	
	$("#myForm").ajaxForm({
		type:"get",
		url:'updateStuInfo!saveNewStuInfo.action',
		success:function(){
			$("input[type='text']").text();
		}
	});
});


//得到个人信息
$.get("modifyStuInfo!getStuInfo.action", function(data){
	$("#name").val(data.student.studentsName);
	$("#namePinYin").val(data.student.studentsPinyin);
	$("#number").val(data.student.studentsNumber);
	$("#nation").val(data.student.studentsNation);
	$("#card").val(data.student.studentsIdcard);
	$("#clazz").val(data.student.classNumber);
	$("#sex").val(data.student.studentsSex);
	$("#birthday").val(data.student.studentsBirthday);
	$("#political").val(data.student.studentsPolitics);
	$("#origin").val(data.student.studentsNativeplace);
	$("#native").val(data.student.studentsNative);
	$("#homeAddress").val(data.student.studentsAddress);
	$("#code").val(data.student.studentsPostcode);
	$("#phone").val(data.student.studentsPhone);
	$("#type").val(data.student.studentsType);
	$("#inSchool").val(data.student.studentsInSchool);
	$("#bedroom").val(data.student.roomLocation);
	$("#qq").val(data.student.studentsQq);
	$("#email").val(data.student.studentsEmail);
	$("#inBedRoom").val(data.student.studentsInRoomTime);
});

function update(obj){
	var $obj = $(obj);
	$obj.removeAttr("readonly");
	id=$obj.attr("id");
	if(id=="nation"){
		//得到所有的民族
		$.ajax({
			type:"Get",
			url:"student!getAllNations.action",
			dataType:"text",
			async:true,
			success:function(data){
				var jsonData = eval('('+data+')');
				$("#nation").remove();
				var select = "<select id='nation' name=''>";
				for(var i=0; i<jsonData.length; i++){
					select = select +"<option value="+jsonData[i].id+">"+jsonData[i].name+"</option>";
				}
				select = select +"</select>";
				$("#showNation").append(select);
			}
		});
	}
	
	if("political"==id){
		//得到所有的政治面貌	
		$.ajax({
			type:"Get",
			url:"student!getAllPoliticals.action",
			dataType:"text",
			async:true,
			success:function(data){
				var jsonData = eval('('+data+')');
				$("#political").remove();
				var select = "<select id='political' name=''>";
				for(var i=0; i<jsonData.length; i++){
					select = select +"<option value="+jsonData[i].id+">"+jsonData[i].name+"</option>";
				}
				select = select +"</select>";
				$("#showPolitical").append(select);
			}
			
		});
	}
	
	
	
}



