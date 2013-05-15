package com.pojo;

/**
 * Socialrelations entity. @author MyEclipse Persistence Tools
 */

public class Socialrelations implements java.io.Serializable {

	// Fields

	private Integer id;
	private Students students;
	private String   relationTitle;
	private String   relationName;
	private String   relationPolitice;
	private String   relationUtil;
	private String   relationPhone; 
	
	
	public String getRelationTitle() {
		return relationTitle;
	}

	public void setRelationTitle(String relationTitle) {
		this.relationTitle = relationTitle;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRelationPolitice() {
		return relationPolitice;
	}

	public void setRelationPolitice(String relationPolitice) {
		this.relationPolitice = relationPolitice;
	}

	public String getRelationUtil() {
		return relationUtil;
	}

	public void setRelationUtil(String relationUtil) {
		this.relationUtil = relationUtil;
	}

	public String getRelationPhone() {
		return relationPhone;
	}

	public void setRelationPhone(String relationPhone) {
		this.relationPhone = relationPhone;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

}