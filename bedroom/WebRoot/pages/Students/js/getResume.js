//增加一行的按钮的操作	
function add(objThis){
		var id =$(objThis).parent().parent().attr("id");
		if(id=="row"){
			var val =$("input[name='resume.resumeEndtime']").val();
			var bef = val.substring(0,4); //得到年
			var after = val.substring(4,7); //得到-月份
	
			var num = $("#second tr").filter(".CaseRow").size();
			var addO =$("#rowHidden").clone();
			addO.attr("id","row"+(num));
			$(addO).insertBefore($("#lastLine"));
			addO.show();
			
			var beginTime=$("form table input[id='beginTime']")
			beginTime.val(parseInt(bef)+"-09");
			beginTime.attr("id","beginTime"+1);
			var endTime = $("form table input[id='endTime']");
			endTime.val((parseInt(bef)+3)+after);
			endTime.attr("id","endTime"+1);
		}else if(id=="row1"){
			var val = $("#endTime1").val(); 
			var bef = val.substring(0,4);
			var after = val.substring(4,7);
			
			var num = $("#second tr").filter(".CaseRow").size();
			var addO =$("#rowHidden").clone();
			addO.attr("id","row"+(num));
			$(addO).insertBefore($("#lastLine"));
			addO.show();
			
			var beginTime=$("form table input[id='beginTime']");
			beginTime.val(parseInt(bef)+"-09");
			beginTime.attr("id","beginTime"+2);
			var endTime = $("form table input[id='endTime']");
			endTime.val((parseInt(bef)+3)+after);
			endTime.attr("id","endTime"+2);
		}else if(id=="row2"){
			var val = $("#endTime2").val(); 
			var bef = val.substring(0,4);
			var after = val.substring(4,7);
			
			var num = $("#second tr").filter(".CaseRow").size();
			var addO =$("#rowHidden").clone();
			addO.attr("id","row"+(num));
			$(addO).insertBefore($("#lastLine"));
			addO.show();
			
			var beginTime=$("form table input[id='beginTime']");
			beginTime.val(parseInt(bef)+"-09");
			beginTime.attr("id","beginTime"+3);
			var endTime = $("form table input[id='endTime']");
			endTime.val((parseInt(bef)+3)+after);
			endTime.attr("id","endTime"+3);
		}else if(id=="row3"){
			var val = $("#endTime3").val(); 
			var bef = val.substring(0,4);
			var after = val.substring(4,7);
			
			var num = $("#second tr").filter(".CaseRow").size();
			var addO =$("#rowHidden").clone();
			addO.attr("id","row"+(num));
			$(addO).insertBefore($("#lastLine"));
			addO.show();
			
			var beginTime=$("form table input[id='beginTime']");
			beginTime.val(parseInt(bef)+"-09");
			beginTime.attr("id","beginTime"+4);
			var endTime = $("form table input[id='endTime']");
			endTime.val((parseInt(bef)+3)+after);
			endTime.attr("id","endTime"+4);
		}else if(id=="row4"){
			alert("不能再添加了!!");
		}
	}

//减少一行的按钮的操作
	function del(obj) {
		var id=$(obj).parent().parent().attr("id");
		var num = $("#second tr").filter(".CaseRow").size();
		if(num<2){
			alert("不能删除");
			return false;
		}
		$("#"+id).remove();
	}
	
	
$(document).ready(function(){
	 var options = {
		url:'addStudent!addResume.action',
	    type:'POST',
		success: result
	 };
		  
    $("#myForm2").ajaxForm(options);
 });
	   function result(){
		   alert("已经保存!!");
	   }
	
	
	