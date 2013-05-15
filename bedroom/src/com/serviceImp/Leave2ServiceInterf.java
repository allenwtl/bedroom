package com.serviceImp;

import com.daoImp.Leave2DaoImp;

public class Leave2ServiceInterf implements
		com.serviceInterf.Leave2ServiceInterf {

	private Leave2DaoImp leave2DaoImp;

	public void setLeave2DaoImp(Leave2DaoImp leave2DaoImp) {
		this.leave2DaoImp = leave2DaoImp;
	}
}
