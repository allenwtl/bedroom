package com.action.student;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import javassist.bytecode.stackmap.TypeData.ClassName;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Classes;
import com.serviceInterf.ClassServiceInterf;
import com.serviceInterf.KezhiServiceInterf;
import com.serviceInterf.MajorServiceInterf;

public class AddClassAction extends ActionSupport {
	private MajorServiceInterf majorServiceInterf;
	private KezhiServiceInterf kezhiServiceInterf;
	private ClassServiceInterf classServiceInterf;
	public void setClassServiceInterf(ClassServiceInterf classServiceInterf) {
		this.classServiceInterf = classServiceInterf;
	}
	public void setMajorServiceInterf(MajorServiceInterf majorServiceInterf) {
		this.majorServiceInterf = majorServiceInterf;
	}
	public void setKezhiServiceInterf(KezhiServiceInterf kezhiServiceInterf) {
		this.kezhiServiceInterf = kezhiServiceInterf;
	}


	private String major   ;
	private String year    ;
	private String kezhi   ;
	private String className;
	private String amount ;
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getKezhi() {
		return kezhi;
	}
	public void setKezhi(String kezhi) {
		this.kezhi = kezhi;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	public String execute() {
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Integer amount = Integer.parseInt(this.amount);
		for(int i=1; i<=amount; i++){
			Classes clazz = new Classes();
			clazz.setClassIntime(this.year+"级");
			clazz.setKezhi(kezhiServiceInterf.getKezhi(Short.parseShort(this.kezhi)));
			clazz.setMajor(majorServiceInterf.getMajor(Short.parseShort(this.major)));
			if(i<10){
				clazz.setClassName(this.className+this.year.substring(2,4)+"0"+i);
			}else {
				clazz.setClassName(this.className+this.year.substring(2,4)+i);
			}
			
			classServiceInterf.addClass(clazz);
		}
		
		response.setContentType("text/html; charset=utf-8");
		try {
			response.getWriter().print("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null ;
	}
	
	
}
