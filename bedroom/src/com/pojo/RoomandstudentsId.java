package com.pojo;

import java.sql.Timestamp;

/**
 * RoomandstudentsId entity. @author MyEclipse Persistence Tools
 */

public class RoomandstudentsId implements java.io.Serializable {

	// Fields

	private String roomNumber;
	private Byte roomSex;
	private Short classId;
	private Short studentsId;
	private String studentsName;
	private Short classNumber;
	private Timestamp studentsInroomtime;
	private Short studentsBed;
	private Byte studentsSex;
	private Short roomId;
	private String studentsNumber;

	// Constructors

	/** default constructor */
	public RoomandstudentsId() {
	}

	/** minimal constructor */
	public RoomandstudentsId(String roomNumber, Byte roomSex, Short classId,
			Short studentsId, String studentsName, Short classNumber,
			Byte studentsSex, Short roomId, String studentsNumber) {
		this.roomNumber = roomNumber;
		this.roomSex = roomSex;
		this.classId = classId;
		this.studentsId = studentsId;
		this.studentsName = studentsName;
		this.classNumber = classNumber;
		this.studentsSex = studentsSex;
		this.roomId = roomId;
		this.studentsNumber = studentsNumber;
	}

	/** full constructor */
	public RoomandstudentsId(String roomNumber, Byte roomSex, Short classId,
			Short studentsId, String studentsName, Short classNumber,
			Timestamp studentsInroomtime, Short studentsBed, Byte studentsSex,
			Short roomId, String studentsNumber) {
		this.roomNumber = roomNumber;
		this.roomSex = roomSex;
		this.classId = classId;
		this.studentsId = studentsId;
		this.studentsName = studentsName;
		this.classNumber = classNumber;
		this.studentsInroomtime = studentsInroomtime;
		this.studentsBed = studentsBed;
		this.studentsSex = studentsSex;
		this.roomId = roomId;
		this.studentsNumber = studentsNumber;
	}

	// Property accessors

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Byte getRoomSex() {
		return this.roomSex;
	}

	public void setRoomSex(Byte roomSex) {
		this.roomSex = roomSex;
	}

	public Short getClassId() {
		return this.classId;
	}

	public void setClassId(Short classId) {
		this.classId = classId;
	}

	public Short getStudentsId() {
		return this.studentsId;
	}

	public void setStudentsId(Short studentsId) {
		this.studentsId = studentsId;
	}

	public String getStudentsName() {
		return this.studentsName;
	}

	public void setStudentsName(String studentsName) {
		this.studentsName = studentsName;
	}

	public Short getClassNumber() {
		return this.classNumber;
	}

	public void setClassNumber(Short classNumber) {
		this.classNumber = classNumber;
	}

	public Timestamp getStudentsInroomtime() {
		return this.studentsInroomtime;
	}

	public void setStudentsInroomtime(Timestamp studentsInroomtime) {
		this.studentsInroomtime = studentsInroomtime;
	}

	public Short getStudentsBed() {
		return this.studentsBed;
	}

	public void setStudentsBed(Short studentsBed) {
		this.studentsBed = studentsBed;
	}

	public Byte getStudentsSex() {
		return this.studentsSex;
	}

	public void setStudentsSex(Byte studentsSex) {
		this.studentsSex = studentsSex;
	}

	public Short getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Short roomId) {
		this.roomId = roomId;
	}

	public String getStudentsNumber() {
		return this.studentsNumber;
	}

	public void setStudentsNumber(String studentsNumber) {
		this.studentsNumber = studentsNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoomandstudentsId))
			return false;
		RoomandstudentsId castOther = (RoomandstudentsId) other;

		return ((this.getRoomNumber() == castOther.getRoomNumber()) || (this
				.getRoomNumber() != null
				&& castOther.getRoomNumber() != null && this.getRoomNumber()
				.equals(castOther.getRoomNumber())))
				&& ((this.getRoomSex() == castOther.getRoomSex()) || (this
						.getRoomSex() != null
						&& castOther.getRoomSex() != null && this.getRoomSex()
						.equals(castOther.getRoomSex())))
				&& ((this.getClassId() == castOther.getClassId()) || (this
						.getClassId() != null
						&& castOther.getClassId() != null && this.getClassId()
						.equals(castOther.getClassId())))
				&& ((this.getStudentsId() == castOther.getStudentsId()) || (this
						.getStudentsId() != null
						&& castOther.getStudentsId() != null && this
						.getStudentsId().equals(castOther.getStudentsId())))
				&& ((this.getStudentsName() == castOther.getStudentsName()) || (this
						.getStudentsName() != null
						&& castOther.getStudentsName() != null && this
						.getStudentsName().equals(castOther.getStudentsName())))
				&& ((this.getClassNumber() == castOther.getClassNumber()) || (this
						.getClassNumber() != null
						&& castOther.getClassNumber() != null && this
						.getClassNumber().equals(castOther.getClassNumber())))
				&& ((this.getStudentsInroomtime() == castOther
						.getStudentsInroomtime()) || (this
						.getStudentsInroomtime() != null
						&& castOther.getStudentsInroomtime() != null && this
						.getStudentsInroomtime().equals(
								castOther.getStudentsInroomtime())))
				&& ((this.getStudentsBed() == castOther.getStudentsBed()) || (this
						.getStudentsBed() != null
						&& castOther.getStudentsBed() != null && this
						.getStudentsBed().equals(castOther.getStudentsBed())))
				&& ((this.getStudentsSex() == castOther.getStudentsSex()) || (this
						.getStudentsSex() != null
						&& castOther.getStudentsSex() != null && this
						.getStudentsSex().equals(castOther.getStudentsSex())))
				&& ((this.getRoomId() == castOther.getRoomId()) || (this
						.getRoomId() != null
						&& castOther.getRoomId() != null && this.getRoomId()
						.equals(castOther.getRoomId())))
				&& ((this.getStudentsNumber() == castOther.getStudentsNumber()) || (this
						.getStudentsNumber() != null
						&& castOther.getStudentsNumber() != null && this
						.getStudentsNumber().equals(
								castOther.getStudentsNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getRoomNumber() == null ? 0 : this.getRoomNumber()
						.hashCode());
		result = 37 * result
				+ (getRoomSex() == null ? 0 : this.getRoomSex().hashCode());
		result = 37 * result
				+ (getClassId() == null ? 0 : this.getClassId().hashCode());
		result = 37
				* result
				+ (getStudentsId() == null ? 0 : this.getStudentsId()
						.hashCode());
		result = 37
				* result
				+ (getStudentsName() == null ? 0 : this.getStudentsName()
						.hashCode());
		result = 37
				* result
				+ (getClassNumber() == null ? 0 : this.getClassNumber()
						.hashCode());
		result = 37
				* result
				+ (getStudentsInroomtime() == null ? 0 : this
						.getStudentsInroomtime().hashCode());
		result = 37
				* result
				+ (getStudentsBed() == null ? 0 : this.getStudentsBed()
						.hashCode());
		result = 37
				* result
				+ (getStudentsSex() == null ? 0 : this.getStudentsSex()
						.hashCode());
		result = 37 * result
				+ (getRoomId() == null ? 0 : this.getRoomId().hashCode());
		result = 37
				* result
				+ (getStudentsNumber() == null ? 0 : this.getStudentsNumber()
						.hashCode());
		return result;
	}

}