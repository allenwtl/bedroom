package com.action.student;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Kezhi;
import com.serviceInterf.KezhiServiceInterf;

public class MajorAction extends ActionSupport {
	private KezhiServiceInterf kezhiServiceInterf;
	
	public void setKezhiServiceInterf(KezhiServiceInterf kezhiServiceInterf) {
		this.kezhiServiceInterf = kezhiServiceInterf;
	}


	public String execute() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		
		List<Kezhi> list  =  kezhiServiceInterf.getAllKezhi();
		StringBuffer sb = new StringBuffer();
		sb.append("[{");
		for(int i=0;i<list.size();i++){
			if(i==list.size()-1){
				sb.append("id:'").append(list.get(i).getKezhiId()).append("',type:'").append(list.get(i).getKezhiType()).append("',year:'").append(list.get(i).getKezhiYear()).append("'}]");
			}else {
				sb.append("id:'").append(list.get(i).getKezhiId()).append("',type:'").append(list.get(i).getKezhiType()).append("',year:'").append(list.get(i).getKezhiYear()).append("'},{");
			}
		}
		System.out.println(sb);
		try {
			response.getWriter().print(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
