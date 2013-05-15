package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Job entity. @author MyEclipse Persistence Tools
 */

public class Job implements java.io.Serializable {

	// Fields

	private Short jobId;
	private String jobName;
	private Set teachers = new HashSet(0);
	private Set studentsjobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Job() {
	}

	/** minimal constructor */
	public Job(String jobName) {
		this.jobName = jobName;
	}

	/** full constructor */
	public Job(String jobName, Set teachers, Set studentsjobs) {
		this.jobName = jobName;
		this.teachers = teachers;
		this.studentsjobs = studentsjobs;
	}

	// Property accessors

	public Short getJobId() {
		return this.jobId;
	}

	public void setJobId(Short jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getStudentsjobs() {
		return this.studentsjobs;
	}

	public void setStudentsjobs(Set studentsjobs) {
		this.studentsjobs = studentsjobs;
	}

}