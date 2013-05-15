package com.pojo;

/**
 * Roomandstudents entity. @author MyEclipse Persistence Tools
 */

public class Roomandstudents implements java.io.Serializable {

	// Fields

	private RoomandstudentsId id;

	// Constructors

	/** default constructor */
	public Roomandstudents() {
	}

	/** full constructor */
	public Roomandstudents(RoomandstudentsId id) {
		this.id = id;
	}

	// Property accessors

	public RoomandstudentsId getId() {
		return this.id;
	}

	public void setId(RoomandstudentsId id) {
		this.id = id;
	}

}