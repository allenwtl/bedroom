package com.vo;

public class ResumeVo implements java.io.Serializable {

	private String resumeId;
	private String studentNumber;
	private String resumeBegintime;
	private String resumeEndtime;
	private String resumeLean;
	private String resumePerson;
	public String getResumePerson() {
		return resumePerson;
	}
	public void setResumePerson(String resumePerson) {
		this.resumePerson = resumePerson;
	}
	public String getResumeId() {
		return resumeId;
	}
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getResumeBegintime() {
		return resumeBegintime;
	}
	public void setResumeBegintime(String resumeBegintime) {
		this.resumeBegintime = resumeBegintime;
	}
	public String getResumeEndtime() {
		return resumeEndtime;
	}
	public void setResumeEndtime(String resumeEndtime) {
		this.resumeEndtime = resumeEndtime;
	}
	public String getResumeLean() {
		return resumeLean;
	}
	public void setResumeLean(String resumeLean) {
		this.resumeLean = resumeLean;
	}
	
	
	
}