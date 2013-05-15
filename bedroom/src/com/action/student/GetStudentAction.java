package com.action.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Classes;
import com.pojo.Kezhi;
import com.pojo.Students;
import com.serviceImp.ClassServiceImp;
import com.serviceImp.KezhiServiceImp;
import com.serviceImp.StudentsServiceImp;

public class GetStudentAction extends ActionSupport {
	private StudentsServiceImp studentsServiceImp;
	private ClassServiceImp    classServiceImp;
	private KezhiServiceImp  kezhiServiceImp;
	public void setKezhiServiceImp(KezhiServiceImp kezhiServiceImp) {
		this.kezhiServiceImp = kezhiServiceImp;
	}

	public void setClassServiceImp(ClassServiceImp classServiceImp) {
		this.classServiceImp = classServiceImp;
	}

	public void setStudentsServiceImp(StudentsServiceImp studentsServiceImp) {
		this.studentsServiceImp = studentsServiceImp;
	}
	
	
	public String getOneStu() {
		HttpServletRequest request  = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String  stu_num = request.getParameter("number");
		Students student = studentsServiceImp.getStudentByNumber(stu_num);
		Classes  clazz  =  classServiceImp.getClassName(student.getClassNumber());
		Kezhi    kezhi  =  kezhiServiceImp.getKezhi(clazz.getClassId());
		
		StringBuilder sb = new  StringBuilder();
		sb.append("{number:'").append(student.getStudentsNumber()).append("',");
		sb.append("name:'").append(student.getStudentsName()).append("',");
		sb.append("sex:'").append(student.getStudentsSex()).append("',");
		sb.append("className:'").append(clazz.getClassName()).append("',");
		sb.append("nianzhi:'").append(kezhi.getKezhiYear()).append("',");
		sb.append("ke:'").append(kezhi.getKezhiType()).append("'}");
		
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
}
