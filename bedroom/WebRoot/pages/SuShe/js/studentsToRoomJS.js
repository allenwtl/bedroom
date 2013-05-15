var s = 1;
var bed = 'ABCDEFGHIJKLMNOPQISTUVWXYZ';
//这个参数用于将学生添加到宿舍中时控制插入哪一行的
var hang = 1;
var insertMode = 1;
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

$(document).ready(function(){
	
	$("#myformDiv").hide();
	showKuang();
	moveStuToTab();
	moveStuToTab2();
	//$(".strInforOfStudentsTAB").eq(0).chromatable();
	
	$.post("getXueYearaddRoomAction!.action",function(data){
		var json = eval("("+data+")");
		$("#arnianfen>option").remove();
		for ( var i = 0; i < json.length; i=i+1) {
			$("#arnianfen").append("<option value="+i+">"+json[i]+"</option>");
		}
})

var options={
		url: 'teststudentsToRoomAction!.action',
		type: 'post',
		beforeSubmit: beforeS,
		success:jiance,// 我以为在这个函数里执行的
		error: pri,
};
	
	$("#strForm").submit(function(){// 单击了 submit按钮
		$(this).ajaxSubmit(options);// 立即提交表单 是这里吗 嗯
		return false;
	})
	
	var options2={
	url: 'stuToRoomstudentsToRoomAction!.action',
	type:'post',
	success: stuToRoomA,
	error:stuToRoomP,
	};
	$("#myform").submit(function(){
		$(this).ajaxSubmit(options2);
		return false;
	})
})



function beforeS(formData, jqForm, options){
	var mycolleges = $("#mycolleges>option:selected").val();
	var mymajors   = $("#mymajors>option:selected").val();
	var myclasses  = $("#myclasses>option:selected").val();

	
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
	

}

function pri(){
	alert("jquery.form提交出错了 开来修复啊")
}
function jiance(){
	getStuBySex(1);
	addRoom(s);
	
}

/**
 * author:高华锋
 * function：将有床位的学生添加到roomtab中
 * parameter：class_id,sex*/
function addStuOfRoom(){
	$.post("addStuOfRoomstudentsToRoomAction!.action",function(data){
		var json = eval("("+data+")");
		for(var i = 0 ; i < json.length ; i = i +1){
			addStuOfRoomToTab(json[i]);
		}
	});
}

/**
 * author:高华锋
 * function:完成一次将一个有床位的学生添加到room表格中
 * parameter:
 * return */
function addStuOfRoomToTab(stu){
	var trs = $("#tr"+stu.room_id+"-"+stu.students_bed);
	var tdNum = qufenRowSpan(trs);
	$(trs).find("td").eq(tdNum).html(stu.students_number);
	$(trs).find("td").eq(tdNum+1).html(stu.students_name);
	$(trs).find("td").eq(tdNum+2).html(stu.students_nativeplace);
	$(trs).find("input").val("1");
}
/**
 * author:高华锋
 * function：将属于班级的room添加到表格*/
function addRoom(sex){
	$.post("getRoomstudentsToRoomAction!.action",{"sex":sex},function(data){
		var json = eval("("+data+")");
		for(var i = 0 ; i < json.length ; i=i+1){
			addRoomToTab(json[i]);
			var tds = $(".tr"+json[i].room_id).eq(0).find("td").eq(0);
			$(tds).attr("rowspan",4);
		}
		
		addStuOfRoom();
	})
}

/***
 * author:高华锋
 * function:完成一次一个宿舍的添加*/
function addRoomToTab(r){
	var tab = $(".strInforOfRoom").eq(0).find("table");
	for(var i = 0 ; i < r.room_ps ; i = i +1){
		
		var diyihang = "";
		if(i==0)
			diyihang = "<td>"+r.room_number+"</td>";
		else
			diyihang = "";
		$(tab).append("<tr id='tr"+r.room_id+"-"+bed.substring(i,i+1)+"' class='tr"+r.room_id+"'  align='center'>" +
				"<input type='hidden' value='0'/>" +
				diyihang+
				"<td>"+bed.substring(i,i+1)+"</td>" +
						"<td>"+r.college_name+"-"+r.class_name+"</td>" +
								"<td></td><td></td><td></td></tr>");
	}
}

/**
 * author:高华锋
 * function:根据性别 和其他信息得到学生  来给他们分配宿舍
 * return 学生的信息
 * parameter:性别
 */
function getStuBySex(i){
	s= i ;
	$(".strInforOfStudentsTAB").eq(0).find("tbody").find(".studentsTr").remove();
	$.post("getStuBySexstudentsToRoomAction!.action",{"sex":i},function(data){
		var josn = eval("("+data+")");
		for(var i = 0 ; i < josn.length ; i=i+1){
			addStudent(josn[i].students_number,josn[i].students_name,josn[i].students_nativepalce);
		}
	})
	
}

/**
 * author:高华锋
 * function :得到 学生的信息然后添加到 表格中*/
function addStudent(xuehao,xingming,jiguan){
	$(".strInforOfStudentsTAB").eq(0).find("tbody").append("<tr class='studentsTr' align='center'>" +
			"<td>"+xuehao+"</td>" +
			"<td>"+xingming+"</td>" +
			"<td>"+jiguan+"</td>" +
					"</tr>");
}

/**
 * author:高华峰
 * function:实现框的选中*/
function showKuang(){
	
	$("tr").live("mouseover",function(){
		var tds = $(this).find("td");
		
		$(tds).css({'border-bottom-color':'red','border-top-color':'red'});
		var prevtr = $(this).prev();
		$(prevtr).find("td").css({'border-bottom-color':'red'});
		$(tds).eq(0).css({'border-left-color':'red'});
		$(tds).eq(tds.size()-1).css({'border-right-color':'red'});
	})
	$("tr").live("mouseout",function(){
		var tds = $(this).find("td");
		$(tds).css({'border-bottom-color':'D5D5D5','border-top-color':'D5D5D5'});
		var prevtr = $(this).prev();
		$(prevtr).find("td").css({'border-bottom-color':'D5D5D5'});
		$(tds).eq(0).css({'border-left-color':'D5D5D5'});
		$(tds).eq(tds.size()-1).css({'border-right-color':'D5D5D5'});
	})

}

/**
 * author:高华锋
 * function: 主要是因为那个表格的rowspan会打乱结构所以做了这个*/

function qufenRowSpan(hang){
	
	var tdNum = 0;
	if( $(hang).find("td").eq(0).attr("rowspan")==1){
		tdNum = 2;
	}else{
		tdNum = 3;
	}
	return tdNum;
}

/**
 * author：高华锋
 * function：得到改行的寝室号*/
function getDiYiHang(hang){
	var hangNumber = $(hang).attr("class");
	var num = hangNumber.substring(2,hangNumber.length);
	return num;
}
function getChuangWei(hang){
	var chuang = $(hang).attr("id");
	var bed = chuang.substring(chuang.length-1,chuang.length);
	return bed;
}
/**
 * author：高华锋
 * function：将信息添加到表单提交到后台*/
function addFormInput(room,studentsNumber,studentsBed,mode){
		var myform = $("#myform");
		var myformInput = $(myform).find("span>input[name='studentsNumber']");
		for(var i = 0 ; i < myformInput.size(); i= i +1){
			if($(myformInput).eq(i).val()==studentsNumber){
				$(myformInput).eq(i).parent().remove();
				if(insertMode==0)
					return true;
		}
		}
		var insertModeClass="";
		if(mode=="insertMode")
			insertModeClass="class='insertMode'";
	$("#myform").append("<span "+insertModeClass+">" +
			"<input type='text' name='roomNumber' value='"+room+"'/>" +
			"<input type='text' name='studentsNumber' value='"+studentsNumber+"'/>" +
			"<input type='text' name='studentsBed' value='"+studentsBed+"'/></span>")
}

/**
 * author:高华锋
 * function:将一个学生放入宿舍中*/
function moveStuToTab(){
	$(".strInforOfStudentsTAB").find("tbody>tr").live("click",function(){
		if(insertMode==0){
			moveStuToTabMod0(this);
		}else{
			moveStuToTabMod1(this);
		}	
	})	
}
function moveStuToTabMod0(m){
	var charuhang = $(".strInforOfRoom").eq(0).find("table>tbody>tr>input[value='0']").eq(0).parent();
	var tdNum = qufenRowSpan(charuhang);
	
	$(charuhang).find("td").eq(tdNum).html($(m).find("td").eq(0).html());
	$(charuhang).find("td").eq(tdNum+1).html($(m).find("td").eq(1).html());
	$(charuhang).find("td").eq(tdNum+2).html($(m).find("td").eq(2).html());
	//表示改行已经有了数据  0表示没有1表示有
	$(charuhang).find("input").val("1");
	addFormInput(getDiYiHang(charuhang),$(charuhang).find("td").eq(tdNum).html() ,$(charuhang).find("td").eq(tdNum-2).html());
	$(m).remove();
}

function moveStuToTabMod1(m){
	//保证他点击了同一类栋洗不出错
	$("#suiYiMode").find("input").remove();
	$("#suiYiMode").append("<input value='"+$(m).find("td").eq(0).html()+"'/>" +
			"<input value='"+$(m).find("td").eq(1).html()+"'/>" +
			"<input value='"+$(m).find("td").eq(2).html()+"'/>");
	$("#myform").find(".insertMode").remove();
	addFormInput("",$(m).find("td").eq(0).html(),"","insertMode");
}

/**
 * author:高华锋
 * function:将一个学生从一个宿舍的床位中退出*/
function moveStuToTab2(){
	
	$(".strInforOfRoom").find("table>tbody>tr").live("click",function(){	
		//如果他的数据为0 就是没有直接退出  如果 insertmode为1  直接插入
		
			var tdNum = qufenRowSpan(this);
			var number= "";
			var name="";
			var address='';
			if(insertMode==1){
				//删除模式
				if($("#suiYiMode").find("input").size()==0){
					moveStuToTab2Mod0(this,tdNum);
					$(this).find("td").eq(tdNum).html(number);
					$(this).find("td").eq(tdNum+1).html(name);
					$(this).find("td").eq(tdNum+2).html(address);
					return true;
					}
				if($(this).find('input').val()==0){	
					//没有值的情况下
					var inps = moveStuToTab2Mod1(0,this);
					number = $(inps).eq(0).val();
					name = $(inps).eq(1).val();
					address = $(inps).eq(2).val();
					//去掉学生的那一行
					
					
				}else{	
					//有值的情况下
					moveStuToTab2Mod0(this,tdNum);
					var inps = moveStuToTab2Mod1(0,this);
					number = $(inps).eq(0).val();
					name = $(inps).eq(1).val();
					address = $(inps).eq(2).val();
					
				}
				$("#suiYiMode").find("input").remove();
			}else{
				if($(this).find("input").val()==0)
					return false;
				else{
					moveStuToTab2Mod0(this,tdNum);
				}
			}
				$(this).find("td").eq(tdNum).html(number);
				$(this).find("td").eq(tdNum+1).html(name);
				$(this).find("td").eq(tdNum+2).html(address);
		
	})
}

function moveStuToTab2Mod0(m,tdNum){
	//得到 表格
	var tab = $(".strInforOfStudentsTAB").eq(0);
	//创建行在里面添加
	
	addStudent($(m).find("td").eq(tdNum).html(),$(m).find("td").eq(tdNum+1).html(),$(m).find("td").eq(tdNum+2).html())
	addFormInput(getDiYiHang(m),$(m).find("td").eq(tdNum).html() ,"");
	$(m).find("input").val("0");
	
}
function moveStuToTab2Mod1(status,m){
	$(m).find("input").val("1");
	//学号 name 还有地址
	var inps = $("#suiYiMode").find("input");
	var number = $(inps).eq(0).val();
	var name = $(inps).eq(1).val();
	var address = $(inps).eq(2).val();
	
		//寝室号是空的   学号是有的  床位号是空的
		var roomNumber = getDiYiHang(m);
		var bed =        getChuangWei(m);
		var myformInputs = $("#myform").find(".insertMode").eq(0);
		var inp  = $(myformInputs).find("input");
		$(inp).eq(0).attr("value",roomNumber);
		$(inp).eq(2).attr("value",bed);
		$(myformInputs).attr("class","");
		//用于可以看到的行的学号姓名地址
		// 得到学生的所有tr  删除 跟改行学号一样的哪行
		var trs = $(".strInforOfStudentsTAB").eq(0).find("tbody>tr");
		var num2 = $(inps).eq(0).val();
		for(var i = 1 ; i < trs.size() ; i= i+1){
			var num1 = $(trs).eq(i).find("td").eq(0).html();
			if(num1==num2)
				$(trs).eq(i).remove();
		}
		return inps;	
}



function stuToRoomA(){
	alert("添加成功了")
}
function stuToRoomP(){
	alert("stuToRoom表单提交错误 请联系管理员")
}

function tiJiaoMyForm(){
	$("#myform").submit();
}