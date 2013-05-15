package com.serviceInterf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pojo.Room;
import com.pojo.Roominfor;

public interface RoomServiceInterf {

	/**
	 * author:高华锋
	 * funciton:根据表单数据  讲一个寝室归属于一个学院  并显示刚添加的
	 * return  :装了寝室信息表的list
	 * parameter:封装了页面寝室信息的 寝室对象list   还有这些寝室要归属班级的信息*/
	public List<Roominfor> addRoomToCollege(List<Room> r,int classId,Map<String,String> beds);
	
	/**
	 * author:高华锋
	 * function:根据寝室编号将寝室从学院那里分离出来
	 * return :
	 * parameter：需要分离的宿舍的编号*/
	public  void deleteRoomNumber(String roomNumber,String classId);
	
	/**
	 * author:高华锋
	 * function:根据寝室编号找到宿舍的床位信息  然后判断班级号是否相同 相同 则显示床位信息不通 则显示相反的床位信息
	 * return 床位信息
	 * parameter:寝室编号 编号*/
	public List<String> selectChuangWei(String roomNumber,String classId);
	
	
	/**
	 * author:高华锋
	 * function:根据班级编号得到宿舍 
	 * return:宿舍信息
	 * parameter:班级编号*/
	public List<Map> getRoomsByClass(String classId);
	
	/**
	 * author:高华锋
	 * function:根据楼得到楼的详细信息  跳出哪些  没有人的
	 * parameter:选择的楼
	 * return 楼的没有人的宿舍的信息*/
	public List getEmptyRoom(String dongs, String classes,String cengs, String sex);
	
	/**
	 * author:高华锋
	 * function:根据指定楼层获得他的楼层数
	 * parameter:栋
	 * return : 该栋的楼层数*/
	public Integer getCengOfDong(String dongs);
	
	/**
	 * author:高华锋
	 * function:将选择的寝室号对应的寝室归属于一个班级
	 * return:success
	 * parameter:无*/
	public void addRoomToClass(List<String> rooms, List<String> chuangs,
			String classes);
	
	
	/**
	 * author:高华锋
	 * function:根据栋数得到栋的详情
	 * parameter:栋数
	 * return :栋的详情*/
	public List<Map<String, String>> getInforOfDong(String dong);
	
	/**
	 * author:高华锋
	 * function:根据栋和层去得到那楼层的信息
	 * @param hang2 
	 * @param dong2 */
	public List<Map<String, String>> getRoomOfCeng(String dong, String hang);
	
	
	/**
	 * author:高华锋
	 * function:从页面得到栋的信息然后创建
	 * parameter room roomNum roomSex roomPs roomFunc
	 * return 没有什么东西*/
	public int createDong(String dong, List<String> room, String address,
			List<String> roomNum, List<String> roomSex, List<String> roomPs,
			List<String> roomFunc);
	
	/**
	 * author:高华锋
	 * function：将属于班级的room添加到表格*/
	public List<Map<String, String>> getRoom(String classes, String sex);
}
