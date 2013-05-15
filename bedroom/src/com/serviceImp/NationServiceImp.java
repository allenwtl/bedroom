package com.serviceImp;

import java.util.List;

import com.daoImp.NationDaoImp;
import com.pojo.Nation;
import com.serviceInterf.NationServiceInterf;

public class NationServiceImp  implements  NationServiceInterf {
	private NationDaoImp nationDaoImp ;
	public void setNationDaoImp(NationDaoImp nationDaoImp) {
		this.nationDaoImp = nationDaoImp;
	}

	public List<Nation> getAllNations() {
		return nationDaoImp.getAllNations();
	}

}
