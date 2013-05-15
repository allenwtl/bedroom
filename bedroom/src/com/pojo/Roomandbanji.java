package com.pojo;

/**
 * Roomandbanji entity. @author MyEclipse Persistence Tools
 */

public class Roomandbanji implements java.io.Serializable {

	// Fields

	private Short roomandbanjiId;
	private Classes classes;
	private Room room;
	private String bed;

	// Constructors

	/** default constructor */
	public Roomandbanji() {
	}

	/** minimal constructor */
	public Roomandbanji(Classes classes, Room room) {
		this.classes = classes;
		this.room = room;
	}

	/** full constructor */
	public Roomandbanji(Classes classes, Room room, String bed) {
		this.classes = classes;
		this.room = room;
		this.bed = bed;
	}

	// Property accessors

	public Short getRoomandbanjiId() {
		return this.roomandbanjiId;
	}

	public void setRoomandbanjiId(Short roomandbanjiId) {
		this.roomandbanjiId = roomandbanjiId;
	}

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getBed() {
		return this.bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

}