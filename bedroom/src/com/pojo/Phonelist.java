package com.pojo;

/**
 * Phonelist entity. @author MyEclipse Persistence Tools
 */

public class Phonelist implements java.io.Serializable {

	// Fields

	private Short phonelistId;
	private Students students;
	private String phonelistNumber;

	// Constructors

	/** default constructor */
	public Phonelist() {
	}

	/** full constructor */
	public Phonelist(Students students, String phonelistNumber) {
		this.students = students;
		this.phonelistNumber = phonelistNumber;
	}

	// Property accessors

	public Short getPhonelistId() {
		return this.phonelistId;
	}

	public void setPhonelistId(Short phonelistId) {
		this.phonelistId = phonelistId;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public String getPhonelistNumber() {
		return this.phonelistNumber;
	}

	public void setPhonelistNumber(String phonelistNumber) {
		this.phonelistNumber = phonelistNumber;
	}

}