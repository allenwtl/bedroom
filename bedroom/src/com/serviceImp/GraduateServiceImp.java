package com.serviceImp;

import com.daoImp.GraduateDaoImp;
import com.serviceInterf.GraduateServiceInterf;

public class GraduateServiceImp implements GraduateServiceInterf {

	private GraduateDaoImp graduateDaoImp;

	public void setGraduateDaoImp(GraduateDaoImp graduateDaoImp) {
		this.graduateDaoImp = graduateDaoImp;
	}
}
