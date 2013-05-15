package com.serviceImp;

import java.util.List;

import com.daoImp.KezhiDaoImp;
import com.pojo.Kezhi;
import com.serviceInterf.KezhiServiceInterf;

public class KezhiServiceImp implements KezhiServiceInterf {
	private KezhiDaoImp kezhiDaoImp;

	public void setKezhiDaoImp(KezhiDaoImp kezhiDaoImp) {
		this.kezhiDaoImp = kezhiDaoImp;
	}

	@Override
	public Kezhi getKezhi(Short id) {
		return kezhiDaoImp.getKezhi(id);
	}

	@Override
	public List<Kezhi> getAllKezhi() {
		return kezhiDaoImp.getAllKezhi();
	}
	

}
