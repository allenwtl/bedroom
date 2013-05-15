package com.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.daoInterf.CollegeDaoIterf;
import com.pojo.College;
import com.util.HibernateSessionFactory;

public class CollegeDaoImp implements CollegeDaoIterf {

	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	
	public List<College> getAllCollege() {
		List<College> list = new ArrayList<College>();
		String sql = "select * from college";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.addEntity(College.class);
		list = q.list();
		return list;
	}

}
