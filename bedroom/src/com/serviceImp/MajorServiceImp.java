package com.serviceImp;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.daoImp.MajorDaoImp;
import com.pojo.Major;
import com.serviceInterf.MajorServiceInterf;

public class MajorServiceImp implements MajorServiceInterf {

	private MajorDaoImp majorDaoImp;

	public void setMajorDaoImp(MajorDaoImp majorDaoImp) {
		this.majorDaoImp = majorDaoImp;
	}

	
	public List<Major> getAllMajorsByCollege(int id) {
		try{
			List<Major> l = majorDaoImp.getAllMajorByCollege(id);
			return l;
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("MajorServiceIMp 28行");
			return null;
		}
		
	}


	@Override
	public void addMajor(Major major) {
		
		majorDaoImp.addMajor(major);
	}


	@Override
	public Major getMajor(Short majorId) {
		
		return majorDaoImp.getMajor(majorId);
	}




}
