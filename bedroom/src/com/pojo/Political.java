package com.pojo;

/**
 * Political entity. @author MyEclipse Persistence Tools
 */

public class Political implements java.io.Serializable {

	// Fields

	private Integer politicalId;
	private String politicalNumber;
	private String politicalName;

	// Constructors

	/** default constructor */
	public Political() {
	}

	/** full constructor */
	public Political(String politicalNumber, String politicalName) {
		this.politicalNumber = politicalNumber;
		this.politicalName = politicalName;
	}

	// Property accessors

	public Integer getPoliticalId() {
		return this.politicalId;
	}

	public void setPoliticalId(Integer politicalId) {
		this.politicalId = politicalId;
	}

	public String getPoliticalNumber() {
		return this.politicalNumber;
	}

	public void setPoliticalNumber(String politicalNumber) {
		this.politicalNumber = politicalNumber;
	}

	public String getPoliticalName() {
		return this.politicalName;
	}

	public void setPoliticalName(String politicalName) {
		this.politicalName = politicalName;
	}

}