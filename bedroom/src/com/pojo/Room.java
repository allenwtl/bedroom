package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room implements java.io.Serializable {

	// Fields

	private Short roomId;
	private Qinshi qinshi;
	private String roomNumber;
	private Boolean roomSex;
	private Short roomCeng;
	private Short roomPs;
	private Short roomFun;
	private Set roomlists = new HashSet(0);
	private Set studentses = new HashSet(0);
	private Set roomandbanjis = new HashSet(0);

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	public Room(String roomNumber, Boolean roomSex) {
		this.roomNumber = roomNumber;
		this.roomSex = roomSex;
	}

	/** full constructor */
	public Room(Qinshi qinshi, String roomNumber, Boolean roomSex,
			Short roomCeng, Short roomPs, Short roomFun, Set roomlists,
			Set studentses, Set roomandbanjis) {
		this.qinshi = qinshi;
		this.roomNumber = roomNumber;
		this.roomSex = roomSex;
		this.roomCeng = roomCeng;
		this.roomPs = roomPs;
		this.roomFun = roomFun;
		this.roomlists = roomlists;
		this.studentses = studentses;
		this.roomandbanjis = roomandbanjis;
	}

	// Property accessors

	public Short getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Short roomId) {
		this.roomId = roomId;
	}

	public Qinshi getQinshi() {
		return this.qinshi;
	}

	public void setQinshi(Qinshi qinshi) {
		this.qinshi = qinshi;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Boolean getRoomSex() {
		return this.roomSex;
	}

	public void setRoomSex(Boolean roomSex) {
		this.roomSex = roomSex;
	}

	public Short getRoomCeng() {
		return this.roomCeng;
	}

	public void setRoomCeng(Short roomCeng) {
		this.roomCeng = roomCeng;
	}

	public Short getRoomPs() {
		return this.roomPs;
	}

	public void setRoomPs(Short roomPs) {
		this.roomPs = roomPs;
	}

	public Short getRoomFun() {
		return this.roomFun;
	}

	public void setRoomFun(Short roomFun) {
		this.roomFun = roomFun;
	}

	public Set getRoomlists() {
		return this.roomlists;
	}

	public void setRoomlists(Set roomlists) {
		this.roomlists = roomlists;
	}

	public Set getStudentses() {
		return this.studentses;
	}

	public void setStudentses(Set studentses) {
		this.studentses = studentses;
	}

	public Set getRoomandbanjis() {
		return this.roomandbanjis;
	}

	public void setRoomandbanjis(Set roomandbanjis) {
		this.roomandbanjis = roomandbanjis;
	}

}