package com.serviceImp;

import java.util.List;

import com.daoImp.PoliticalDaoImp;
import com.pojo.Political;
import com.serviceInterf.PoliticalServiceInter;

public class PoliticalServiceImp implements PoliticalServiceInter {
	private PoliticalDaoImp politicalDaoImp;
	public void setPoliticalDaoImp(PoliticalDaoImp politicalDaoImp) {
		this.politicalDaoImp = politicalDaoImp;
	}

	@Override
	public List<Political> getAllPoliticals() {
		return   politicalDaoImp.getAllPoliticals();
	}
	
	public Political getPoliticalByNumber(String number){
		return   politicalDaoImp.getPoliticalByNumber(number);
	}

	
	public Political getPoliticalByName(String name) {
		return   politicalDaoImp.getPoliticalByName(name);
	}

}
