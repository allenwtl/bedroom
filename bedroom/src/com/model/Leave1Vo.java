package com.model;

import java.util.Date;

import com.pojo.Leavetype;

public class Leave1Vo {
	private Short leave1Id;
	private String teacher;
	private String students;
	private String leavetype;
	private boolean leaveIsxiaojia;
	private Date leaveTime;
	private Date leaveBegintime;
	private Date leaveEndtime;
	private String leaveAddress;
	private String leaveReason;
	private Date leaveTeachertime;
	private boolean leaveXiaojiastatus;
	
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getStudents() {
		return students;
	}

	public void setStudents(String students) {
		this.students = students;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public Short getLeave1Id() {
		return leave1Id;
	}

	public void setLeave1Id(Short leave1Id) {
		this.leave1Id = leave1Id;
	}

	
	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Date getLeaveBegintime() {
		return leaveBegintime;
	}

	public void setLeaveBegintime(Date leaveBegintime) {
		this.leaveBegintime = leaveBegintime;
	}

	public Date getLeaveEndtime() {
		return leaveEndtime;
	}

	public void setLeaveEndtime(Date leaveEndtime) {
		this.leaveEndtime = leaveEndtime;
	}

	public String getLeaveAddress() {
		return leaveAddress;
	}

	public void setLeaveAddress(String leaveAddress) {
		this.leaveAddress = leaveAddress;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public Date getLeaveTeachertime() {
		return leaveTeachertime;
	}

	public void setLeaveTeachertime(Date leaveTeachertime) {
		this.leaveTeachertime = leaveTeachertime;
	}

	public boolean isLeaveIsxiaojia() {
		return leaveIsxiaojia;
	}

	public void setLeaveIsxiaojia(boolean leaveIsxiaojia) {
		this.leaveIsxiaojia = leaveIsxiaojia;
	}

	public boolean isLeaveXiaojiastatus() {
		return leaveXiaojiastatus;
	}

	public void setLeaveXiaojiastatus(boolean leaveXiaojiastatus) {
		this.leaveXiaojiastatus = leaveXiaojiastatus;
	}

	

}
