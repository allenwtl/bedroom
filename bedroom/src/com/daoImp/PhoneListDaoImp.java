package com.daoImp;

import com.daoInterf.PhoneListDaoInterf;
import com.pojo.Phonelist;
import com.pojo.Students;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PhoneListDaoImp extends HibernateDaoSupport implements PhoneListDaoInterf {

	public void saveNewPhone(String studentsPhone, Students students) {
		Phonelist phonelist = new Phonelist();
		phonelist.setPhonelistNumber(studentsPhone);
		phonelist.setStudents(students);
		try {
			this.getHibernateTemplate().save(students);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
