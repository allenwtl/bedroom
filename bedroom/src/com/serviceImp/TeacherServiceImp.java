package com.serviceImp;

import com.daoImp.TeacherDaoImp;
import com.serviceInterf.TeacherServiceInterf;

public class TeacherServiceImp implements TeacherServiceInterf {

	private TeacherDaoImp teacherDaoImp;

	public void setTeacherDaoImp(TeacherDaoImp teacherDaoImp) {
		this.teacherDaoImp = teacherDaoImp;
	}
}
