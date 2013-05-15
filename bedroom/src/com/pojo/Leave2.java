package com.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Leave2 entity. @author MyEclipse Persistence Tools
 */

public class Leave2 implements java.io.Serializable {

	// Fields

	private Short leave2Id;
	private Leave1 leave1;
	private Teacher teacher;
	private Timestamp leave2Time;
	private String leave2Reason;
	private String leave2Yijian;
	private Set leave3s = new HashSet(0);

	// Constructors

	/** default constructor */
	public Leave2() {
	}

	/** minimal constructor */
	public Leave2(Leave1 leave1, Teacher teacher, String leave2Reason,
			String leave2Yijian) {
		this.leave1 = leave1;
		this.teacher = teacher;
		this.leave2Reason = leave2Reason;
		this.leave2Yijian = leave2Yijian;
	}

	/** full constructor */
	public Leave2(Leave1 leave1, Teacher teacher, Timestamp leave2Time,
			String leave2Reason, String leave2Yijian, Set leave3s) {
		this.leave1 = leave1;
		this.teacher = teacher;
		this.leave2Time = leave2Time;
		this.leave2Reason = leave2Reason;
		this.leave2Yijian = leave2Yijian;
		this.leave3s = leave3s;
	}

	// Property accessors

	public Short getLeave2Id() {
		return this.leave2Id;
	}

	public void setLeave2Id(Short leave2Id) {
		this.leave2Id = leave2Id;
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

	public Timestamp getLeave2Time() {
		return this.leave2Time;
	}

	public void setLeave2Time(Timestamp leave2Time) {
		this.leave2Time = leave2Time;
	}

	public String getLeave2Reason() {
		return this.leave2Reason;
	}

	public void setLeave2Reason(String leave2Reason) {
		this.leave2Reason = leave2Reason;
	}

	public String getLeave2Yijian() {
		return this.leave2Yijian;
	}

	public void setLeave2Yijian(String leave2Yijian) {
		this.leave2Yijian = leave2Yijian;
	}

	public Set getLeave3s() {
		return this.leave3s;
	}

	public void setLeave3s(Set leave3s) {
		this.leave3s = leave3s;
	}

}