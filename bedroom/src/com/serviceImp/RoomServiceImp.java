package com.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daoImp.RoomDaoImp;
import com.pojo.Room;
import com.pojo.RoomandstudentsId;
import com.pojo.Roominfor;
import com.serviceInterf.RoomServiceInterf;

public class RoomServiceImp implements RoomServiceInterf {

	private RoomDaoImp	roomDaoImp;

	public void setRoomDaoImp(RoomDaoImp roomDaoImp) {
		this.roomDaoImp = roomDaoImp;
	}


	public List<Roominfor> addRoomToCollege(List<Room> r,int classId,Map<String,String> beds) {
		try{
			List<Roominfor> roominfor = roomDaoImp.addRoomToCollege(r,classId,beds);
			return roominfor;
		}catch(Exception e){
			System.out.println("添加寝室到学院出错了！");
			e.printStackTrace();
			return null;
		}
		
		
	}


	@Override
	public void deleteRoomNumber(String roomNumber,String classId) {

		try{
			roomDaoImp.deletedeleteRoomNumber(roomNumber,classId);
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("寝室分离失败");
		}
	}


	@Override
	public List<String> selectChuangWei(String roomNumber, String classId) {
		try{
			return roomDaoImp.selectChuangWei(roomNumber,classId);
		}catch(Exception e){
			System.out.println("选床位失败 roomserviceimp 50");
			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public List<Map> getRoomsByClass(String classId) {
		try{
			return roomDaoImp.getRoomsByClass(classId);
		}catch(Exception e){
			System.out.println("根据班级得到寝室失败  63行");
			e.printStackTrace();
			return null;
		}
	}


	public List getEmptyRoom(String dongs, String classes,String cengs, String sex) {
		try{
			return roomDaoImp.getEmptyRoom(dongs,classes,cengs,sex);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("RoomServiceImp 77");
			return null;
		}
	}


	@Override
	public Integer getCengOfDong(String dongs) {
		try{
			int ceng  = roomDaoImp.getCengOfDong(dongs);
			return ceng;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("roomServiceImp 89");
			return null;
		}
		
	}


	public void addRoomToClass(List<String> rooms, List<String> chuangs,
			String classes) {
		try{
			roomDaoImp.addRoomToClass(rooms,chuangs,classes);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("roomServiceImp 103行");
		}
		
	}


	public List<Map<String, String>> getInforOfDong(String dong) {
		try{
			return roomDaoImp.getInforOfDong(dong);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("roomserviceimp 114行");
			return null;
		}
	}


	public List<Map<String, String>> getRoomOfCeng(String dong, String hang) {
		try{
			return roomDaoImp.getRoomOfCeng(dong,hang);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("roomserviceImp 125行");
			return null;
			
		}
	}


	public int createDong(String dong, List<String> room, String address,
			List<String> roomNum, List<String> roomSex, List<String> roomPs,
			List<String> roomFunc) {
		try{
			int i = roomDaoImp.createDong(dong,room,address,roomNum,roomSex,roomPs,roomFunc);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("roomServiceImp 第139行");
			return 0;
		}
		return 0;
	}


	public List<Map<String, String>> getRoom(String classes, String sex) {
		try{
			return roomDaoImp.getRoom(classes,sex);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("roomserviceImp 151行");
			return null;
		}
	}


	@Override
	public RoomandstudentsId getRoomandstudents(Short id) {
		return roomDaoImp.getRoomandstudents(id);
	}

	

	


}
