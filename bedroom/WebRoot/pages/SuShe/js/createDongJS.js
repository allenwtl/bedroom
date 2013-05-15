
var hang = 1; //表示当前的行数
var mosex ="男";
var mops = 4;
var mofunc="学";
var gai = 0;
var newCeng = 0;

$(document).ready(function(){
	
	$(".dongShu").eq(0).find("input").val("");
	
	$(".baoGaoTabDD").html("<input name='noaddress' type='radio'  value='五食堂区'/>五食堂区" +
			"<input type='radio' name='noaddress'  value='二食堂区'/>二食堂区" +
			"<input type='radio' name='noaddress'  value='校门口区'/>校门口区");
	$(".baoGaoTabSex").html("<input name='nosex' type='radio' value='男'/>男" +
			"<input name='nosex' type='radio'  value='女'/>女");
	$(".baoGaoTabFun").html("<input name='nofunc' type='radio'  value='学'/>学" +
			"<input name='nofunc' type='radio'  value='管'/>管" +
			"<input name='nofunc' type='radio'  value='其他'/>其他");
	$(".baoGaoTabPs").html("<input type='text' name='nops' />")
	
	$(".anNiuCJ").eq(0).hide();
	$(".anNiuGJ").eq(0).hide();
	
	var d = new Date();
	$(".qianShuTab").eq(0).find("tr").eq(0).find("td").eq(1).html(d.getFullYear()+"-"+d.getMonth()+"-"+d.getDate());
	$("#hForm").hide();
	var options = {
			url:'createDongcreateDongAction!.action',
			type:'post',
			beforeSubmit: jiance,
			success: chenggong,
			error:pri
	};
	$("#hiddenForm").submit(function(){
		$("#hiddenForm").ajaxSubmit(options);
		return false;
	})
	$(".baoGaoTabSex>input").live("change",function(){
		mosex = $(this).val();
		$(".roomsex").html(mosex);
		$("#hang1").eq(0).find(".hangHidenOptionsSex").eq(0).val(mosex);
	})
	$(".baoGaoTabFun>input").live("change",function(){
		mofunc = $(this).val();
		$(".roomfunc").html(mofunc);
		$("#hang1").eq(0).find(".hangHiddenOptionsFunc").eq(0).val(mofunc);
	})
	$(".baoGaoTabPs>input").live("change",function(){
		mops = $(this).val();
		$(".roomps").html(mops);
		$("#hang1").eq(0).find(".hangHidenOptionsPs").eq(0).val(mops);
	})

	
	
	$(".baoGaoTab").eq(0).find("tr").each(function(o,i){
		$(i).find("td").eq(0).attr("width","160px;");
	})
})

 $.ajaxSetup({  
    async : false  
});

/**
 * author:高华锋
 * function：创建宿舍*/
function createRoomOfCeng(i){
	var inp = i;
	var dong   = $(".dongShu").eq(0).find("input").val();
	if(dong=="")
	{
		alert("亲输入有效的栋");
		$(inp).val("");
		return false;
		
	}

	var number = $(i).val();
	var reg = /^[0-9]+$/;
	var r   = number.match(reg);
	if(r==null){
		alert("请输入有效的寝室数!!!");
		return false;
	}
	var hangNum = $(i).parent().parent().parent().find("div").eq(0).find("span").html();
	
	if($("#hangTab"+hangNum).size()==0)
		$(i).parent().parent().after("<table id='hangTab"+hangNum+"'></table>")
	
	$.post("getRoomOfCengcreateDongAction!.action",{"hang":hangNum,"dong":dong},function(data,status){
		
		var dong = $(".dongShu").eq(0).find("input").val();
		var json = eval("("+data+")");
		if(json.length==0 || gai==1){
			if(gai==1 && newCeng==0){
				if(!confirm("这个操作会把改行所有数据都还原"))
					return false;
			}
			//控制是否是新的层的作用区分   有数据的   和  无数据的  正在改建中的
			newCeng = 0;
			$("#hangTab"+hangNum).html("");
			var rn = "0";
			for(var i =0; i < number;i=i+1){
				if((i)%10==0 || i==0){
					$("#hangTab"+hangNum).append("<tr id='hangTab"+hangNum+"-"+i+"' align='center'></tr>");
					h = i;
				}else
				if((i+1)==10)
					rn="";
				$("#hangTab"+hangNum+"-"+h).append("<td onlclick='javascript:changeTdOptions(this)' width='46px'><span >" +
						"	<span>"+dong+"-"+hangNum+rn+(i+1)+"</span>" +
						"	<span>" +
						"		<div class='roomsex'>"+$("#hang"+hangNum).eq(0).find(".hangHidenOptionsSex").eq(0).val()+"</div>" +
						"		<div class='roomps'>"+$("#hang"+hangNum).eq(0).find(".hangHidenOptionsPs").eq(0).val()+"</div>" +
						"		<div class='roomfunc'>"+$("#hang"+hangNum).eq(0).find(".hangHiddenOptionsFunc").eq(0).val()+"</div>" +
						"	</span>" +
						"</span></td>");
			}
		}else{
			$("#hangTab"+hangNum).html("");
			for(var i =0; i < json.length;i=i+1){
				if((i)%10==0 || i==0){
					$("#hangTab"+hangNum).append("<tr id='hangTab"+hangNum+"-"+i+"' align='center'></tr>");
					h = i;
				}
				$("#hangTab"+hangNum+"-"+h).append("<td onclick='javascript:changeTdOptions(this)' width='46px'><span >" +
						"	<span>"+json[i].room_number+"</span>" +
						"	<span>" +
						"		<div class='roomsex'>"+(json[i].room_sex==1?'男':'女')+"</div>" +
						"		<div class='roomps'>"+json[i].room_ps+"</div>" +
						"		<div class='roomfunc'>"+(json[i].room_fun==1?'学':json[i].room_fun==2?'管':'其他')+"</div>" +
						"	</span>" +
						"</span></td>");
			}
		}
		
		//
		
		
		
	})

	
}

/**
 * author:高华锋
 * function：创建层*/
function createCeng(){
	newCeng = 1;
	$('#hang'+hang).after("<div class='hangClass' id='hang"+(hang+1)+"'>" +
						"<input class='hangHidenOptionsSex' type='hidden' value='"+mosex+"'/>" +
						"<input class='hangHidenOptionsPs' type='hidden' value='"+mops+"'/>" +
						"<input class='hangHiddenOptionsFunc' type='hidden' value='"+mofunc+"'/>"+
						"<div class='baoGaohang1'>第<span></span>层建设计划书" +
						"<span class='setHangOptions' style='float: right;' onclick='javascript:changeCengOptions(this)'>设置</span></div>"+
						"<div class='baoGaohang2'>该层共建设<span class='dongShu'><input type='text' name='room' onchange='javascript:createRoomOfCeng(this)' size='3'/></span>个宿舍"+
						"<span>"+
									"<input class='addRoom' type='button' value='添加一个宿舍' onclick='javascript:addRoom(0,this)'/>"+
									"<input class='delRoom' type='button' value='删除最后的宿舍' onclick='javascript:addRoom(1,this)'/>"+
								"</span>"+
						"</div></div>");
	$("#hang"+(hang+1)).find("div").eq(0).find("span").eq(0).html(hang+1);
	hang =hang +1;
}


/**
 * author:高华锋
 * function:显示选项菜单
 * */
function changeCengOptions(i){
	
	var ceng = $(i);
	var n = $(i).parent().find("span").eq(0).html();
		if($("#changOptions"+n).size()==0){
		var offset = ceng.offset();
		var wid = ceng.width();
		var hei = ceng.height();
		var changOptions = document.createElement("div");
		changOptions.id = "changOptions"+n;
		with (changOptions.style){
			position="absolute";
			left=offset.left+wid+"px";
			top =offset.top+"px";
			width="200px";
			height="100px";
			filter ="alpha(opacity=80)";
			opacity=0.8;
			backgroundColor="red";
		}
		document.body.appendChild(changOptions);
		var sex = $("#hang"+n).eq(0).find(".hangHidenOptionsSex").eq(0).val();
		var ps  = $("#hang"+n).eq(0).find(".hangHidenOptionsPs").eq(0).val();
		var func= $("#hang"+n).eq(0).find(".hangHiddenOptionsFunc").eq(0).val(); 
		$("#changOptions"+n).append("<div>性别：<select onchange='javascript:changeHangOptionsSex("+n+")' class='hangOptionsSex'>" +
				"<option value='男'>男</option><option value='女'>女</option></select></div>" +
				"<div>人数：<input class='hangOptionsPs' value='"+ps+"' onchange='javascript:changeHangOptionsPs("+n+")' size=3 type='text'/></div>" +
				"<div>功能：<select class='hangOptionsFunc' onchange='javascript:changeHangOptionsFunc("+n+")'>" +
				"<option value='学'>学</option>" +
				"<option value='管'>管</option>" +
				"<option value='其他'>其他</option></select></div>")
				$("#changOptions"+n).find(".hangOptionsSex").eq(0).val(sex);
				$("#changOptions"+n).find(".hangOptionsFunc").eq(0).val(func);
		}
		
		else{
			
			$("#changOptions"+n).remove();
		}

}

/**
 * author:高华锋
 * function:根据栋数得到栋的详情
 * parameter:栋数
 * return :栋的详情*/
//"[{"room_number":"28-401","room_ps":4,"room_ceng":4,"room_sex":true,"qinshi_id":28,"qinshi_ceng":4,"qinshi_address":"0023","room_fun":1,"room_id":67,"qinshi_cengrooms":null}
function getInforOfDong(i){
	gai = 0;
	hang = 1;
	var hangs = $(".hangClass");
	$(hangs).remove();
	$("#hang1>table").remove();
	$("#hang1").find(".dongShu").eq(0).find("input").val("");
	
	var dong = $(i).val();
	$.post("getInforOfDongcreateDongAction!.action",{"dong":dong},function(data){
		var json = eval("("+data+")");
		var crooms = json[0].qinshi_cengrooms;	
		if(crooms!=null)
			var cengrooms = crooms.split(",");

		if(json[0].kong=="null"){
			alert("该楼层的数据还不存在！！请添加！！")
			$(".anNiuGJ").eq(0).hide();
			$(".anNiuCJ").eq(0).show();
			$(".addRoom").show();
			$(".delRoom").show();
			$(".baoGaoTabTR").show();
			$(".addCeng").show(1000)
			$(".setHangOptions").show(1000);
			$(".hangClass").remove();
			$("#hangTab1").remove();
			$("#hang1").find(".douShu").eq(0).find("input").val();
			$(".baoGaoTabDD").html("<input name='noaddress' type='radio'  value='五食堂区'/>五食堂区" +
					"<input type='radio' name='noaddress'  value='二食堂区'/>二食堂区" +
					"<input type='radio' name='noaddress'  value='校门口区'/>校门口区");
			$(".dongShu").find("input").attr("readonly","");
			$("#deleteCeng").show();
		}else{
			
			$(".anNiuCJ").eq(0).hide();
			$(".anNiuGJ").eq(0).show();
			$(".baoGaoTabDD").eq(0).html(json[0].qinshi_address);
			$(".baoGaoTabTR").hide();
			$(".addCeng").hide();
			$("#deleteCeng").hide();
			for(var i = 0 ; i < json[0].qinshi_ceng-1 ; i = i +1 ){
				createCeng();
				//给当层 设置属性  除了第一层意外
				$("#hang"+(i+2)).find(".dongShu").eq(0).find("input").val(cengrooms[(i+1)]);
				$("#hang"+(i+2)).find(".dongShu").eq(0).find("input").attr("readonly","readonly");
				var m = $("#hang"+(i+2)).find(".baoGaohang2").eq(0).find("span>input");
				createRoomOfCeng(m);
			}
			//给的第一层设置属性  还有创建寝室
			$("#hang1").find(".dongShu").eq(0).find("input").val(cengrooms[0]);
			$("#hang1").find(".dongShu").eq(0).find("input").attr("readonly","readonly");
			var m  = $("#hang1").find(".baoGaohang2").eq(0).find("span>input");
			createRoomOfCeng(m);
			//隐藏设置选项
			$(".setHangOptions").hide();
			$(".addRoom").hide();
			$(".delRoom").hide();
		}
		
	})
}

function changeHangOptionsSex(c){
	var i = $("#hang"+c).find("#hangTab"+c);
	var sex = $("#changOptions"+c).find(".hangOptionsSex").eq(0).val();
	if(i.size()==0){
		$("#hang"+c).find(".hangHidenOptionsSex").eq(0).val(sex);
	}else{
		$("#hang"+c).find(".hangHidenOptionsSex").eq(0).val(sex);
		$("#hang"+c).find(".roomsex").html(sex);
	}
}

function changeHangOptionsPs(c){
	var i = $("#hang"+c).find("#hangTab"+c);
	var ps = $("#changOptions"+c).find(".hangOptionsPs").eq(0).val();
	if(i.size()==0){
		$("#hang"+c).find(".hangHidenOptionsPs").eq(0).val(ps);
	}else{
		$("#hang"+c).find(".hangHidenOptionsPs").eq(0).val(ps);
		$("#hang"+c).find(".roomps").html(ps);
	}
	
}

function changeHangOptionsFunc(c){
	
	var i = $("#hang"+c).find("#hangTab"+c);
	var func = $("#changOptions"+c).find(".hangOptionsFunc").eq(0).val();
	if(i.size()==0){
		$("#hang"+c).find(".hangHiddenOptionsFunc").eq(0).val(func);
	}else{
		$("#hang"+c).find(".hangHiddenOptionsFunc").eq(0).val(func);
		$("#hang"+c).find(".roomfunc").html(func);
	}
}

function changeTdOptions(i){
	var t = $(i);
	var offset = $(i).offset();
	var wid = $(i).width();
	$("#changingTd").remove();
	if($("#changTdOptions").size()!=0)
		$("#changTdOptions").remove();
	else{
	$(i).append("<input id='changingTd' type='hidden' value='changingTd'/>")
	var changTdOptions = document.createElement("div");
	changTdOptions.id = "changTdOptions";
	with (changTdOptions.style){
		position="absolute";
		left=offset.left+wid+"px";
		top =offset.top+"px";
		width="200px";
		height="100px";
		filter ="alpha(opacity=80)";
		opacity=0.8;
		backgroundColor="red";
	}
	document.body.appendChild(changTdOptions);
	$("#changTdOptions").append("<div>性别：<select class='TdSex' onchange='javascript:changeTdSex(this)'>" +
				"<option value='男'>男</option><option value='女'>女</option></select></div>" +
				"<div>人数：<input onchange='javascript:changeTdPs(this)' class='TdPs'size=3 type='text'/></div>" +
				"<div>功能：<select onchange='javascript:changeTdFunc(this)' class='TdFunc'>" +
				"<option value='学'>学</option>" +
				"<option value='管'>管</option>" +
				"<option value='其他'>其他</option></select></div>")
				$(".TdSex").eq(0).val($(i).find(".roomsex").eq(0).html());
				$(".TdPs").eq(0).val($(i).find(".roomps").eq(0).html());
				$(".TdFunc").eq(0).val($(i).find(".roomfunc").eq(0).html());
	}
	
}

function changeTdSex(i){
	var m = $(i).val();
	$("#changingTd").parent().find(".roomsex").eq(0).html(m);
	
}

function changeTdPs(i){
	var m = $(i).val();
	$("#changingTd").parent().find(".roomps").eq(0).html(m);
}

function changeTdFunc(i){
	var m = $(i).val();
	$("#changingTd").parent().find(".roomfunc").eq(0).html(m);
}

/**
 * author:高华峰
 * function:删除最后一层
 * 
 */
function deleteCeng(){
	var hangs = $(".hangClass");
	if($(hangs).size()==0){
		alert("改行作为保留")
		$("#hang1>table").remove();
		$("#hang1").find(".dongShu").eq(0).find("input").val("");
	}
	else{
		alert("确定要删除这行")
		$(hangs).eq($(hangs).size()-1).remove();
	}
	
}

/**
 * author:高华锋
 * function：点击按钮将栋的信息添加到影藏的form中  然后触发提交事件*/
function chuangjian(){
	gai =0;
	$("#hiddenForm>input").remove();
	var hang1Rooms = $("#hang1").find(".dongShu").eq(0).find("input").val();
	var hang1tds   = $("#hang1").find("#hangTab1>tbody>tr>td>span");
	var hangRooms  = $(".hangClass").find(".dongShu").find("input");
	var hangtds    = $(".hangClass").find("table>tbody>tr>td>span");
	var f	       = $("#hiddenForm");
	//"<input type='hidden' name='' value=''/>"
	//+$(hang1tds).find("span").eq(0).html()+
	//+$(hang1tds).find("span").eq(1).find("div").eq(0).html()+
	f.append("<input type='hidden' name='address' value='"+$(".baoGaoTabDD").eq(0).find(":checked").val()+"'/>")
		f.append("<input type='hidden' name='room' value='"+hang1Rooms+"'/>")
		for(var i = 0 ; i < hang1tds.length ; i = i +1){
			f.append("<input type='hidden' name='roomNum' value='"+$(hang1tds).eq(i).find("span").eq(0).html()+"'/>")		
			f.append("<input type='hidden' name='roomSex' value='"+$(hang1tds).eq(i).find("span").eq(1).find(".roomsex").eq(0).html()+"'/>")
			f.append("<input type='hidden' name='roomPs' value='"+$(hang1tds).eq(i).find("span").eq(1).find(".roomps").eq(0).html()+"'/>")
			f.append("<input type='hidden' name='roomFunc' value='"+$(hang1tds).eq(i).find("span").eq(1).find(".roomfunc").eq(0).html()+"'/>")
		}
	for(var i =0 ; i < hangRooms.length ; i = i +1 ){
		f.append("<input type='hidden' name='room' value='"+$(hangRooms).eq(i).val()+"'/>")
	} 
	
	for(var i = 0 ; i < hangtds.length ; i = i +1){
		f.append("<input type='hidden' name='roomNum' value='"+$(hangtds).eq(i).find("span").eq(0).html()+"'/>")
		f.append("<input type='hidden' name='roomSex' value='"+$(hangtds).eq(i).find("span").eq(1).find(".roomsex").eq(0).html()+"'/>")
		f.append("<input type='hidden' name='roomPs' value='"+$(hangtds).eq(i).find("span").eq(1).find(".roomps").eq(0).html()+"'/>")
		f.append("<input type='hidden' name='roomFunc' value='"+$(hangtds).eq(i).find("span").eq(1).find(".roomfunc").eq(0).html()+"'/>")
	}
	$("#hiddenForm").submit();
	
	
}

function gaijian(){
	gai = 1;
	$(".addRoom").show();
	$(".delRoom").show();
	$(".anNiuGJ").eq(0).hide();
	$(".anNiuCJ").eq(0).show();
	$(".setHangOptions").show();
	$(".addCeng").eq(0).show();
	$("#deleteCeng").show();
	$(".baoGaoTabDD").eq(0).show();
	//$(".baoGaoTabDD").val(); 这里要设置他的值但我的值不靠谱
	$(".baoGaoTabTR").show();
	$(".baoGaoTabDD").html("<input name='noaddress' type='radio'  value='五食堂区'/>五食堂区" +
			"<input type='radio' name='noaddress'  value='二食堂区'/>二食堂区" +
			"<input type='radio' name='noaddress'  value='校门口区'/>校门口区");
	
	$(".dongShu").find("input").attr("readonly","");
	
}

function jiance(){}

function chenggong(){}

function pri(){}

/**
 * author:高呼风
 * function:给改行添加一个宿舍*/
function addRoom(status,i){
	var dong = $(".dongShu").eq(0).find("input");
	//得到父亲对象
	var hang = $(i).parent().parent();
	//得到行号 
	var hangNum = $(hang).parent().find("div").eq(0).find("span").eq(0);
	//得到寝室数目
	var roomNum = $(hang).find("span").eq(0).find("input");
	//得到表格
	var tab = $("#hangTab"+hangNum.html());
	//判断  是那种
	if(status==0){
		//增加一个宿舍
		 //不存在 直接添加一个表格 然后添加一个宿舍   存在 添加一个宿舍
		if(tab.size()==0)
		{
			$(hang).after("<table id='hangTab"+hangNum.html()+"'></table>");
			$("#hangTab"+hangNum.html()).append("<tr id='hangTab"+hangNum.html()+"-"+0+"' align='center'></tr>");
			
		}else{
			//得到以10 分割的行对象
			var tabHang = $(tab).find("tbody>tr");
			//得到td的所有对象
			var tabTds  = $(tab).find("td");
			if(tabTds.size()%10==0)
				$("#hangTab"+hangNum.html()).append("<tr id='hangTab"+hangNum.html()+"-"+(tabHang.size())+"0' align='center'></tr>");
		}
		tabHang = $(tab).find("tbody>tr");
		$(tabHang).eq(tabHang.size()-1).append("<td onlclick='javascript:changeTdOptions(this)' width='46px'><span >" +
				"	<span>"+dong.val()+"-"+hangNum.html()+(tabTds.size()<9?("0"+(parseInt(tabTds.size())+1)):(tabTds.size()+1))+"</span>" +
				"	<span>" +
				"		<div class='roomsex'>"+$("#hang"+hangNum.html()).eq(0).find(".hangHidenOptionsSex").eq(0).val()+"</div>" +
				"		<div class='roomps'>"+$("#hang"+hangNum.html()).eq(0).find(".hangHidenOptionsPs").eq(0).val()+"</div>" +
				"		<div class='roomfunc'>"+$("#hang"+hangNum.html()).eq(0).find(".hangHiddenOptionsFunc").eq(0).val()+"</div>" +
				"	</span>" +
				"</span></td>");
		$(roomNum).val($(tab).find("td").size());
		
	}else{
		//删除一个宿舍
		//不存 弹出没有数据删除  存在 删除最后一个
		if(tab.size()==0)
			alert("没有数据可以删除!!");
		else{
			var tabTds  = $(tab).find("td");
			$(tabTds).eq(tabTds.size()-1).remove();
			$(roomNum).val($(tab).find("td").size());
		}
	}
	
}