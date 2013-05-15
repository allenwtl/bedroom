package com.serviceImp;

import com.daoImp.JobDaoImp;
import com.serviceInterf.JobServiceInterf;

public class JobServiceImp implements JobServiceInterf {

	private JobDaoImp jobDaoImp;

	public void setJobDaoImp(JobDaoImp jobDaoImp) {
		this.jobDaoImp = jobDaoImp;
	}
}
