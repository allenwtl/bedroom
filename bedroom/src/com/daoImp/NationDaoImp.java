package com.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.NationDaoInterf;
import com.pojo.Nation;

public class NationDaoImp extends HibernateDaoSupport implements NationDaoInterf {

	@Override
	public List<Nation> getAllNations() {
		List<Nation> nationList = new ArrayList<Nation>();
		String sql = "from Nation";
		try {
			nationList = this.getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("得到所有的民族失败");
		}
		if(nationList.isEmpty())  return null;
		else  return nationList;
	}

	public Nation getNationById(String dm) {
		List<Nation>  list  = null;
		String sql = "from Nation where nationNumber = ?";
		try {
			list = this.getHibernateTemplate().find(sql, dm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty())  return null;
		else return  list.get(0);
	}
	
	public Nation getNationByName(String  name){
		List<Nation>  list  = null;
		String sql = "from Nation where nationName = ?";
		try {
			list = this.getHibernateTemplate().find(sql, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty())  return null;
		else return  list.get(0);
	}

}
