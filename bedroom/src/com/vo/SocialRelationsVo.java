package com.vo;

import java.io.Serializable;

public class SocialRelationsVo implements Serializable {
	private Integer  id;
	private String   relationTitle;
	private String   relationName;
	private String   relationPolitical;
	private String   relationUtil;
	private String   relationPhone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRelationTitle() {
		return relationTitle;
	}
	public void setRelationTitle(String relationTitle) {
		this.relationTitle = relationTitle;
	}
	public String getRelationName() {
		return relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	public String getRelationPolitical() {
		return relationPolitical;
	}
	public void setRelationPolitical(String relationPolitical) {
		this.relationPolitical = relationPolitical;
	}
	public String getRelationUtil() {
		return relationUtil;
	}
	public void setRelationUtil(String relationUtil) {
		this.relationUtil = relationUtil;
	}
	public String getRelationPhone() {
		return relationPhone;
	}
	public void setRelationPhone(String relationPhone) {
		this.relationPhone = relationPhone;
	}
	
	
	
	
}
