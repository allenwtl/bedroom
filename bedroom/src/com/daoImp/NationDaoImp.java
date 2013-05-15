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

}
