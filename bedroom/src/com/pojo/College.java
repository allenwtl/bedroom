package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * College entity. @author MyEclipse Persistence Tools
 */

public class College implements java.io.Serializable {

	// Fields

	private Short collegeId;
	private String collegeName;
	private Set teachers = new HashSet(0);
	private Set majors = new HashSet(0);

	// Constructors

	/** default constructor */
	public College() {
	}

	/** minimal constructor */
	public College(String collegeName) {
		this.collegeName = collegeName;
	}

	/** full constructor */
	public College(String collegeName, Set teachers, Set majors) {
		this.collegeName = collegeName;
		this.teachers = teachers;
		this.majors = majors;
	}

	// Property accessors

	public Short getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Short collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getMajors() {
		return this.majors;
	}

	public void setMajors(Set majors) {
		this.majors = majors;
	}

}