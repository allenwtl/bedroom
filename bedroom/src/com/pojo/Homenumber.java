package com.pojo;

/**
 * Homenumber entity. @author MyEclipse Persistence Tools
 */

public class Homenumber implements java.io.Serializable {

	// Fields

	private Short homenumberId;
	private Students students;
	private String homenumberTitle;
	private String homenumberName;
	private Short homenumberPolitical;
	private String homenumberUnit;
	private String homenumberPhone;

	// Constructors

	/** default constructor */
	public Homenumber() {
	}

	/** full constructor */
	public Homenumber(Students students, String homenumberTitle,
			String homenumberName, Short homenumberPolitical,
			String homenumberUnit, String homenumberPhone
			) {
		this.students = students;
		this.homenumberTitle = homenumberTitle;
		this.homenumberName = homenumberName;
		this.homenumberPolitical = homenumberPolitical;
		this.homenumberUnit = homenumberUnit;
		this.homenumberPhone = homenumberPhone;
		
	}

	// Property accessors

	public Short getHomenumberId() {
		return this.homenumberId;
	}

	public void setHomenumberId(Short homenumberId) {
		this.homenumberId = homenumberId;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public String getHomenumberTitle() {
		return this.homenumberTitle;
	}

	public void setHomenumberTitle(String homenumberTitle) {
		this.homenumberTitle = homenumberTitle;
	}

	public String getHomenumberName() {
		return this.homenumberName;
	}

	public void setHomenumberName(String homenumberName) {
		this.homenumberName = homenumberName;
	}

	public Short getHomenumberPolitical() {
		return this.homenumberPolitical;
	}

	public void setHomenumberPolitical(Short homenumberPolitical) {
		this.homenumberPolitical = homenumberPolitical;
	}

	public String getHomenumberUnit() {
		return this.homenumberUnit;
	}

	public void setHomenumberUnit(String homenumberUnit) {
		this.homenumberUnit = homenumberUnit;
	}

	public String getHomenumberPhone() {
		return this.homenumberPhone;
	}

	public void setHomenumberPhone(String homenumberPhone) {
		this.homenumberPhone = homenumberPhone;
	}

}