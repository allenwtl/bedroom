package com.serviceImp;

import com.daoImp.Leave3DaoImp;
import com.serviceInterf.Leave3ServiceInterf;

public class Leave3ServiceImp implements Leave3ServiceInterf {

	private Leave3DaoImp leave3DaoImp;

	public void setLeave3DaoImp(Leave3DaoImp leave3DaoImp) {
		this.leave3DaoImp = leave3DaoImp;
	}
	
}
