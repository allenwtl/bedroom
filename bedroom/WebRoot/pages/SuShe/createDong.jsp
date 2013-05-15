<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">


	<head></head>
	<script type="text/javascript" language="javascript" src="../jquery-1.4.2.min.js"></script>
	<script type='text/javascript' language='javascript' src='../jquery.form.js'></script>
	<script type="text/javascript" language="javascript" src="js/createDongJS.js"></script>
	<link type="text/css" rel="stylesheet" href="css/createDongCSS.css"/>
	<body>
		<div class="baoGao">
			<table class="baoGaoTab">
				<tr align="center">
					<td  colspan="2">第
					<span class="dongShu"><input onchange="javascript:getInforOfDong(this)" type="text"  name="dong" size="3"/></span>
					栋宿舍建设报告书</td>
					
				</tr>
				<tr align="left">
					<td>地点：</td>
					<td class="baoGaoTabDD"></td>
				</tr>
				<tr align="left" class="baoGaoTabTR">
					<td>楼层默认性别：</td>
					<td class="baoGaoTabSex"></td>
				</tr>
				<tr align="left" class="baoGaoTabTR">
					<td>楼层默认宿舍人数：</td>
					<td class="baoGaoTabPs"></td>
				</tr>
				<tr align="left" class="baoGaoTabTR">
					<td>楼层默认功能：</td>
					<td class="baoGaoTabFun"></td>
				</tr>
				<tr align="left">
					<td>楼层详情：</td>
					
					<td style="height: auto;">
						<div  id="hang1">
						<input class='hangHidenOptionsSex' type='hidden' value='男'/>
						<input class='hangHidenOptionsPs' type='hidden' value='5'/>
						<input class='hangHiddenOptionsFunc' type='hidden' value='学'/>
							<div class="baoGaohang1">第
								<span>1</span>
								层建设计划书
								<span class="setHangOptions" style="float: right;" onclick="javascript:changeCengOptions(this)">设置
									<input type="hidden" value="0"/>
								</span>
							</div>
							<div class="baoGaohang2">该层共建设
								<span class="dongShu"><input type="text" name="room" onchange="javascript:createRoomOfCeng(this)" size="3"/></span>
								个宿舍
								<span>
									<input class='addRoom' type='button' value='添加一个宿舍' onclick='javascript:addRoom(0,this)'/>
									<input class='delRoom' type='button' value='删除最后的宿舍' onclick='javascript:addRoom(1,this)'/>
								</span>
							</div>
						</div>
						<div class="addCeng" onclick="javascript:createCeng()">添加下一层</div>
						<div id="deleteCeng" onclick='javascript:deleteCeng()'>删除最后一行</div>
					</td>
				</tr>
			</table>
			
			<div class="gaiZhang">盖章</div>
			<div class="qianShu">
				<table class="qianShuTab">
					
					<tr align="left">
						<td>时间：</td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="paraBiao">
			<table class="paraBiaoTab">
				<tr align="center">
					<td colspan=5">第
					<span class="dongShu"><input type="text"  size="3"/></span>
					栋简易参数表</td>
				</tr>
				<tr align="center">
					<td>楼层数</td>
					<td>寝室数</td>
					<td>床位数</td>
					<td>性别</td>
					<td>功能</td>
				</tr>
			</table>
		</div>
		<div class="anNiuCJ"><input type='button' onclick='javascript:chuangjian()' value='创建'/></div>
		<div class='anNiuGJ'><input type='button' onclick='javascript:gaijian()' value='改建'/></</div>
		<div id="hForm">
			<form id="hiddenForm" ></form>
		</div>
	</body>
