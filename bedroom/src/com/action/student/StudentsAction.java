package com.action.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Classes;
import com.pojo.Nation;
import com.pojo.Political;
import com.pojo.Students;
import com.pojo.User;
import com.serviceImp.ClassServiceImp;
import com.serviceImp.NationServiceImp;
import com.serviceImp.PoliticalServiceImp;
import com.serviceImp.StudentsServiceImp;
import com.serviceImp.UserServiceImp;
import com.util.MD5;

public class StudentsAction extends ActionSupport {
	private  NationServiceImp nationServiceImp ;
	private  PoliticalServiceImp  politicalServiceImp;
	private  UserServiceImp  userServiceImp;
	private  StudentsServiceImp  studentsServiceImp;
	private  ClassServiceImp classServiceImp;
	public void setClassServiceImp(ClassServiceImp classServiceImp) {
		this.classServiceImp = classServiceImp;
	}

	public void setStudentsServiceImp(StudentsServiceImp studentsServiceImp) {
		this.studentsServiceImp = studentsServiceImp;
	}

	public void setUserServiceImp(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}

	public void setPoliticalServiceImp(PoliticalServiceImp politicalServiceImp) {
		this.politicalServiceImp = politicalServiceImp;
	}

	public void setNationServiceImp(NationServiceImp nationServiceImp) {
		this.nationServiceImp = nationServiceImp;
	}
	
	public String getAllNations(){
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Nation>   nationList =  nationServiceImp.getAllNations();
		StringBuilder   sb = new StringBuilder();
		int length = nationList.size();
		sb.append("[");
		for (int i = 0; i < length; i++) {
			if(i==length-1){
				sb.append("{id:'").append(nationList.get(i).getNationNumber());
				sb.append("',name:'").append(nationList.get(i).getNationName()).append("'}");
			}else {
				sb.append("{id:'").append(nationList.get(i).getNationNumber());
				sb.append("',name:'").append(nationList.get(i).getNationName()).append("'},");
			}
		}
		
		sb.append("]");
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getAllPoliticals(){
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Political>   pList = politicalServiceImp.getAllPoliticals();
		
		StringBuilder   sb = new StringBuilder();
		int length = pList.size();
		sb.append("[");
		for (int i = 0; i < length; i++) {
			if(i==length-1){
				sb.append("{id:'").append(pList.get(i).getPoliticalNumber());
				sb.append("',name:'").append(pList.get(i).getPoliticalName()).append("'}");
			}else {
				sb.append("{id:'").append(pList.get(i).getPoliticalNumber());
				sb.append("',name:'").append(pList.get(i).getPoliticalName()).append("'},");
			}
		}
		sb.append("]");
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	private String passw;
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}

	public String  modifyPass(){
		//得到学号
		
		
		//根据学号去查询
		User  user =  userServiceImp.getUserByNumber("10415400118");
		System.out.println(MD5.toMD5(passw));
		user.setUserPassword(MD5.toMD5(passw));
		userServiceImp.modifyUser(user);
		return null; 
	}
	
	
	public String checkStu(){
		HttpServletRequest  request  =  ServletActionContext.getRequest();
		HttpServletResponse response =  ServletActionContext.getResponse();
		String  number  =  request.getParameter("number");
		Students  student = studentsServiceImp.getStudentByNumber(number);
		response.setContentType("text/html;charset=utf-8");
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		try {
			if(student==null){
				response.getWriter().print("该学生不存在");
			}else {
				Classes   clazz  =  classServiceImp.getClassName(student.getClassNumber());
				sb.append("name:'").append(student.getStudentsName()).append("',");
				sb.append("sex:'").append(student.getStudentsSex()).append("',");
				sb.append("clazz:'").append(clazz.getClassName()).append("'}");
				response.getWriter().print(sb);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}
	
	
	
	
	
	
	
	
}
