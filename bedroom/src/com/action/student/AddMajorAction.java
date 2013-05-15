package com.action.student;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Major;
import com.serviceInterf.MajorServiceInterf;

public class AddMajorAction extends ActionSupport {
	private MajorServiceInterf majorServiceInterf;
	
	public void setMajorServiceInterf(MajorServiceInterf majorServiceInterf) {
		this.majorServiceInterf = majorServiceInterf;
	}


	private String[] college;
	private String[] majorName;
	public String[] getCollege() {
		return college;
	}
	public void setCollege(String[] college) {
		this.college = college;
	}

	public String[] getMajorName() {
		return majorName;
	}
	public void setMajorName(String[] majorName) {
		this.majorName = majorName;
	}
	
	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		try {
			for(int i=0;i<college.length;i++){
				Major   major = new Major();
				major.setCollegeId(Short.valueOf(college[i]));
				major.setMajorName(majorName[i]);
				majorServiceInterf.addMajor(major);
			}
			response.getWriter().print("插入成功!!");
		} catch (Exception e) {
			response.getWriter().print("插入失败!!");
		}
		return null;
	}
	
	
	
}
