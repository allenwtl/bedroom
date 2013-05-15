package com.action.student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Classes;
import com.pojo.Students;
import com.pojo.User;
import com.serviceImp.ClassServiceImp;
import com.serviceImp.StudentsServiceImp;
import com.serviceImp.UserServiceImp;
import com.util.ExcelReader;
import com.util.MD5;


public class StudentExcelAction extends ActionSupport {
	private  ClassServiceImp classServiceImp;
	private  StudentsServiceImp  studentsServiceImp;
	private  UserServiceImp   userServiceImp;
	public void setUserServiceImp(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}

	public void setClassServiceImp(ClassServiceImp classServiceImp) {
		this.classServiceImp = classServiceImp;
	}

	public void setStudentsServiceImp(StudentsServiceImp studentsServiceImp) {
		this.studentsServiceImp = studentsServiceImp;
	}


	private  File   upload ;
	private  String uploadFileName;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
	public  String  insertData(){
		ExcelReader  excelReader = new ExcelReader();
		List<ArrayList<String>>  data = excelReader.read(upload, uploadFileName);
		for(int i=1; i<data.size();i++){
			ArrayList<String> arrayList = (ArrayList<String>)data.get(i);
			String  studentNumber = arrayList.get(0);
			Students student = new Students();
			student.setStudentsNumber(studentNumber);
			student.setStudentsName(arrayList.get(1));
			if("男".equals(arrayList.get(2).toString()))
				student.setStudentsSex(Short.parseShort("1"));
			else student.setStudentsSex(Short.parseShort("0"));
			
			String  className = arrayList.get(3);
			Classes clazz = classServiceImp.getClasses(className+"班");
			student.setClassNumber(clazz.getClassId());
			
			//设置学生的账号和密码
			User user2 = userServiceImp.getUserByNumber(studentNumber);
			if(user2==null){
				User user = new User();
				user.setUserNumber(studentNumber);
				user.setUserPassword(MD5.toMD5(studentNumber));
				userServiceImp.addUser(user);
			}
			
			Students student2 = studentsServiceImp.getStudentByNumber(studentNumber);
			if(student2==null)
				studentsServiceImp.saveDataFromExcel(student);
		}
		return null;
	}	
	
	
}
