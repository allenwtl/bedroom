package com.action.student;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Homenumber;
import com.pojo.Resume;
import com.pojo.Socialrelations;
import com.pojo.Students;
import com.serviceImp.AddressInfoServiceImp;
import com.serviceImp.HomenumberServiceImp;
import com.serviceImp.ResumeServiceImp;
import com.serviceImp.StudentsServiceImp;
import com.vo.HomenumberVo;
import com.vo.ResumeVo;
import com.vo.SocialRelationsVo;
import com.vo.StudentVo;


public class AddStudentAction extends ActionSupport {
	private  StudentsServiceImp studentsServiceImp;
	private  AddressInfoServiceImp addressInfoServiceImp;
	public void setAddressInfoServiceImp(AddressInfoServiceImp addressInfoServiceImp) {
		this.addressInfoServiceImp = addressInfoServiceImp;
	}
	public void setStudentsServiceImp(StudentsServiceImp studentsServiceImp) {
		this.studentsServiceImp = studentsServiceImp;
	}
	
                              
	private  StudentVo studentsVo = new StudentVo();
	public StudentVo getStudentsVo() {
		return studentsVo;
	}
	public void setStudentsVo(StudentVo studentsVo) {
		this.studentsVo = studentsVo;
	}

	public String addStudent() {
		//根据登陆的session得到学号
		
		//根据学号得到照片存放位置
		String  path = ServletActionContext.getServletContext().getRealPath("/image");
		File  dir = new File(path);
		File[] files = dir.listFiles();
		for(File file:files){
			if(file.getName().startsWith("10415400118")){
				path = path + "\\" + file.getName();
				System.out.println(path);
			}
		}
		
		Students students = studentsServiceImp.getStudentByNumber(studentsVo.getStudentsNumber());
		
		String   province =  addressInfoServiceImp.getProvinceNameById(studentsVo.getSheng()).getProvinceName();
		String   city     =  addressInfoServiceImp.getCityNameById(studentsVo.getShi()).getCityName();
		String   disId    = studentsVo.getXian();
		String   district = "";
		if(disId!=null)
			district =  addressInfoServiceImp.getDistrictNameById(studentsVo.getXian()).getDistrictName();
		students.setStudentsAddress(province+city+district+studentsVo.getDetail());
		
		students.setStudentsBirthday(changeTime(studentsVo.getStudentsBirthday()));
		students.setStudentsInroomtime(changeTime(studentsVo.getStudentsInRoomTime()));
		students.setStudentsInschool(changeTime(studentsVo.getStudentsInSchool()));
		
		students.setStudentsEmail(studentsVo.getStudentsEmail());
		students.setStudentsNative(studentsVo.getStudentsNative());
		students.setStudentsNativeplace(studentsVo.getStudentsNativeplace());
		students.setStudentsPhone(studentsVo.getStudentsPhone());
		students.setStudentsPinyin(studentsVo.getStudentsPinyin());
		students.setStudentsPolitics(Short.parseShort(studentsVo.getStudentsPolitics()));
		students.setStudentsPostcode(studentsVo.getStudentsPostcode());
		students.setStudentsQq(studentsVo.getStudentsQq());
		students.setStudentsType(Short.parseShort(studentsVo.getStudentsType()));
		
		//图片url
		students.setStudentsImage(path);
		
		studentsServiceImp.updateStudent(students);
		return null;
	}
	
	
	/**添加resume*/
	private ResumeServiceImp  resumeServiceImp;
	public void setResumeServiceImp(ResumeServiceImp resumeServiceImp) {
		this.resumeServiceImp = resumeServiceImp;
	}

	private  ResumeVo resume;
	public ResumeVo getResume() {
		return resume;
	}
	public void setResume(ResumeVo resume) {
		this.resume = resume;
	}
	public String addResume(){
		
		List<String> beginTime = changeData(resume.getResumeBegintime());
		List<String> endTime   = changeData(resume.getResumeEndtime());
		List<String> person    = changeData(resume.getResumePerson());
		List<String> learn     = changeData(resume.getResumeLean());
		
		//通过学号查询学生的序列号
		Students stu = studentsServiceImp.getStudentByNumber("10415400118");
		Integer  id = stu.getStudentsId();
		
		for(int i=0;i<beginTime.size();i++){
			Resume  resumePo = new Resume();
			resumePo.setResumeBegintime(changeTime(beginTime.get(i)+"-01"));
			resumePo.setResumeEndtime(changeTime(endTime.get(i)+"-01"));
			resumePo.setResumeLean(learn.get(i));
			resumePo.setResumePerson(person.get(i));
			resumePo.setStudentsId(id);
			resumeServiceImp.save(resumePo);
		}
		
		return null;
	}
	
	
	
	//保存学生的家庭成员的情况
	private HomenumberVo homenumberVo;
	private HomenumberServiceImp homenumberServiceImp;
	public void setHomenumberServiceImp(HomenumberServiceImp homenumberServiceImp) {
		this.homenumberServiceImp = homenumberServiceImp;
	}
	public HomenumberVo getHomenumberVo() {
		return homenumberVo;
	}
	public void setHomenumberVo(HomenumberVo homenumberVo) {
		this.homenumberVo = homenumberVo;
	}
	public String  addHome(){
		List<String> titleList = changeData(homenumberVo.getHomenumberTitle());
		List<String> nameList  = changeData(homenumberVo.getHomenumberName());
		List<String> politicalList = changeData(homenumberVo.getHomenumberPolitical());
		List<String> utilList  = changeData(homenumberVo.getHomenumberUnit());
		List<String> phoneList = changeData(homenumberVo.getHomenumberPhone());
 		
		//根据学号 查询学生
		Students  student = studentsServiceImp.getStudentByNumber("10415400118");
		
		for(int i=0;i<titleList.size();i++){
			Homenumber homenumber = new Homenumber();
			homenumber.setHomenumberTitle(titleList.get(i));
			homenumber.setHomenumberName(nameList.get(i));
			homenumber.setHomenumberPolitical(Short.parseShort(politicalList.get(i)));
			homenumber.setHomenumberUnit(utilList.get(i));
			homenumber.setHomenumberPhone(phoneList.get(i));
			homenumber.setStudents(student);
			homenumberServiceImp.save(homenumber);
		}
		
		return null;
	}
	
	
	
	//保存影响学生的人的 信息
	private SocialRelationsVo relationsVo;
	public SocialRelationsVo getRelationsVo() {
		return relationsVo;
	}
	public void setRelationsVo(SocialRelationsVo relationsVo) {
		this.relationsVo = relationsVo;
	}
	public String addRelation(){
		List<String>  title = changeData(relationsVo.getRelationTitle());
		List<String>  name  = changeData(relationsVo.getRelationName());
		List<String>  political = changeData(relationsVo.getRelationPolitical());
		List<String>  utiList  = changeData(relationsVo.getRelationUtil());
		List<String>  phone  = changeData(relationsVo.getRelationPhone());
		
		//根据学号查询学生
		Students students = studentsServiceImp.getStudentByNumber("10415400118");
		
		for(int i=0;i<title.size();i++){
			Socialrelations socialrelations = new Socialrelations();
			socialrelations.setRelationTitle(title.get(i));
			socialrelations.setRelationName(name.get(i));
			socialrelations.setRelationPolitice(political.get(i));
			socialrelations.setRelationUtil(utiList.get(i));
			socialrelations.setRelationPhone(phone.get(i));
			socialrelations.setStudents(students);
			studentsServiceImp.saveRelation(socialrelations);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	//处理学生简历字符串的问题
	public List<String> changeData(String data){
		List<String>  strList = new ArrayList<String>();
		String  leaveStr = data;
		String value ="";
		int location  = leaveStr.indexOf(",");
		int lenght    = leaveStr.indexOf("-");
		if((data.startsWith("1") || data.startsWith("2")) && lenght>0 ){
			while(location>0){
				value = leaveStr.substring(0, 7);
				strList.add(value);
				leaveStr = leaveStr.substring(location+2);
				location = leaveStr.indexOf(",");
			}
		}else {
			while(location>0){
				value = leaveStr.substring(0,location);
				strList.add(value);
				leaveStr = leaveStr.substring(location+2);
				location = leaveStr.indexOf(",");
			}
		}
		value = leaveStr.substring(0);
		strList.add(value);
		return  strList;
 	}
	
	//将字符串的时间转换为timestamp
	public Timestamp changeTime(String time){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		Timestamp ts = null;
		try {
			 ts= new Timestamp(format.parse(time).getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}
	
}
