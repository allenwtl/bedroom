package com.aciton.SuShe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;


import com.aciton.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.pojo.Classes;
import com.pojo.College;
import com.pojo.Major;
import com.pojo.Qinshi;
import com.pojo.Room;
import com.pojo.Roominfor;
import com.serviceImp.ClassServiceImp;
import com.serviceImp.CollegeServiceImp;
import com.serviceImp.MajorServiceImp;
import com.serviceImp.QinshiServiceImp;
import com.serviceImp.RoomServiceImp;
import com.serviceImp.StudentsServiceImp;
import com.util.BaseInfor;
import com.util.Bed;
import com.util.StringUtil;


public class AddRoomAction extends BaseAction {

	private StudentsServiceImp studentsServiceImp;
	private CollegeServiceImp	collegeServiceImp;
	private MajorServiceImp		majorServiceImp;
	private ClassServiceImp 	classServiceImp;
	private RoomServiceImp		roomServiceImp;
	private QinshiServiceImp	qinshiServiceImp;

	
	public void setQinshiServiceImp(QinshiServiceImp qinshiServiceImp) {
		this.qinshiServiceImp = qinshiServiceImp;
	}


	public void setRoomServiceImp(RoomServiceImp roomServiceImp) {
		this.roomServiceImp = roomServiceImp;
	}


	public void setCollegeServiceImp(CollegeServiceImp collegeServiceImp) {
		this.collegeServiceImp = collegeServiceImp;
	}


	public void setMajorServiceImp(MajorServiceImp majorServiceImp) {
		this.majorServiceImp = majorServiceImp;
	}

	public void setClassServiceImp(ClassServiceImp classServiceImp) {
		this.classServiceImp = classServiceImp;
	}

	public void setStudentsServiceImp(StudentsServiceImp studentsServiceImp) {
		this.studentsServiceImp = studentsServiceImp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String dongs;
	private String cengs;
	private String collegeId;
	private String majorId;
	private String classes;
	private String nianfen;
	private String sex;
	private Integer page;
	private Integer rp;
	private List<String> rooms;
	private List<String> chuangs;
	
	
	




	public List<String> getRooms() {
		return rooms;
	}


	public void setRooms(List<String> rooms) {
		this.rooms = rooms;
	}


	public List<String> getChuangs() {
		return chuangs;
	}


	public void setChuangs(List<String> chuangs) {
		this.chuangs = chuangs;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getRp() {
		return rp;
	}


	public void setRp(Integer rp) {
		this.rp = rp;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getNianfen() {
		return nianfen;
	}


	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}


	

	public String getClasses() {
		return classes;
	}


	public void setClasses(String classes) {
		this.classes = classes;
	}


	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	


	public String getMajorId() {
		return majorId;
	}


	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}


	public String getCengs() {
		return cengs;
	}

	public void setCengs(String cengs) {
		this.cengs = cengs;
	}



	public String getDongs() {
		return dongs;
	}



	public void setDongs(String dongs) {
		this.dongs = dongs;
	}

	
	
	
	
	
	
	
	
	
	

	/**
	 * author:高华锋
	 * function:测试  用的
	 * return:返回到**页面  然后填出 框架成功的消息
	 * parameter:无
	 * */
	public String getStudentsName(){
		return SUCCESS;
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
		getDongCengRooms();//zenme mei yong qilai
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
			ServletActionContext.getResponse().getWriter().print(classes3);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("第232错误  获得班级失败");
		}
		
		return null;
	}
	

	/**
	 * author:高华锋
	 * function:根据性别得到所有的栋 然后发到页面   
	 * return:无
	 * parameter：无
	 * */
	public String getDongCengRooms(){
		if(sex==null)
			sex="0";
		List<String> getDongs  = qinshiServiceImp.getDong();
		getDongs.add("-");
		ServletActionContext.getContext().put("dongs",getDongs);
		
		String json = JSONArray.fromObject(getDongs).toString();
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	

	
	public	String getCengOfDong(){
		Integer ceng = roomServiceImp.getCengOfDong(dongs);
		List list=  new ArrayList();
		list.add(ceng);
		String dongOfCeng = JSONArray.fromObject(list).toString();
		try {
			ServletActionContext.getResponse().getWriter().write(dongOfCeng);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	/**author:高华锋
	 * function:得到莫一栋楼的寝室的床位的所有信息
	 * parameter:dong  class   ceng   各种信息
	 * return: list*/


	public String getEmptyRoomsToFlexigrid(){
		if(cengs==null)
			cengs ="1";
		int g =1;
		List<List<List<String>>> emptyRooms = roomServiceImp.getEmptyRoom(dongs, classes,cengs,sex);
		Map jsonMap = new HashMap();
		jsonMap.put("page", cengs);
		jsonMap.put("rpOptions", "[2,3,4,5,6,7]");
		setRp(2);
		List rowsList = new ArrayList();
		int num=0;
		for (List<List<String>> m : emptyRooms) {
			
			for (List<String> l : m) {
				num++;
				Map rowsMap = new HashMap();
				List rList = new ArrayList();
				for (int n =1;n<l.size();n++) {
					//直接就是里面的内容了  你开始拼接吧\
					//[1, r1-101, A, AD, 财经学院, 信管101班,信管102班, 计算机学院, 会计101班]					
					rList.add(l.get(n));	
				}
				rowsMap.put("ceng",l.get(0));
				rowsMap.put("cell",rList);
				rowsList.add(rowsMap);
				g++;
			}
		}
		jsonMap.put("total", num);
		jsonMap.put("rows", rowsList);
		
		String json = JSONObject.fromObject(jsonMap).toString();
		json= StringUtil.replaceString(json,"null-;","");
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);      

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return null;
	}

	public String test(){
		System.out.println("did nothing");
		return null;
	}
	/**
	 * author:高华锋
	 * function:将选择的寝室号对应的寝室归属于一个班级
	 * return:success
	 * parameter:无*/
	public String addRoom(){
		
		roomServiceImp.addRoomToClass(rooms,chuangs,classes);
		return null;
	}
	
	
	

}
