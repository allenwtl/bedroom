package com.pojo;

/**
 * Roomlist entity. @author MyEclipse Persistence Tools
 */

public class Roomlist implements java.io.Serializable {

	// Fields

	private Short roomlistId;
	private Students students;
	private Room room;
	private Boolean studentsBed;

	// Constructors

	/** default constructor */
	public Roomlist() {
	}

	/** full constructor */
	public Roomlist(Students students, Room room, Boolean studentsBed) {
		this.students = students;
		this.room = room;
		this.studentsBed = studentsBed;
	}

	// Property accessors

	public Short getRoomlistId() {
		return this.roomlistId;
	}

	public void setRoomlistId(Short roomlistId) {
		this.roomlistId = roomlistId;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Boolean getStudentsBed() {
		return this.studentsBed;
	}

	public void setStudentsBed(Boolean studentsBed) {
		this.studentsBed = studentsBed;
	}

}