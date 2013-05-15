package com.serviceImp;

import com.daoImp.ResumeDaoImp;
import com.pojo.Resume;
import com.serviceInterf.ResumeServiceInterf;

public class ResumeServiceImp implements ResumeServiceInterf {

	private ResumeDaoImp resumeDaoImp;

	public void setResumeDaoImp(ResumeDaoImp resumeDaoImp) {
		this.resumeDaoImp = resumeDaoImp;
	}
	
	public void save(Resume resume){
		resumeDaoImp.save(resume);
	}


}
