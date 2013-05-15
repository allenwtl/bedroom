package com.serviceImp;

import com.daoImp.XiaojiaDaoImp;
import com.serviceInterf.XiaojiaServiceInterf;

public class XiaojiaServiceImp implements XiaojiaServiceInterf {

	private XiaojiaDaoImp xiaojiaDaoImp;

	public void setXiaojiaDaoImp(XiaojiaDaoImp xiaojiaDaoImp) {
		this.xiaojiaDaoImp = xiaojiaDaoImp;
	}
}
