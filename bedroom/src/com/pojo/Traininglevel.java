package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Traininglevel entity. @author MyEclipse Persistence Tools
 */

public class Traininglevel implements java.io.Serializable {

	// Fields

	private Short id;
	private Integer traininglevelId;
	private String traininglevelName;
	private Set majors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Traininglevel() {
	}

	/** full constructor */
	public Traininglevel(Integer traininglevelId, String traininglevelName,
			Set majors) {
		this.traininglevelId = traininglevelId;
		this.traininglevelName = traininglevelName;
		this.majors = majors;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Integer getTraininglevelId() {
		return this.traininglevelId;
	}

	public void setTraininglevelId(Integer traininglevelId) {
		this.traininglevelId = traininglevelId;
	}

	public String getTraininglevelName() {
		return this.traininglevelName;
	}

	public void setTraininglevelName(String traininglevelName) {
		this.traininglevelName = traininglevelName;
	}

	public Set getMajors() {
		return this.majors;
	}

	public void setMajors(Set majors) {
		this.majors = majors;
	}

}