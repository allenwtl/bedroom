package com.action.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.College;
import com.serviceInterf.CollegeServiceInterf;

public class CollegeAction extends ActionSupport {
	private CollegeServiceInterf collegeServiceInterf;

	public void setCollegeServiceInterf(CollegeServiceInterf collegeServiceInterf) {
		this.collegeServiceInterf = collegeServiceInterf;
	}


	public String execute(){
		HttpServletResponse response = ServletActionContext.getResponse();
		List<College>  list = collegeServiceInterf.getAllCollege();
		
		StringBuffer sb = new StringBuffer();
		sb.append("[{");
		for(int i=0;i<list.size();i++){
			if(i == list.size()-1){
				sb.append("id:'").append(list.get(i).getCollegeId()).append("',name:'").append(list.get(i).getCollegeName()).append("'}]");
			}else {
				sb.append("id:'").append(list.get(i).getCollegeId()).append("',name:'").append(list.get(i).getCollegeName()).append("'},{");
			}
		}
		System.out.println(sb);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
