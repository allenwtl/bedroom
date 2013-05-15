package com.serviceImp;

import com.daoImp.HomenumberDaoImp;
import com.pojo.Homenumber;
import com.serviceInterf.HomenumberServiceInterf;

public class HomenumberServiceImp implements HomenumberServiceInterf {

	private HomenumberDaoImp homenumberDaoImp;

	public void setHomenumberDaoImp(HomenumberDaoImp homenumberDaoImp) {
		this.homenumberDaoImp = homenumberDaoImp;
	}

	public void save(Homenumber homenumber) {
		homenumberDaoImp.save(homenumber);
	}
}
