package com.pojo;

import java.io.Serializable;

public class Nation implements Serializable {
	private   Short   nationId ;
	private   String  nationNumber;
	private   String  nationName;
	public Short getNationId() {
		return nationId;
	}
	public void setNationId(Short nationId) {
		this.nationId = nationId;
	}
	public String getNationNumber() {
		return nationNumber;
	}
	public void setNationNumber(String nationNumber) {
		this.nationNumber = nationNumber;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	
	
	
}
