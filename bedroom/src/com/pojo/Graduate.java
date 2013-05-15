package com.pojo;

import java.sql.Timestamp;

/**
 * Graduate entity. @author MyEclipse Persistence Tools
 */

public class Graduate implements java.io.Serializable {

	// Fields

	private Short graduateId;
	private Students students;
	private Timestamp graduateTime;
	private String graduateBennumber;
	private String graduateXuenumber;
	private String graduateXuename;

	// Constructors

	/** default constructor */
	public Graduate() {
	}

	/** minimal constructor */
	public Graduate(Students students, String graduateBennumber,
			String graduateXuenumber) {
		this.students = students;
		this.graduateBennumber = graduateBennumber;
		this.graduateXuenumber = graduateXuenumber;
	}

	/** full constructor */
	public Graduate(Students students, Timestamp graduateTime,
			String graduateBennumber, String graduateXuenumber,
			String graduateXuename) {
		this.students = students;
		this.graduateTime = graduateTime;
		this.graduateBennumber = graduateBennumber;
		this.graduateXuenumber = graduateXuenumber;
		this.graduateXuename = graduateXuename;
	}

	// Property accessors

	public Short getGraduateId() {
		return this.graduateId;
	}

	public void setGraduateId(Short graduateId) {
		this.graduateId = graduateId;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Timestamp getGraduateTime() {
		return this.graduateTime;
	}

	public void setGraduateTime(Timestamp graduateTime) {
		this.graduateTime = graduateTime;
	}

	public String getGraduateBennumber() {
		return this.graduateBennumber;
	}

	public void setGraduateBennumber(String graduateBennumber) {
		this.graduateBennumber = graduateBennumber;
	}

	public String getGraduateXuenumber() {
		return this.graduateXuenumber;
	}

	public void setGraduateXuenumber(String graduateXuenumber) {
		this.graduateXuenumber = graduateXuenumber;
	}

	public String getGraduateXuename() {
		return this.graduateXuename;
	}

	public void setGraduateXuename(String graduateXuename) {
		this.graduateXuename = graduateXuename;
	}

}