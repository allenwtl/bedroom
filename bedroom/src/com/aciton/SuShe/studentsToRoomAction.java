package com.aciton.SuShe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.aciton.BaseAction;
import com.pojo.Classes;
import com.pojo.College;
import com.pojo.Major;
import com.serviceImp.ClassServiceImp;
import com.serviceImp.CollegeServiceImp;
import com.serviceImp.MajorServiceImp;
import com.serviceImp.RoomServiceImp;
import com.serviceImp.StudentsServiceImp;
import com.util.BaseInfor;

public class studentsToRoomAction extends BaseAction {

	private StudentsServiceImp studentsServieImp;
	private ClassServiceImp	classServiceImp;
	private CollegeServiceImp collegeServiceImp;
	private MajorServiceImp majorServiceImp;
	private RoomServiceImp roomServiceImp;
	

	public void setRoomServiceImp(RoomServiceImp roomServiceImp) {
		this.roomServiceImp = roomServiceImp;
	}

	public StudentsServiceImp getStudentsServieImp() {
		return studentsServieImp;
	}

	public void setStudentsServieImp(StudentsServiceImp studentsServieImp) {
		this.studentsServieImp = studentsServieImp;
	}

	public ClassServiceImp getClassServiceImp() {
		return classServiceImp;
	}

	public void setClassServiceImp(ClassServiceImp classServiceImp) {
		this.classServiceImp = classServiceImp;
	}

	public CollegeServiceImp getCollegeServiceImp() {
		return collegeServiceImp;
	}

	public void setCollegeServiceImp(CollegeServiceImp collegeServiceImp) {
		this.collegeServiceImp = collegeServiceImp;
	}

	public MajorServiceImp getMajorServiceImp() {
		return majorServiceImp;
	}

	public void setMajorServiceImp(MajorServiceImp majorServiceImp) {
		this.majorServiceImp = majorServiceImp;
	}
	




private String majorId;
private String nianfen;
private String collegeId;
private String sex;
private String classes;
private List<String> studentsNumber;
private List<String>  studentsBed;
private List<String> roomNumber;








public List<String> getRoomNumber() {
	return roomNumber;
}

public void setRoomNumber(List<String> roomNumber) {
	this.roomNumber = roomNumber;
}

public List<String> getStudentsNumber() {
	return studentsNumber;
}

public void setStudentsNumber(List<String> studentsNumber) {
	this.studentsNumber = studentsNumber;
}



public List<String> getStudentsBed() {
	return studentsBed;
}

public void setStudentsBed(List<String> studentsBed) {
	this.studentsBed = studentsBed;
}

public String getClasses() {
	return classes;
}

public void setClasses(String classes) {
	this.classes = classes;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public String getCollegeId() {
	return collegeId;
}

public void setCollegeId(String collegeId) {
	this.collegeId = collegeId;
}

public String getNianfen() {
	return nianfen;
}

public void setNianfen(String nianfen) {
	this.nianfen = nianfen;
}

public String getMajorId() {
	return majorId;
}

public void setMajorId(String majorId) {
	this.majorId = majorId;
}


/**
 * author:高华锋
 * function:进入页面的时候得到学院 专业  班级
 * return:返回到success 2.jsp input  1.jsp
 * parameter:无
 * */
public String GetAllCollege(){
	List<College> l = collegeServiceImp.getAllCollege();
	List<Major> l2 = majorServiceImp.getAllMajorsByCollege(l.get(0).getCollegeId());
	List<Map<String,String>> cl= classServiceImp.getClassesByMajor(l2.get(0).getMajorId(),BaseInfor.getXueYear().get(0));
	Map<Short,String> m = new HashMap<Short,String>();
	for (College c : l) {
		m.put(c.getCollegeId(), c.getCollegeName());
	}
	ServletActionContext.getContext().put("colleges",m);
	ServletActionContext.getContext().put("firstMajors",l2);
	ServletActionContext.getContext().put("firstClasses",cl);
	return SUCCESS;
};


/**
 * author:高华锋
 * funciton:根据用户选择的学院  得到专业并显示在页面上
 * return:null  ajax
 * parameter:无*/
@SuppressWarnings("static-access")
public String getAllMajors(){
	List<Major> l = majorServiceImp.getAllMajorsByCollege(new Integer(collegeId));
	String majors="";
	JsonConfig config = new JsonConfig();
	config.setIgnoreDefaultExcludes(false);
	config.setExcludes(new String[]{"classeses","college","traininglevel"});
	try{
		majors = JSONArray.fromObject(l,config).toString();
	}catch(Exception e){
		e.printStackTrace();
	}
	ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
	try {
		ServletActionContext.getResponse().getWriter().print(majors);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}

/**
 * author:高华锋
 * function:得到入学年份
 * return :装了入学年份的json字符串
 * parameter:无*/
public String getXueYear(){
	try {
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(JSONArray.fromObject(BaseInfor.getXueYear()).toString());
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}
/**
 * author:高华锋
 * function:根据用户选择的专业  得到班级并显示在页面上
 * return :无
 * parameter:无*/
public String getClassesByMajor(){
	List<Map<String,String>> classes2 =null;
	try{
		if(majorId!="0")
			classes2 = classServiceImp.getClassesByMajor(new Integer(majorId),BaseInfor.getXueYear().get(new Integer(nianfen)));
		else
			ServletActionContext.getResponse().getWriter().write(JSONArray.fromObject(new ArrayList<String>()).toString());
		String classes3 = JSONArray.fromObject(classes2).toString();
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(classes3);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.print("第232错误  获得班级失败");
	}
	
	return null;
}


/**
 * author:高华锋
 * function:用于提交表单的*/
public String test(){
	System.out.println("什么东西也没有做的");
	return null;
}



/**
 * author:高华锋
 * function:根据性别 和其他信息得到学生  来给他们分配宿舍
 * return 学生的信息
 * parameter:性别
 */
public String getStuBySex(){
	List<Map<String,String>> stus = studentsServieImp.getStuBySex(classes,sex);
	String json = JSONArray.fromObject(stus).toString();
	try {
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}

/**
 * author:高华锋
 * function：将属于班级的room添加到表格*/
public String getRoom(){
	List<Map<String,String>> rooms = roomServiceImp.getRoom(classes,sex);
	String json = JSONArray.fromObject(rooms).toString();
	ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
	try {
		ServletActionContext.getResponse().getWriter().write(json);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}

/**
 * author:高华锋
 * function:将表单中的数据添加到数据库
 * pararmeter:status 是删除还是添加 studentsNumber studentsBed*/
public String stuToRoom(){
	studentsServieImp.stuToRoom(studentsNumber,studentsBed,roomNumber);
	return null;
}

/**
 * author:高华锋
 * function：将有床位的学生添加到roomtab中
 * parameter：class_id,sex*/
public String addStuOfRoom(){
	List<Map<String,String>> students  = studentsServieImp.addStuOfRoom(classes,sex);
	String json = JSONArray.fromObject(students).toString();
	ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
	try {
		ServletActionContext.getResponse().getWriter().write(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

}

