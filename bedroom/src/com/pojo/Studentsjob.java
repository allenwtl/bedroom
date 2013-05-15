package com.pojo;

import java.sql.Timestamp;

/**
 * Studentsjob entity. @author MyEclipse Persistence Tools
 */

public class Studentsjob implements java.io.Serializable {

	// Fields

	private Short studentsjobId;
	private Students students;
	private Job job;
	private Timestamp studentsjobBegintime;
	private Timestamp studentsjobEndtime;

	// Constructors

	/** default constructor */
	public Studentsjob() {
	}

	/** minimal constructor */
	public Studentsjob(Students students, Job job) {
		this.students = students;
		this.job = job;
	}

	/** full constructor */
	public Studentsjob(Students students, Job job,
			Timestamp studentsjobBegintime, Timestamp studentsjobEndtime) {
		this.students = students;
		this.job = job;
		this.studentsjobBegintime = studentsjobBegintime;
		this.studentsjobEndtime = studentsjobEndtime;
	}

	// Property accessors

	public Short getStudentsjobId() {
		return this.studentsjobId;
	}

	public void setStudentsjobId(Short studentsjobId) {
		this.studentsjobId = studentsjobId;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Timestamp getStudentsjobBegintime() {
		return this.studentsjobBegintime;
	}

	public void setStudentsjobBegintime(Timestamp studentsjobBegintime) {
		this.studentsjobBegintime = studentsjobBegintime;
	}

	public Timestamp getStudentsjobEndtime() {
		return this.studentsjobEndtime;
	}

	public void setStudentsjobEndtime(Timestamp studentsjobEndtime) {
		this.studentsjobEndtime = studentsjobEndtime;
	}

}