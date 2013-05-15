package com.action.student;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Kezhi;
import com.serviceInterf.KezhiServiceInterf;

public class QueryKezhiAction extends ActionSupport {
	private KezhiServiceInterf kezhiServiceInterf;
	public void setKezhiServiceInterf(KezhiServiceInterf kezhiServiceInterf) {
		this.kezhiServiceInterf = kezhiServiceInterf;
	}
	
	@Override
	public String execute() {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Kezhi> list  = kezhiServiceInterf.getAllKezhi();
		
		StringBuffer sb = new StringBuffer();
		sb.append("[{");
		for(int i = 0; i<list.size(); i++){
			if(i==list.size()-1){
				sb.append("id:").append(list.get(i).getKezhiId()).append(",type:'").append(list.get(i).getKezhiYear()+"年"+list.get(i).getKezhiType()+"科").append("'}]");
			}else {
				sb.append("id:").append(list.get(i).getKezhiId()).append(",type:'").append(list.get(i).getKezhiYear()+"年"+list.get(i).getKezhiType()+"科").append("'},{");
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
