package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Qinshi entity. @author MyEclipse Persistence Tools
 */

public class Qinshi implements java.io.Serializable {

	// Fields

	private Short qinshiId;
	private Integer qinshiCeng;
	private String qinshiAddress;
	private String qinshiCengrooms;
	private Set rooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Qinshi() {
	}

	/** full constructor */
	public Qinshi(Integer qinshiCeng, String qinshiAddress,
			String qinshiCengrooms, Set rooms) {
		this.qinshiCeng = qinshiCeng;
		this.qinshiAddress = qinshiAddress;
		this.qinshiCengrooms = qinshiCengrooms;
		this.rooms = rooms;
	}

	// Property accessors

	public Short getQinshiId() {
		return this.qinshiId;
	}

	public void setQinshiId(Short qinshiId) {
		this.qinshiId = qinshiId;
	}

	public Integer getQinshiCeng() {
		return this.qinshiCeng;
	}

	public void setQinshiCeng(Integer qinshiCeng) {
		this.qinshiCeng = qinshiCeng;
	}

	public String getQinshiAddress() {
		return this.qinshiAddress;
	}

	public void setQinshiAddress(String qinshiAddress) {
		this.qinshiAddress = qinshiAddress;
	}

	public String getQinshiCengrooms() {
		return this.qinshiCengrooms;
	}

	public void setQinshiCengrooms(String qinshiCengrooms) {
		this.qinshiCengrooms = qinshiCengrooms;
	}

	public Set getRooms() {
		return this.rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

}