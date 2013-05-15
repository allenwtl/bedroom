package com.action.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Major;
import com.serviceInterf.MajorServiceInterf;

public class QueryMajorAction extends ActionSupport {
	private MajorServiceInterf majorServiceInterf;
	public void setMajorServiceInterf(MajorServiceInterf majorServiceInterf) {
		this.majorServiceInterf = majorServiceInterf;
	}



	@Override
	public String execute()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		List<Major> list = majorServiceInterf.getAllMajorsByCollege(id);
		
		StringBuffer sb = new StringBuffer();
		sb.append("[{");
		for(int i=0; i<list.size(); i++){
			if(i==list.size()-1){
				sb.append("id:").append(list.get(i).getMajorId()).append(",name:'").append(list.get(i).getMajorName()).append("'}]");
			}else {
				sb.append("id:").append(list.get(i).getMajorId()).append(",name:'").append(list.get(i).getMajorName()).append("'},{");
			}
		}
		
		response.setContentType("text/html; charset=utf-8");
		try {
			response.getWriter().print(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
