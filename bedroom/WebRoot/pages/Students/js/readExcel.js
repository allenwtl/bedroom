$(document).ready(function(){
	var options={
			url:'excelAction!insertData.action',
			type:'POST',
			success: result
	};
	$("#myForm").ajaxForm(options);
});

function result(){
	alert("成功已经导入数据库");
}