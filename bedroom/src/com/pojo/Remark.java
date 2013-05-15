package com.pojo;

import java.sql.Timestamp;

/**
 * Remark entity. @author MyEclipse Persistence Tools
 */

public class Remark implements java.io.Serializable {

	// Fields

	private Short remarkId;
	private Students students;
	private Timestamp remarkTime;
	private String remarkReason;
	private String remarkBeizhu;

	// Constructors

	/** default constructor */
	public Remark() {
	}

	/** minimal constructor */
	public Remark(Students students) {
		this.students = students;
	}

	/** full constructor */
	public Remark(Students students, Timestamp remarkTime, String remarkReason,
			String remarkBeizhu) {
		this.students = students;
		this.remarkTime = remarkTime;
		this.remarkReason = remarkReason;
		this.remarkBeizhu = remarkBeizhu;
	}

	// Property accessors

	public Short getRemarkId() {
		return this.remarkId;
	}

	public void setRemarkId(Short remarkId) {
		this.remarkId = remarkId;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Timestamp getRemarkTime() {
		return this.remarkTime;
	}

	public void setRemarkTime(Timestamp remarkTime) {
		this.remarkTime = remarkTime;
	}

	public String getRemarkReason() {
		return this.remarkReason;
	}

	public void setRemarkReason(String remarkReason) {
		this.remarkReason = remarkReason;
	}

	public String getRemarkBeizhu() {
		return this.remarkBeizhu;
	}

	public void setRemarkBeizhu(String remarkBeizhu) {
		this.remarkBeizhu = remarkBeizhu;
	}

}