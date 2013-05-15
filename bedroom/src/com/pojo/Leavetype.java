package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Leavetype entity. @author MyEclipse Persistence Tools
 */

public class Leavetype implements java.io.Serializable {

	// Fields

	private Boolean leavetypeId;
	private String leavetypeDays;
	private Set leave1s = new HashSet(0);

	// Constructors

	/** default constructor */
	public Leavetype() {
	}

	/** full constructor */
	public Leavetype(String leavetypeDays, Set leave1s) {
		this.leavetypeDays = leavetypeDays;
		this.leave1s = leave1s;
	}

	// Property accessors

	public Boolean getLeavetypeId() {
		return this.leavetypeId;
	}

	public void setLeavetypeId(Boolean leavetypeId) {
		this.leavetypeId = leavetypeId;
	}

	public String getLeavetypeDays() {
		return this.leavetypeDays;
	}

	public void setLeavetypeDays(String leavetypeDays) {
		this.leavetypeDays = leavetypeDays;
	}

	public Set getLeave1s() {
		return this.leave1s;
	}

	public void setLeave1s(Set leave1s) {
		this.leave1s = leave1s;
	}

}