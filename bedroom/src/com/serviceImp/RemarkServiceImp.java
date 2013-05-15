package com.serviceImp;

import com.daoImp.RemarkDaoImp;
import com.serviceInterf.RemarkServiceInterf;

public class RemarkServiceImp implements RemarkServiceInterf {

	private RemarkDaoImp remarkDaoImp;

	public void setRemarkDaoImp(RemarkDaoImp remarkDaoImp) {
		this.remarkDaoImp = remarkDaoImp;
	}
}
