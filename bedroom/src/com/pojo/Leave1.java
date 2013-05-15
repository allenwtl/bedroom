package com.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Leave1 entity. @author MyEclipse Persistence Tools
 */

public class Leave1 implements java.io.Serializable {

	// Fields

	private Short leave1Id;
	private Leavetype leavetype;
	private Students students;
	private Teacher teacher;
	private Boolean leaveIsxiaojia;
	private Timestamp leaveTime;
	private Timestamp leaveBegintime;
	private Timestamp leaveEndtime;
	private String leaveAddress;
	private String leaveYijian;
	private String leaveReason;
	private Timestamp leaveTeachertime;
	private Boolean leaveXiaojiastatus;
	private Set leave2s = new HashSet(0);
	private Set xiaojias = new HashSet(0);

	// Constructors

	/** default constructor */
	public Leave1() {
	}

	/** minimal constructor */
	public Leave1(Leavetype leavetype, Students students, String leaveAddress,
			String leaveReason) {
		this.leavetype = leavetype;
		this.students = students;
		this.leaveAddress = leaveAddress;
		this.leaveReason = leaveReason;
	}

	/** full constructor */
	public Leave1(Leavetype leavetype, Students students, Teacher teacher,
			Boolean leaveIsxiaojia, Timestamp leaveTime,
			Timestamp leaveBegintime, Timestamp leaveEndtime,
			String leaveAddress, String leaveYijian, String leaveReason,
			Timestamp leaveTeachertime, Boolean leaveXiaojiastatus,
			Set leave2s, Set xiaojias) {
		this.leavetype = leavetype;
		this.students = students;
		this.teacher = teacher;
		this.leaveIsxiaojia = leaveIsxiaojia;
		this.leaveTime = leaveTime;
		this.leaveBegintime = leaveBegintime;
		this.leaveEndtime = leaveEndtime;
		this.leaveAddress = leaveAddress;
		this.leaveYijian = leaveYijian;
		this.leaveReason = leaveReason;
		this.leaveTeachertime = leaveTeachertime;
		this.leaveXiaojiastatus = leaveXiaojiastatus;
		this.leave2s = leave2s;
		this.xiaojias = xiaojias;
	}

	// Property accessors

	public Short getLeave1Id() {
		return this.leave1Id;
	}

	public void setLeave1Id(Short leave1Id) {
		this.leave1Id = leave1Id;
	}

	public Leavetype getLeavetype() {
		return this.leavetype;
	}

	public void setLeavetype(Leavetype leavetype) {
		this.leavetype = leavetype;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Boolean getLeaveIsxiaojia() {
		return this.leaveIsxiaojia;
	}

	public void setLeaveIsxiaojia(Boolean leaveIsxiaojia) {
		this.leaveIsxiaojia = leaveIsxiaojia;
	}

	public Timestamp getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Timestamp getLeaveBegintime() {
		return this.leaveBegintime;
	}

	public void setLeaveBegintime(Timestamp leaveBegintime) {
		this.leaveBegintime = leaveBegintime;
	}

	public Timestamp getLeaveEndtime() {
		return this.leaveEndtime;
	}

	public void setLeaveEndtime(Timestamp leaveEndtime) {
		this.leaveEndtime = leaveEndtime;
	}

	public String getLeaveAddress() {
		return this.leaveAddress;
	}

	public void setLeaveAddress(String leaveAddress) {
		this.leaveAddress = leaveAddress;
	}

	public String getLeaveYijian() {
		return this.leaveYijian;
	}

	public void setLeaveYijian(String leaveYijian) {
		this.leaveYijian = leaveYijian;
	}

	public String getLeaveReason() {
		return this.leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public Timestamp getLeaveTeachertime() {
		return this.leaveTeachertime;
	}

	public void setLeaveTeachertime(Timestamp leaveTeachertime) {
		this.leaveTeachertime = leaveTeachertime;
	}

	public Boolean getLeaveXiaojiastatus() {
		return this.leaveXiaojiastatus;
	}

	public void setLeaveXiaojiastatus(Boolean leaveXiaojiastatus) {
		this.leaveXiaojiastatus = leaveXiaojiastatus;
	}

	public Set getLeave2s() {
		return this.leave2s;
	}

	public void setLeave2s(Set leave2s) {
		this.leave2s = leave2s;
	}

	public Set getXiaojias() {
		return this.xiaojias;
	}

	public void setXiaojias(Set xiaojias) {
		this.xiaojias = xiaojias;
	}

}