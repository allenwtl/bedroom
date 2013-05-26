package com.serviceImp;

import com.daoImp.PhoneListDaoImp;
import com.pojo.Students;
import com.serviceInterf.PhoneListServiceInterf;

public class PhoneListServiceImp implements PhoneListServiceInterf {

	private PhoneListDaoImp phonelistDaoImp;

	public void setPhonelistDaoImp(PhoneListDaoImp phonelistDaoImp) {
		this.phonelistDaoImp = phonelistDaoImp;
	}

	@Override
	public void saveNewPhone(String studentsPhone,Students students) {
		phonelistDaoImp.saveNewPhone(studentsPhone,students);
	}
}
