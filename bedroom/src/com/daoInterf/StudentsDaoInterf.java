package com.daoInterf;

import com.pojo.Homenumber;
import com.pojo.Resume;
import com.pojo.Socialrelations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pojo.Roomandstudents;
import com.pojo.Students;

public interface StudentsDaoInterf {

	/**
	 * author:高华锋
	 * function:得到学生的总人数
	 * return:学生总人数
	 * parameter:无
	 * */
	public  int getNumberOfStudents();
	
	
	/**author:吴天伦
	 * function:添加homenumber表一条对象
	 * return:void
	 * parameter:homenumber 对象
	*/
	public abstract void insert2Home(Homenumber homenumber);
	
	/**author:吴天伦
	 * function:得到所有的学生
	 * return:得到所有的学生对象
	 * parameter:id 学号
	*/
	public Students getStuById(String id);
	
	
	/**
	 * author:高华锋
	 * function:根据班级得到该班级的学生  还有该班的宿舍  宿舍中人员的信息
	 * return:学生宿舍json对象
	 * parameter:班级的编号*/
	public List<HashMap> getStudentsByClass(String classId);
	
	
	
	/**
	 * author:高华锋
	 * function:根据性别 和其他信息得到学生  来给他们分配宿舍
	 * return 学生的信息
	 * parameter:性别
	 */
	public List<Map<String, String>> getStuBySex(String classes, String sex);
	
	/**保存影响学生的个人信息
	 * */
	public void saveRelation(Socialrelations socialrelations);
	
	
	/**
	 * author:高华锋
	 * function:将表单中的数据添加到数据库
	 * pararmeter:status 是删除还是添加 studentsNumber studentsBed*/
	public void stuToRoom( List<String> studentsNumber,
			List<String> studentsBed,List<String> roomNumber);
	
	
	/**
	 * author:高华锋
	 * function：将有床位的学生添加到roomtab中
	 * parameter：class_id,sex*/
	public List<Map<String, String>> addStuOfRoom(String classes, String sex);
}
