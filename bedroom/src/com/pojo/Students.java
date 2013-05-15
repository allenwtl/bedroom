package com.pojo;

import java.sql.Timestamp;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */

public class Students implements java.io.Serializable {

	// Fields
	private String studentsNumber;
	private Integer studentsId;
	private Short roomId;

	private Short classNumber;
	private String studentsPinyin;
	private Timestamp studentsInroomtime;
	private String studentsName;
	private Short studentsPolitics;
	private Timestamp studentsBirthday;
	private Short studentsSex;
	private String studentsIdcard;
	private String studentsNation;
	private String studentsNativeplace;
	private String studentsAddress;
	private String studentsNative;
	private String studentsPostcode;
	private Short studentsType;
	private String studentsPhone;
	private Timestamp studentsInschool;
	private String studentsQq;
	private String studentsEmail;
	private String studentsImage;
	private String studentsBed;

	// Property accessors

	public Integer getStudentsId() {
		return this.studentsId;
	}

	public String getStudentsBed() {
		return studentsBed;
	}

	public void setStudentsBed(String studentsBed) {
		this.studentsBed = studentsBed;
	}

	public void setStudentsId(Integer studentsId) {
		this.studentsId = studentsId;
	}

	public Short getRoomId() {
		return roomId;
	}

	public void setRoomId(Short roomId) {
		this.roomId = roomId;
	}

	public Short getClassNumber() {
		return this.classNumber;
	}

	public void setClassNumber(Short classNumber) {
		this.classNumber = classNumber;
	}

	public String getStudentsPinyin() {
		return this.studentsPinyin;
	}

	public void setStudentsPinyin(String studentsPinyin) {
		this.studentsPinyin = studentsPinyin;
	}

	public Timestamp getStudentsInroomtime() {
		return this.studentsInroomtime;
	}

	public void setStudentsInroomtime(Timestamp studentsInroomtime) {
		this.studentsInroomtime = studentsInroomtime;
	}

	public String getStudentsName() {
		return this.studentsName;
	}

	public void setStudentsName(String studentsName) {
		this.studentsName = studentsName;
	}

	public Short getStudentsPolitics() {
		return this.studentsPolitics;
	}

	public void setStudentsPolitics(Short studentsPolitics) {
		this.studentsPolitics = studentsPolitics;
	}

	public Timestamp getStudentsBirthday() {
		return this.studentsBirthday;
	}

	public void setStudentsBirthday(Timestamp studentsBirthday) {
		this.studentsBirthday = studentsBirthday;
	}

	public Short getStudentsSex() {
		return this.studentsSex;
	}

	public void setStudentsSex(Short studentsSex) {
		this.studentsSex = studentsSex;
	}

	public String getStudentsIdcard() {
		return this.studentsIdcard;
	}

	public void setStudentsIdcard(String studentsIdcard) {
		this.studentsIdcard = studentsIdcard;
	}

	public String getStudentsNation() {
		return this.studentsNation;
	}

	public void setStudentsNation(String studentsNation) {
		this.studentsNation = studentsNation;
	}

	public String getStudentsNativeplace() {
		return this.studentsNativeplace;
	}

	public void setStudentsNativeplace(String studentsNativeplace) {
		this.studentsNativeplace = studentsNativeplace;
	}

	public String getStudentsAddress() {
		return this.studentsAddress;
	}

	public void setStudentsAddress(String studentsAddress) {
		this.studentsAddress = studentsAddress;
	}

	public String getStudentsNative() {
		return this.studentsNative;
	}

	public void setStudentsNative(String studentsNative) {
		this.studentsNative = studentsNative;
	}

	public String getStudentsPostcode() {
		return this.studentsPostcode;
	}

	public void setStudentsPostcode(String studentsPostcode) {
		this.studentsPostcode = studentsPostcode;
	}

	public Short getStudentsType() {
		return this.studentsType;
	}

	public void setStudentsType(Short studentsType) {
		this.studentsType = studentsType;
	}

	public String getStudentsPhone() {
		return this.studentsPhone;
	}

	public void setStudentsPhone(String studentsPhone) {
		this.studentsPhone = studentsPhone;
	}

	public Timestamp getStudentsInschool() {
		return this.studentsInschool;
	}

	public void setStudentsInschool(Timestamp studentsInschool) {
		this.studentsInschool = studentsInschool;
	}

	public String getStudentsQq() {
		return this.studentsQq;
	}

	public void setStudentsQq(String studentsQq) {
		this.studentsQq = studentsQq;
	}

	public String getStudentsEmail() {
		return this.studentsEmail;
	}

	public void setStudentsEmail(String studentsEmail) {
		this.studentsEmail = studentsEmail;
	}

	public String getStudentsImage() {
		return this.studentsImage;
	}

	public void setStudentsImage(String studentsImage) {
		this.studentsImage = studentsImage;
	}

	public String getStudentsNumber() {
		return studentsNumber;
	}

	public void setStudentsNumber(String studentsNumber) {
		this.studentsNumber = studentsNumber;
	}

}