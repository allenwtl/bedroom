package com.pojo;

import java.sql.Timestamp;

/**
 * Xiaojia entity. @author MyEclipse Persistence Tools
 */

public class Xiaojia implements java.io.Serializable {

	// Fields

	private Short xiaojiaId;
	private Leave1 leave1;
	private Teacher teacher;
	private Timestamp leaveXiaojiatime;

	// Constructors

	/** default constructor */
	public Xiaojia() {
	}

	/** minimal constructor */
	public Xiaojia(Leave1 leave1, Teacher teacher) {
		this.leave1 = leave1;
		this.teacher = teacher;
	}

	/** full constructor */
	public Xiaojia(Leave1 leave1, Teacher teacher, Timestamp leaveXiaojiatime) {
		this.leave1 = leave1;
		this.teacher = teacher;
		this.leaveXiaojiatime = leaveXiaojiatime;
	}

	// Property accessors

	public Short getXiaojiaId() {
		return this.xiaojiaId;
	}

	public void setXiaojiaId(Short xiaojiaId) {
		this.xiaojiaId = xiaojiaId;
	}

	public Leave1 getLeave1() {
		return this.leave1;
	}

	public void setLeave1(Leave1 leave1) {
		this.leave1 = leave1;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Timestamp getLeaveXiaojiatime() {
		return this.leaveXiaojiatime;
	}

	public void setLeaveXiaojiatime(Timestamp leaveXiaojiatime) {
		this.leaveXiaojiatime = leaveXiaojiatime;
	}

}