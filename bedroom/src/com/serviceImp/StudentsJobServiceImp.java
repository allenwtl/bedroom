package com.serviceImp;

import java.util.List;

import com.daoImp.StudentsJobDaoImp;
import com.pojo.Roomandstudents;
import com.serviceInterf.StudentsServiceInterf;
import com.serviceInterf.StudentsjobServiceInterf;

public class StudentsJobServiceImp implements StudentsjobServiceInterf {
	private StudentsJobDaoImp	studetnsjobDaoImp;
	

	public void setStudetnsjobDaoImp(StudentsJobDaoImp studetnsjobDaoImp) {
		this.studetnsjobDaoImp = studetnsjobDaoImp;
	}



	public int getNumberOfStudents() {
		// TODO Auto-generated method stub
		return 0;
	}


}
