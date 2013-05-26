package com.action.student;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Kezhi;
import com.pojo.RoomandstudentsId;
import com.pojo.Students;
import com.serviceImp.AddressInfoServiceImp;
import com.serviceImp.ClassServiceImp;
import com.serviceImp.HomenumberServiceImp;
import com.serviceImp.KezhiServiceImp;
import com.serviceImp.NationServiceImp;
import com.serviceImp.PoliticalServiceImp;
import com.serviceImp.ResumeServiceImp;
import com.serviceImp.RoomServiceImp;
import com.serviceImp.StudentsServiceImp;
import com.vo.StudentVo;

public class ModifyStuInfo extends ActionSupport {
	private AddressInfoServiceImp addressInfoServiceImp;
	private ClassServiceImp classServiceImp;
	private HomenumberServiceImp homenumberServiceImp;
	private NationServiceImp nationServiceImp;
	private PoliticalServiceImp politicalServiceImp;
	private ResumeServiceImp resumeServiceImp;
	private StudentsServiceImp studentsServiceImp;
	private KezhiServiceImp kezhiServiceImp; 
	private RoomServiceImp roomServiceImp ;
	public void setRoomServiceImp(RoomServiceImp roomServiceImp) {
		this.roomServiceImp = roomServiceImp;
	}
	public void setKezhiServiceImp(KezhiServiceImp kezhiServiceImp) {
		this.kezhiServiceImp = kezhiServiceImp;
	}
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
	
	
	
	public  String  getStuInfo(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		
		String  stu_num =  "10415400118";
		Students     student =     studentsServiceImp.getStudentByNumber(stu_num);
		StudentVo  studentVo = new StudentVo();
		
		studentVo.setClassNumber(classServiceImp.getClassName(student.getClassNumber()).getClassName());
		studentVo.setStudentsAddress(student.getStudentsAddress());
		studentVo.setStudentsBirthday(student.getStudentsBirthday().toString().substring(0, 10));
		studentVo.setStudentsEmail(student.getStudentsEmail());
		studentVo.setStudentsIdcard(student.getStudentsIdcard());
		studentVo.setStudentsInRoomTime(student.getStudentsInroomtime().toString().substring(0, 10));
		studentVo.setStudentsInSchool(student.getStudentsInschool().toString().substring(0, 10));
		studentVo.setStudentsName(student.getStudentsName());
		studentVo.setStudentsNation(nationServiceImp.getNationById(student.getStudentsNation()).getNationName());
		studentVo.setStudentsNative(student.getStudentsNative());
		studentVo.setStudentsNativeplace(student.getStudentsNativeplace());
		studentVo.setStudentsNumber(student.getStudentsNumber());
		studentVo.setStudentsPhone(student.getStudentsPhone());
		studentVo.setStudentsPostcode(student.getStudentsPostcode());
		studentVo.setStudentsPinyin(student.getStudentsPinyin());
		
		if(student.getStudentsSex()==1) 
			studentVo.setStudentsSex("男");
		else
			studentVo.setStudentsSex("女");
		
		studentVo.setStudentsQq(student.getStudentsQq());
		studentVo.setStudentsPolitics(politicalServiceImp.getPoliticalByNumber(student.getStudentsPolitics()).getPoliticalName());
		short type  = student.getStudentsType(); 
		System.out.println(type);
		if(type==(short)1) studentVo.setStudentsType("城应");
		else if((short)2==type) studentVo.setStudentsType("城往");
		else if((short)3==type) studentVo.setStudentsType("农应");
		else studentVo.setStudentsType("农往");
		
		RoomandstudentsId roomStudent = null;
		if(null!= student.getRoomId()){
			roomStudent = roomServiceImp.getRoomandstudents(student.getRoomId());
		}
		if(null!= roomStudent){
			studentVo.setRoomLocation(roomStudent.getRoomNumber()+roomStudent.getStudentsBed());
		}
		JSONObject object = new JSONObject();
		object.put("student", studentVo);
		
		try {
			response.getWriter().print(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//保存学生修改之后的信息
	public String  updateStu(){
		
		
		
		
		return null;
	}
	
	
	
}
