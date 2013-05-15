
package com.pojo;

import java.io.Serializable;

public class Kezhi implements Serializable {
	private Short kezhiId ; 
	private String kezhiType;
	private Short kezhiYear;
	
	public Short getKezhiId() {
		return kezhiId;
	}
	public void setKezhiId(Short kezhiId) {
		this.kezhiId = kezhiId;
	}
	public String getKezhiType() {
		return kezhiType;
	}
	public void setKezhiType(String kezhiType) {
		this.kezhiType = kezhiType;
	}
	public Short getKezhiYear() {
		return kezhiYear;
	}
	public void setKezhiYear(Short kezhiYear) {
		this.kezhiYear = kezhiYear;
	}
	
	
}

