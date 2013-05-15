package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Short teacherId;
	private College college;
	private User user;
	private Job job;
	private String teacherName;
	private String teacherPhone;
	private String teacherEmail;
	private Set leave3sForTeacherId2 = new HashSet(0);
	private Set leave1s = new HashSet(0);
	private Set xiaojias = new HashSet(0);
	private Set leave3sForTeacherId1 = new HashSet(0);
	private Set leave2s = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(College college, User user, Job job, String teacherName,
			String teacherPhone, String teacherEmail) {
		this.college = college;
		this.user = user;
		this.job = job;
		this.teacherName = teacherName;
		this.teacherPhone = teacherPhone;
		this.teacherEmail = teacherEmail;
	}

	/** full constructor */
	public Teacher(College college, User user, Job job, String teacherName,
			String teacherPhone, String teacherEmail, Set leave3sForTeacherId2,
			Set leave1s, Set xiaojias, Set leave3sForTeacherId1, Set leave2s) {
		this.college = college;
		this.user = user;
		this.job = job;
		this.teacherName = teacherName;
		this.teacherPhone = teacherPhone;
		this.teacherEmail = teacherEmail;
		this.leave3sForTeacherId2 = leave3sForTeacherId2;
		this.leave1s = leave1s;
		this.xiaojias = xiaojias;
		this.leave3sForTeacherId1 = leave3sForTeacherId1;
		this.leave2s = leave2s;
	}

	// Property accessors

	public Short getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Short teacherId) {
		this.teacherId = teacherId;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPhone() {
		return this.teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public String getTeacherEmail() {
		return this.teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public Set getLeave3sForTeacherId2() {
		return this.leave3sForTeacherId2;
	}

	public void setLeave3sForTeacherId2(Set leave3sForTeacherId2) {
		this.leave3sForTeacherId2 = leave3sForTeacherId2;
	}

	public Set getLeave1s() {
		return this.leave1s;
	}

	public void setLeave1s(Set leave1s) {
		this.leave1s = leave1s;
	}

	public Set getXiaojias() {
		return this.xiaojias;
	}

	public void setXiaojias(Set xiaojias) {
		this.xiaojias = xiaojias;
	}

	public Set getLeave3sForTeacherId1() {
		return this.leave3sForTeacherId1;
	}

	public void setLeave3sForTeacherId1(Set leave3sForTeacherId1) {
		this.leave3sForTeacherId1 = leave3sForTeacherId1;
	}

	public Set getLeave2s() {
		return this.leave2s;
	}

	public void setLeave2s(Set leave2s) {
		this.leave2s = leave2s;
	}

}