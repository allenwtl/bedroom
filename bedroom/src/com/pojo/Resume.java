package com.pojo;

import java.sql.Timestamp;

/**
 * Resume entity. @author MyEclipse Persistence Tools
 */

public class Resume implements java.io.Serializable {

	// Fields

	private Short resumeId;
	private Integer studentsId;
	private Timestamp resumeBegintime;
	private Timestamp resumeEndtime;
	private String resumeLean;
	private String resumePerson;


	// Property accessors

	public Short getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Short resumeId) {
		this.resumeId = resumeId;
	}


	public Timestamp getResumeBegintime() {
		return this.resumeBegintime;
	}

	public void setResumeBegintime(Timestamp resumeBegintime) {
		this.resumeBegintime = resumeBegintime;
	}

	public Timestamp getResumeEndtime() {
		return this.resumeEndtime;
	}

	public void setResumeEndtime(Timestamp resumeEndtime) {
		this.resumeEndtime = resumeEndtime;
	}

	public String getResumeLean() {
		return this.resumeLean;
	}

	public void setResumeLean(String resumeLean) {
		this.resumeLean = resumeLean;
	}

	public String getResumePerson() {
		return resumePerson;
	}

	public void setResumePerson(String resumePerson) {
		this.resumePerson = resumePerson;
	}

	public Integer getStudentsId() {
		return studentsId;
	}

	public void setStudentsId(Integer studentsId) {
		this.studentsId = studentsId;
	}

	
}