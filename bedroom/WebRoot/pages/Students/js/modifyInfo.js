$(function(){
	//给所有的tr高度
	$("table tr").css("height","40px");
	$("table tr").attr("align","center");
	$("table").attr("align","center");
	
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
	
	$("#myForm2").ajaxForm({
		type:"get",
		
		success:function(){
			alert("this is a myform");
		}
	});
});