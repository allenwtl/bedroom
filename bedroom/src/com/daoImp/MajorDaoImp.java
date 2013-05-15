package com.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.MajorDaoInterf;
import com.pojo.Major;

public class MajorDaoImp extends HibernateDaoSupport implements MajorDaoInterf {


	public List<Major> getAllMajorByCollege(int id) {
		
		
		String sql = "select major_id,college_id,major_name from major where college_id=?";
		SQLQuery q    = getSession().createSQLQuery(sql);
		q.addEntity(Major.class);
		q.setParameter(0, id);
		List<Major> l = q.list();
		return l;
	}

	
	public void addMajor(Major major) {
		try {
			this.getHibernateTemplate().save(major);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("保存major失败");
		}
		
	}


	public Major getMajor(Short majorId) {
		List<Major> list = new ArrayList<Major>();
		try {
			String  sql = "from Major where majorId=?";
			list = this.getHibernateTemplate().find(sql, majorId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据majorId查询major失败");
		}
		if(list.isEmpty()) 	return null;
		else return list.get(0);
	}


}
