
document.write("<script type='text/javascript' language='javascript' src='js/stringCheckJS.js'></script>")
/**
 * author:高华锋
 * fuction: ajax表单提交
 * parameter
 * return */
$(document).ready(function(){

	var opptions={
			url:'createRoomcreateRoomAction!.action',
			type:'post',
			beforeSubmit:beforeS,
			error:pri,
			success:chenggong,
			clearForm:'true'
	};
	
	$("#createRoomForm").submit(function(){
		$(this).ajaxSubmit(opptions);
		return false;
	})
})

/**
 * author:高华锋
 * function:表单提交之前 各种验证
 * parameter
 * return */
function beforeS(){
	var dongs = $("#cdong").val();
	var reg = /^[0-9]+$/;
	var sCheck = new stringCheck();
	if(sCheck.isShuZi(dongs,'栋数输入有误!!!!!!!!!!')==false)
	{
		$("#cdong").val("");
		return false;
	}
	
	alert('确定要提交吗??????')
}

/**
 * author:高华锋
 * function:表单提交出错
 * parameter:
 * return:*/
function pri(){
	alert('出错了  快去联系管理员')
}

/**
 * author:高华锋
 * funciont:表单提交成功后 处理返回的数据
 * parameter:
 * return */
function chenggong(data){
	alert("OK 成功了")
	$("#crselectRooms").html("");
	var json = eval("("+data+")");
	$("#crshownewtab").append("<tr align='center'>" +
			"<td>第"+json[0].dongs+"栋</td>" +
			"<td>"+json[0].cengs+"</td>" +
			"<td>"+json[0].di1+"</td>" +
			"<td>"+json[0].di2+"</td>" +
			"<td>"+json[0].di3+"</td>" +
			"<td>"+json[0].di4+"</td>" +
			"<td>"+json[0].di5+"</td>" +
			"<td>"+json[0].di6+"</td>" +
			"<td>"+json[0].di7+"</td>" +
			"<td>"+json[0].di8+"</td>" +
			"<td>删除</td></tr>");
}
/**
 * author:高华锋
 * function:判断输入的数字是否是数值   因为楼层数是数值
 * return :
 * pamameter*/


/**
 * author：高华锋
 * function：根据输入的层数创建几个层对象  拼将每层的寝室数目输入其中
 * return:
 * parameter*/
function createCeng(){
	var ceng = $("#cceng").val();
	$("#crselectRooms").html("");
	for(var i =0;i<ceng;i=i+1){
		$("#crselectRooms").append("第"+(i+1)+"层<input id='cceng"+i+"' name='bbbb' class='ccengy' onblur='javascript:checkNumber()'  type='text'></input>室<br/>");
		
	}
}

/**
 * author:高华锋
 * function:输入的寝室是否是数字
 * parameter:
 * return:
 * */
function checkNumber(){
	
	var reg = /^[0-9]*$/;
	var ceng = $("#cceng").val();
	for(var i =0;i<ceng;i=i+1){
		if(!reg.test($("#cceng"+i).val()))
		{
			alert("第"+(i+1)+"的寝室数输入不准确")
			$("#cceng"+i).val("");
		}
	}
}