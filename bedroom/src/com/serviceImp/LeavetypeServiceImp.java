package com.serviceImp;

import com.daoImp.LeavetypeDaoImp;
import com.serviceInterf.LeavetypeServiceInterf;

public class LeavetypeServiceImp implements LeavetypeServiceInterf {

	private LeavetypeDaoImp leavetypeDaoImp;

	public void setLeavetypeDaoImp(LeavetypeDaoImp leavetypeDaoImp) {
		this.leavetypeDaoImp = leavetypeDaoImp;
	}
	
}
