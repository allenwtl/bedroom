package com.aciton;

import com.model.Leave1Vo;
import com.opensymphony.xwork2.ActionContext;
import com.pojo.Leave1;
import com.serviceImp.Leave1ServiceImp;

public class LeaveAction extends BaseAction {
	private Leave1ServiceImp leave1ServiceImp;
	private Leave1Vo le1vo;
	

	public Leave1Vo getLe1vo() {
		return le1vo;
	}

	public void setLe1vo(Leave1Vo le1vo) {
		this.le1vo = le1vo;
	}

	public String regist2Succ(){	
		ActionContext.getContext().getSession().put("StuNuber", "1011100125");//保存登录的学生的账号
		leave1ServiceImp.registLeave1(le1vo);
		
		return SUCCESS;
	}

	public Leave1ServiceImp getLeave1ServiceImp() {
		return leave1ServiceImp;
	}

	public void setLeave1ServiceImp(Leave1ServiceImp leave1ServiceImp) {
		this.leave1ServiceImp = leave1ServiceImp;
	}
	
}
