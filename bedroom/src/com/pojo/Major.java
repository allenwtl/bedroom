package com.pojo;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	private Short majorId;
	private Short collegeId;
	private String majorName;
	public Short getMajorId() {
		return majorId;
	}
	public void setMajorId(Short majorId) {
		this.majorId = majorId;
	}
	public Short getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Short collegeId) {
		this.collegeId = collegeId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
}