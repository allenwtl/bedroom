package com.serviceImp;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daoImp.StudentsDaoImp;
import com.pojo.Homenumber;
import com.pojo.Socialrelations;
import com.pojo.Students;
import com.serviceInterf.StudentsServiceInterf;

public class StudentsServiceImp implements StudentsServiceInterf {
	

	private StudentsDaoImp studentsDaoImp;
	public void setStudentsDaoImp(StudentsDaoImp studentsDaoImp) {
		this.studentsDaoImp = studentsDaoImp;
	}

	public int getNumberOfStudents() {
		studentsDaoImp.getNumberOfStudents();
		return 0;
	}
	
	public Students getAllStudentsById(String id) {
		return studentsDaoImp.getStuById(id);
	}


@Override
	public List<HashMap> getStudentsByClass(String classId) {
		try{
			return studentsDaoImp.getStudentsByClass(classId);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("studentsDaoimp  35行");
			return null;
		}
	}

	
	@Override
	public List<Map<String, String>> getStuBySex(String classes, String sex) {
		try{
			return studentsDaoImp.getStuBySex(classes, sex);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("studentsServiceImp 47行");
			return null;
		}
	}
	
	
	//保存一条条家庭成员
	public void insert2Home(Homenumber homenumberPo) {
		studentsDaoImp.insert2Home(homenumberPo);
	}
	
	//通过学号查询学生
	public Students getStudentByNumber(String studentsNumber) {
		List<Students> stuList = new ArrayList<Students>();
		stuList = studentsDaoImp.getStuByNum(studentsNumber);
		if(stuList==null) return null;
		else return stuList.get(0);
	}
	


	public void updateStudent(Students students) {
		studentsDaoImp.updateStudent(students);
	}
	
	
	public void saveRelation(Socialrelations socialrelations){
		studentsDaoImp.saveRelation(socialrelations);
	}

	@Override
	public void saveDataFromExcel(Students students) {
		studentsDaoImp.saveDataFromExcel(students);
		
	}

	public void stuToRoom(List<String> studentsNumber, List<String> studentsBed, List<String> roomNumber) {
		try{
			studentsDaoImp.stuToRoom(studentsNumber,studentsBed,roomNumber);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("studentsServiceImp 94行");
		}
	}

	public List<Map<String, String>> addStuOfRoom(String classes, String sex) {
		try{
			return studentsDaoImp.addStuOfRoom(classes,sex);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("studentsserviceImp 102行");
			return null;
		}
	}


}
