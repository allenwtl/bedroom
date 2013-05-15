
var pceng = 1;

/**
 * author:高华锋 function:根据学院获得他的专业 return:无 参数：无
 */	
function getMajorByCollege(){
	var collegeId = $("#mycolleges>option:selected").val();
	// alert(123);
	$("#myclasses>option").remove();
	$.post("getAllMajorsaddRoomAction!.action?collegeId="+collegeId,function(data){
		// 首先清空
		var json = eval("("+data+")");
		$("#mymajors>option").remove();
		// 然后添加
		if(json!=null){
			for(var i =0 ; i<json.length; i=i+1){
			   $("#mymajors").append("<option  value='"+json[i].majorId+"'>"+json[i].majorName+"</option>"); 
			}
			getClassesByMajor();
		}
	})
	
	
}
/**
 * author:高华锋 function:根据选择的楼层得到该楼层的所有寝室 return :无 parameter:无
 */
function getRooms(){
		$("input[name='rooms']").remove();
		$(".checkboxLabel").remove();
		var cengs = $("#mycengs>option:selected").val();
		var cengs2= cengs.substr(0,1);
		$.post("getAllRoomsaddRoomAction!.action",{'cengs':cengs2},function(data){
			var json = eval("("+data+")");
			for(var i =0; i < json.length;i=i+1){
			$("<input type='checkbox' onclick='javascript:selectChuangWei(this)' name='rooms' value='"+json[i]+"' id='rooms-"+i+1+"'/><label for='rooms-"+i+1+"' class='checkboxLabel'>"+json[i]+"</label>").insertBefore($("#__multiselect_myrooms"))
			}
	})
}
/**
 * author:高华锋 function:根据专业得到班级 return :无 parameter:无
 */
function getClassesByMajor(){
			$("#myclasses>option").remove();
			var majors = $("#mymajors").val();
			var nianfen= $("#arnianfen").val();
			
			if(majors==null)
				majors="0";
			if(nianfen==null)
				nianfen =1;
			$.post("getClassesByMajoraddRoomAction!.action?",{'majorId':majors,'nianfen':nianfen},function(data){
				var json2  = eval("("+data+")");
				for(var i = 0 ;i<json2.length;i=i+1){
				$("#myclasses").append("<option value='"+json2[i].class_id+"'>"+json2[i].class_name+"</option>");
				}
			})
			
	}

function getClassesByNianfen(){
	getClassesByMajor();
}

/**
 * author:高华锋 function:异步提交表单 在下面的表格中添加 刚操作的寝室 return : 刚操作寝室的信息 parameter:无
 */

$(document).ready(function(){
	
	$.post("getDongCengRoomsaddRoomAction!.action",function(data){
		var json = eval("("+data+")");
		$("#mydongs>option").remove();
		
		for(var i =0;i<json.length;i=i+1){
			$("#mydongs").append("<option selected='selected' value='"+json[i]+"'>"+json[i]+"</option>");
		}
		
	});

	
	$(".inforOfChuang").hide();
	
	$("#adShowEmptyRoomsTab>tbody>tr>td").live('dblclick',function(event){
		var iii = $(this).find("div>input");
		$($(this).find("div>input")).each(function(i,o){
			if($(o).attr("checked")==false){	
				$(iii).attr("checked",true);
				return false;
			}else{
				if(i==3){
					//不选中
					$(iii).attr("checked",false);
					return false;
				}
			}
		})
		
		/**这里重复了 change 下面的方法的内容*/
		var room = $(this).parent().find("td").eq(0).find("div").html();
		var chuang = $(this).find(":checked");
		var chuangs ="";
		$(chuang).each(function(i,o){
			chuangs+=$(o).val();
		})
		
		if($(".inforOfChuang>form>span>input").size()==0){
			$(".inforOfChuang>form").append("<span><input name='rooms' class='roomss' type='hidden' value='"+room+"'/><input name='chuangs' type='hidden' value='"+chuangs+"'/></span>")
			return true;
		}
		var tag = 0;
		var r = $(".inforOfChuang>form>span").find("input[class=roomss]");
		$(".inforOfChuang>form>span").find("input[class=roomss]").each(function(i,o){
				
					if($(o).val()==room)
					{
						$(this).parent().find("input").eq(1).val(chuangs);
						tag =1;
					}
				
		})
		if(tag==0)
			$(".inforOfChuang>form").append("<span><input name='rooms' class='roomss' type='hidden' value='"+room+"'/><input name='chuangs' type='hidden' value='"+chuangs+"'/></span>")
		
	})
	
	$("#adShowEmptyRoomsTab>tbody>tr>td").live('change',function(event){
			var room = $(this).parent().find("td").eq(0).find("div").html();
			var chuang = $(this).find(":checked");
			var chuangs ="";
			$(chuang).each(function(i,o){
				chuangs+=$(o).val();
			})
			
			if($(".inforOfChuang>form>span>input").size()==0){
				$(".inforOfChuang>form").append("<span><input name='rooms' class='roomss' type='hidden' value='"+room+"'/><input name='chuangs' type='hidden' value='"+chuangs+"'/></span>")
				return true;
			}
			var tag = 0;
			var r = $(".inforOfChuang>form>span").find("input[class=roomss]");
			$(".inforOfChuang>form>span").find("input[class=roomss]").each(function(i,o){
					
						if($(o).val()==room)
						{
							$(this).parent().find("input").eq(1).val(chuangs);
							tag =1;
						}
					
			})
			if(tag==0)
				$(".inforOfChuang>form").append("<span><input name='rooms' class='roomss' type='hidden' value='"+room+"'/><input name='chuangs' type='hidden' value='"+chuangs+"'/></span>")
			
	});
	
	$.post("getXueYearaddRoomAction!.action",function(data){
			var json = eval("("+data+")");
			$("#arnianfen>option").remove();
			for ( var i = 0; i < json.length; i=i+1) {
				$("#arnianfen").append("<option value="+i+">"+json[i]+"</option>");
			}
	})
	
	var options={
			url: 'testaddRoomAction!.action',
			type: 'post',
			beforeSubmit: beforeS,
			success:jiance,// 我以为在这个函数里执行的
			error: pri,
	};
	
	$("#myform").submit(function(){// 单击了 submit按钮
		$(this).ajaxSubmit(options);// 立即提交表单 是这里吗 嗯
		return false;
	})
	
	var options2 ={
		url:'addRoomaddRoomAction!.action',
		type:'post',
		error:errorOfChuang
	}
	
	
	$(".pFirst pButton").live('click',function(){
		alert('123');
		$.post("testaddRoomAction!.action",{"ceng":1},function(){});
		$("#adShowEmptyRoomsTab").flexReload();
	})
	
	$("#myform2").submit(function(){
		$(this).ajaxSubmit(options2);
		return false;
	})
	

	
	
})



function errorOfChuang(){
	alert("影藏的form提交出错了 ，快联系管理员!");
}
/**
 * author:高华锋
 * function:床位的框是否选中，主要看他的已有床位*/
function checkedKuang(){
	
	
	
	var trs = $("#adShowEmptyRoomsTab>tbody>tr");
	for(var i =0;i<trs.length;i=i+1){
		var ybed = trs.eq(i).find("td").eq(2).find("div").html();
		var sbedKuang = trs.eq(i).find("td").eq(3).find("div");
		var sbed = sbedKuang.html();
		sbedKuang.html("");
		if(ybed=='&nbsp;'&&sbed=='&nbsp;')
		{
			return false;
		}
		for(var j=0;j<sbed.length;j=j+1){
			
			if(ybed.indexOf(sbed[j])>-1)
				sbedKuang.append(sbed[j]+"<input type='checkbox' value='"+sbed[j]+"' checked='true'/>");
			else
				sbedKuang.append(sbed[j]+"<input type='checkbox' value='"+sbed[j]+"'/>");
		}
	}
	
}


/**
 * author:高华锋 function:根据的到寝室号 去选择床位 return :无 parameter：无
 */
function selectChuangWei(i){
	// 删除床位的这句话我删掉了
	var roomNum = i.value;
	var mydongs = $("#mydongs>option:selected").val();
	var classes = $("#myclasses>option:selected").val();
	if(i.checked){
		var a =$("#arfrctab"+roomNum).get(0);
		if(a!=null)
			return false;
		$.post("selectChuangWeiaddRoomAction!.action",{"selectRoom":i.value,"dongs":mydongs,"classes":classes},function(data){
			var json = eval("("+data+")");
			var quanBed= "ABCD";
			$("#arfrctab").append("<tr align='center' class='r' id='"+json[2]+"'>" +
					"<td>"+$("#mydongs>option:selected").val()+roomNum+"</td></tr>");
			
			for(var i=0;i<4;i=i+1){
				if(json[1].indexOf(quanBed.substr(i,1))>-1){
					
					$("#arfrctab"+roomNum).append("<td>"+quanBed.substr(i,1)+"<input id='arfrctabtd"+roomNum+quanBed.substr(i,1)+"' type='checkbox' name='beds' value='"+roomNum+"-"+quanBed.substr(i,1)+"'/></td>")
				}else{
					$("#arfrctab"+roomNum).append("<td>"+quanBed.substr(i,1)+"</td>")
				}
			}
			
			for(var m=0;m<4;m=m+1){
				if(json[0].indexOf(quanBed.substr(m,1))>-1){
					$("#arfrctabtd"+roomNum+quanBed.substr(m,1)).attr("checked",true);
				}
			}
		});
	}else{
		var a =$("#arfrctab"+roomNum).get(0);
		if(a!=null)
			$("#arfrctab"+roomNum).remove();
		
	}
	
}
/**
 * author：高华锋 function:异步提交表单前 前台检测 return :无 parameter:无
 */
function beforeS(formData, jqForm, options){
	var mycolleges = $("#mycolleges>option:selected").val();
	var mymajors   = $("#mymajors>option:selected").val();
	var myclasses  = $("#myclasses>option:selected").val();
	var mydongs    = $("#mydongs>option:selected").val();

	
	if(mycolleges==null){
		alert('请选择学院');
		return false;
	}
	if(mymajors==null){
		alert('请选择专业');
		return false;
	}
	if(myclasses==null){
		alert('请选择班级');
		return false;
	}
	if(mydongs==null){
		alert('请选择那座寝室');
		return false;
	}
	if(mydongs=='-')
	{
		alert("请选择有效的楼!");
		return false;
	}

}
/**
 * author:高华锋 function:表单提交后 返回的数据处理 return :装着 寝室信息的 json字符串 parameter:无
 */
function jiance(){
	var isExit = $("#adShowEmptyRooms").find(".flexigrid").length;
	if(isExit==0)
	{
		$("#adShowEmptyRoomsTab").flexigrid({
			url:'getEmptyRoomsToFlexigridaddRoomAction!.action',
			dataType:'json',

			colModel : [ {
				display:'宿舍号',
				name:'roomNumber',
				width:100,
				sortable:false,
				align:'center'
			},{
				display:'所属学院和班级',
				name:'toCollege',
				width:300,
				sortable:false,
				align:'center'
			},{
				display:'已用床位',
				name:'yChuang',
				width:100,
				sortable:false,
				align:'center'	
			},{
				display:'可用床位',
				name:'kChuang',
				width:120,
				sortable:false,
				align:'center'
			}],
			searchitems : [ {   
				display :'id',
				name :'id',
				isdefault :true
			}],
			buttons:[{separator : true }],

			title:'无分配任务',
			usepager: true,
			showTableToggleBtn: true,
			height:400,
			autoload: true,
			useRp:false,
			onSuccess: checkedKuang,
		
			pagestat:'正在显示1-->{total}个寝室',
			pagetext:'正在第',
			outof:'层     共'

		});
		$(".pDiv2").eq(0).append("<div class='btnseparator'></div><div class='pGroup'><span><input onclick='javascript:flexTiJiao()' type='button' value='提交'/></span></div>");
		$(".pDiv2").eq(0).append("<div class='btnseparator'></div><div class='pGroup'><span><input onclick='javascript:flexReset()' type='button' value='重置'/></span></div><div class='btnseparator'></div>");
		$(".pcontrol>span").after("层");
	}else{		
		$("#adShowEmptyRoomsTab").flexReload();
		var dong = $("#mydongs").val();
		var classes = $("#myclasses").val();
		var className = $("#myclasses>option[value="+classes+"]").html();
		$(".tDiv2").eq(0).find("div").remove();
		$(".ftitle").eq(0).html("正在第<font color='red'>"+dong+"<font/><font color='black'>栋为<font/><font color='red'>"+className+"<font/><font color='black'>分配床位<font/>");

	
	
		}
		
		
		
		// frist
		$(".pGroup").eq(1).html("<span class='pFistButton' onclick='javascript:pageButton(1)'><img src='pages/SuShe/css/images/first.gif'/></span><span class='pNextButton' onclick='javascript:pageButton(2)'><img src='pages/SuShe/css/images/prev.gif'/></span>");		
		// prev
		$(".pGroup").eq(3).html("<span class='pNextButton' onclick='javascript:pageButton(3)'><img src='pages/SuShe/css/images/next.gif'/></span><span class='pNextButton' onclick='javascript:pageButton(4)'><img src='pages/SuShe/css/images/last.gif'/></span>");		
		// next
		// last
		

}

function wodesuccess(){
	if($(".mycengButton").size()==0){
		$.post("getCengOfDongaddRoomAction!.action",function(data){
			
			var json = eval("("+data+")");
			
			for(var i =0;i<json[0];i=i+1){
				$(".tDiv>div").eq(0).append("<div class='fbutton'><div><span class='mycengButton' onclick='javascript:getRoomsByCeng("+(i+1)+")' >第"+(i+1)+"层</span></div></div><div class='btnseparator'></div>");
				
			}
			var ceng = $(".fbutton").eq($(".fbutton").size()-1).find("div>span").html();
			
			var reg = /^.([0-9]{1}).$/;
			var r   =ceng.match(reg);
			$(".pcontrol>span").html(r[1]);
			
		})
	}else{
		var ceng = $(".fbutton").eq($(".fbutton").size()-1).find("div>span").html();
		
		var reg = /^.([0-9]{1}).$/;
		var r   =ceng.match(reg);
		$(".pcontrol>span").html(r[1]);
	}

	$(".pcontrol").eq(0).find("input").val(pceng);
	
}
/**
 * author:高华锋
 * function: 响应flexigrid表格的提交按钮 将床位配送给某个班级
 * parameter: 床位
 * return:*/
function flexTiJiao(){
	alert('flexTiJiao');
	$("#myform2").submit();
}
/**author:高华锋
 * function:重置flexgrid中的所有信息
 * parameter:已经传过去了
 * return:*/
function flexReset(){
	$("#adShowEmptyRoomsTab").flexReload();
}

/**
 * author:高华锋
 * function：响应flexgird表格中的页面操作*/

function pageButton(com){
	var nowPageStr = $(".pcontrol>input").val();
	var totalPageStr = $(".pcontrol>span").html();
	
	var nowPage = parseInt(nowPageStr);
	var totalPage= parseInt(totalPageStr);
	if(com==1)
		pceng =1;
	if(com==2){
		if(nowPage==1)
			pceng =1;
		else
			pceng = nowPage-1;
	}
	if(com==3){
		if((nowPage)==totalPage)
			pceng = totalPage;
		else
			pceng = nowPage+1;
	}
	if(com==4)
		pceng =totalPage;
		
	$.post("testaddRoomAction!.action",{"cengs":pceng},function(data){})
	$("#adShowEmptyRoomsTab").flexReload();
	
	
		
}

function getRoomsByCeng(i){
	pceng = i;
	$.post("testaddRoomAction!.action",{"cengs":i},function(){
		
		$("#adShowEmptyRoomsTab").flexReload();
	})
}
/**
 * author:高华锋 function:也不提交表单出错 return :无 parameter：无
 */
function pri(){
	alert('表单提交出错了 快找管理员');
}

/**
 * author:高华锋 function:根据性别得到所有的栋 然后发到页面 return:无 parameter：无
 */


