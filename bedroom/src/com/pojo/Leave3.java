package com.pojo;

import java.sql.Timestamp;

/**
 * Leave3 entity. @author MyEclipse Persistence Tools
 */

public class Leave3 implements java.io.Serializable {

	// Fields

	private Short leave3Id;
	private Teacher teacherByTeacherId1;
	private Teacher teacherByTeacherId2;
	private Leave2 leave2;
	private Timestamp leaveStudentstime;
	private Timestamp leaveLeadertime;
	private String teacher1Reason;
	private String teacher1Yijian;
	private String teacher2Reason;
	private String teacher2Yijian;

	// Constructors

	/** default constructor */
	public Leave3() {
	}

	/** minimal constructor */
	public Leave3(Teacher teacherByTeacherId1, Teacher teacherByTeacherId2,
			Leave2 leave2, String teacher1Reason, String teacher1Yijian,
			String teacher2Reason, String teacher2Yijian) {
		this.teacherByTeacherId1 = teacherByTeacherId1;
		this.teacherByTeacherId2 = teacherByTeacherId2;
		this.leave2 = leave2;
		this.teacher1Reason = teacher1Reason;
		this.teacher1Yijian = teacher1Yijian;
		this.teacher2Reason = teacher2Reason;
		this.teacher2Yijian = teacher2Yijian;
	}

	/** full constructor */
	public Leave3(Teacher teacherByTeacherId1, Teacher teacherByTeacherId2,
			Leave2 leave2, Timestamp leaveStudentstime,
			Timestamp leaveLeadertime, String teacher1Reason,
			String teacher1Yijian, String teacher2Reason, String teacher2Yijian) {
		this.teacherByTeacherId1 = teacherByTeacherId1;
		this.teacherByTeacherId2 = teacherByTeacherId2;
		this.leave2 = leave2;
		this.leaveStudentstime = leaveStudentstime;
		this.leaveLeadertime = leaveLeadertime;
		this.teacher1Reason = teacher1Reason;
		this.teacher1Yijian = teacher1Yijian;
		this.teacher2Reason = teacher2Reason;
		this.teacher2Yijian = teacher2Yijian;
	}

	// Property accessors

	public Short getLeave3Id() {
		return this.leave3Id;
	}

	public void setLeave3Id(Short leave3Id) {
		this.leave3Id = leave3Id;
	}

	public Teacher getTeacherByTeacherId1() {
		return this.teacherByTeacherId1;
	}

	public void setTeacherByTeacherId1(Teacher teacherByTeacherId1) {
		this.teacherByTeacherId1 = teacherByTeacherId1;
	}

	public Teacher getTeacherByTeacherId2() {
		return this.teacherByTeacherId2;
	}

	public void setTeacherByTeacherId2(Teacher teacherByTeacherId2) {
		this.teacherByTeacherId2 = teacherByTeacherId2;
	}

	public Leave2 getLeave2() {
		return this.leave2;
	}

	public void setLeave2(Leave2 leave2) {
		this.leave2 = leave2;
	}

	public Timestamp getLeaveStudentstime() {
		return this.leaveStudentstime;
	}

	public void setLeaveStudentstime(Timestamp leaveStudentstime) {
		this.leaveStudentstime = leaveStudentstime;
	}

	public Timestamp getLeaveLeadertime() {
		return this.leaveLeadertime;
	}

	public void setLeaveLeadertime(Timestamp leaveLeadertime) {
		this.leaveLeadertime = leaveLeadertime;
	}

	public String getTeacher1Reason() {
		return this.teacher1Reason;
	}

	public void setTeacher1Reason(String teacher1Reason) {
		this.teacher1Reason = teacher1Reason;
	}

	public String getTeacher1Yijian() {
		return this.teacher1Yijian;
	}

	public void setTeacher1Yijian(String teacher1Yijian) {
		this.teacher1Yijian = teacher1Yijian;
	}

	public String getTeacher2Reason() {
		return this.teacher2Reason;
	}

	public void setTeacher2Reason(String teacher2Reason) {
		this.teacher2Reason = teacher2Reason;
	}

	public String getTeacher2Yijian() {
		return this.teacher2Yijian;
	}

	public void setTeacher2Yijian(String teacher2Yijian) {
		this.teacher2Yijian = teacher2Yijian;
	}

}