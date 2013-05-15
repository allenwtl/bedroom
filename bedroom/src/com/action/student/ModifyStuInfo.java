package com.action.student;

import com.opensymphony.xwork2.ActionSupport;
import com.serviceImp.AddressInfoServiceImp;
import com.serviceImp.ClassServiceImp;
import com.serviceImp.HomenumberServiceImp;
import com.serviceImp.NationServiceImp;
import com.serviceImp.PoliticalServiceImp;
import com.serviceImp.ResumeServiceImp;
import com.serviceImp.StudentsServiceImp;

public class ModifyStuInfo extends ActionSupport {
	private AddressInfoServiceImp addressInfoServiceImp;
	private ClassServiceImp classServiceImp;
	private HomenumberServiceImp homenumberServiceImp;
	private NationServiceImp nationServiceImp;
	private PoliticalServiceImp politicalServiceImp;
	private ResumeServiceImp resumeServiceImp;
	private StudentsServiceImp studentsServiceImp;
	public void setAddressInfoServiceImp(AddressInfoServiceImp addressInfoServiceImp) {
		this.addressInfoServiceImp = addressInfoServiceImp;
	}
	public void setClassServiceImp(ClassServiceImp classServiceImp) {
		this.classServiceImp = classServiceImp;
	}
	public void setHomenumberServiceImp(HomenumberServiceImp homenumberServiceImp) {
		this.homenumberServiceImp = homenumberServiceImp;
	}
	public void setNationServiceImp(NationServiceImp nationServiceImp) {
		this.nationServiceImp = nationServiceImp;
	}
	public void setPoliticalServiceImp(PoliticalServiceImp politicalServiceImp) {
		this.politicalServiceImp = politicalServiceImp;
	}
	public void setResumeServiceImp(ResumeServiceImp resumeServiceImp) {
		this.resumeServiceImp = resumeServiceImp;
	}
	public void setStudentsServiceImp(StudentsServiceImp studentsServiceImp) {
		this.studentsServiceImp = studentsServiceImp;
	}
	
	
	
	
	
	
}
