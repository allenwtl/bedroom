package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Short classId;
	private Kezhi kezhi;
	private Major major;
	private String className;
	private String classIntime;
	private Set roomandbanjis = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** minimal constructor */
	public Classes(Major major, String className) {
		this.major = major;
		this.className = className;
	}

	/** full constructor */
	public Classes(Kezhi kezhi, Major major, String className,
			String classIntime, Set roomandbanjis) {
		this.kezhi = kezhi;
		this.major = major;
		this.className = className;
		this.classIntime = classIntime;
		this.roomandbanjis = roomandbanjis;
	}

	// Property accessors

	public Short getClassId() {
		return this.classId;
	}

	public void setClassId(Short classId) {
		this.classId = classId;
	}

	public Kezhi getKezhi() {
		return this.kezhi;
	}

	public void setKezhi(Kezhi kezhi) {
		this.kezhi = kezhi;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassIntime() {
		return this.classIntime;
	}

	public void setClassIntime(String classIntime) {
		this.classIntime = classIntime;
	}

	public Set getRoomandbanjis() {
		return this.roomandbanjis;
	}

	public void setRoomandbanjis(Set roomandbanjis) {
		this.roomandbanjis = roomandbanjis;
	}

}