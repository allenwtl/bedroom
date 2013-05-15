package com.serviceImp;

import java.util.List;

import com.daoImp.CollegeDaoImp;
import com.pojo.College;
import com.serviceInterf.CollegeServiceInterf;

public class CollegeServiceImp implements CollegeServiceInterf {

	private CollegeDaoImp collegeDaoImp;

	public void setCollegeDaoImp(CollegeDaoImp collegeDaoImp) {
		this.collegeDaoImp = collegeDaoImp;
	}


	public List<College> getAllCollege() {
		return collegeDaoImp.getAllCollege();
	}
}
