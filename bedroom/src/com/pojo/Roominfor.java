package com.pojo;

/**
 * Roominfor entity. @author MyEclipse Persistence Tools
 */

public class Roominfor implements java.io.Serializable {

	// Fields

	private RoominforId id;

	// Constructors

	/** default constructor */
	public Roominfor() {
	}

	/** full constructor */
	public Roominfor(RoominforId id) {
		this.id = id;
	}

	// Property accessors

	public RoominforId getId() {
		return this.id;
	}

	public void setId(RoominforId id) {
		this.id = id;
	}

}