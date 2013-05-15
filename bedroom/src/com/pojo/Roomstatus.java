package com.pojo;

/**
 * Roomstatus entity. @author MyEclipse Persistence Tools
 */

public class Roomstatus implements java.io.Serializable {

	// Fields

	private RoomstatusId id;

	// Constructors

	/** default constructor */
	public Roomstatus() {
	}

	/** full constructor */
	public Roomstatus(RoomstatusId id) {
		this.id = id;
	}

	// Property accessors

	public RoomstatusId getId() {
		return this.id;
	}

	public void setId(RoomstatusId id) {
		this.id = id;
	}

}