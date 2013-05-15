package com.aciton.SuShe;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.aciton.BaseAction;
import com.serviceImp.RoomServiceImp;

public class CreateDongAction extends BaseAction {
	
	private RoomServiceImp roomServiceImp;
	

	public void setRoomServiceImp(RoomServiceImp roomServiceImp) {
		this.roomServiceImp = roomServiceImp;
	}

	private String dong;
	private String address;
	private String sex;
	private String func;
	private String ps;
	private String hang;
	private List<String> room;
	private List<String> roomNum;
	private List<String> roomSex;
	private List<String> roomPs;
	private List<String> roomFunc;
	
	private	String gaiCengs;
	private List<String> gaiHangs;

	public String getGaiCengs() {
		return gaiCengs;
	}

	public void setGaiCengs(String gaiCengs) {
		this.gaiCengs = gaiCengs;
	}

	public List<String> getGaiHangs() {
		return gaiHangs;
	}

	public void setGaiHangs(List<String> gaiHangs) {
		this.gaiHangs = gaiHangs;
	}

	public List<String> getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(List<String> roomNum) {
		this.roomNum = roomNum;
	}

	public List<String> getRoomSex() {
		return roomSex;
	}

	public void setRoomSex(List<String> roomSex) {
		this.roomSex = roomSex;
	}

	public List<String> getRoomPs() {
		return roomPs;
	}

	public void setRoomPs(List<String> roomPs) {
		this.roomPs = roomPs;
	}

	public List<String> getRoomFunc() {
		return roomFunc;
	}

	public void setRoomFunc(List<String> roomFunc) {
		this.roomFunc = roomFunc;
	}

	
	
	
	
	
	

	public List<String> getRoom() {
		return room;
	}

	public void setRoom(List<String> room) {
		this.room = room;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	/**
	 * author:高华锋
	 * function:根据栋数得到是否有改动的信息*/
	public String getInforOfDong(){
		
		List<Map<String,String>> d = roomServiceImp.getInforOfDong(dong);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		if(d.size()==0){
			Map map = new HashMap<String,String>();
			map.put("kong", "null");
			d.add(map);
			}
		String json = JSONArray.fromObject(d).toString();
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
			
		return null;
	}
	/**
	 * author:高华锋
	 * function:根据栋和层去得到那楼层的信息
	 * @param hang2 
	 * @param dong2 */
	public String getRoomOfCeng(){
		List<Map<String,String>> rooms = roomServiceImp.getRoomOfCeng(dong ,hang );
		String json = JSONArray.fromObject(rooms).toString();
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * author:高华锋
	 * function:从页面得到栋的信息然后创建
	 * parameter room roomNum roomSex roomPs roomFunc
	 * return 没有什么东西*/
	public String createDong(){
		int i = roomServiceImp.createDong(dong,room,address,roomNum,roomSex,roomPs,roomFunc);
		return null;
	}
}
