package com.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.PoliticalDaoInter;
import com.pojo.Political;

public class PoliticalDaoImp extends HibernateDaoSupport implements
		PoliticalDaoInter {

	@Override
	public List<Political> getAllPoliticals() {
		List<Political> pList = new ArrayList<Political>();
		String   sql = "from Political";
		try {
			pList = this.getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("得到所有的政治面貌失败");
		}
		if(pList.isEmpty()) return null;
		else return pList;
	}

	public Political getPoliticalByNumber(String number) {
		List<Political>  list = null  ;
		String sql = "from Political where politicalNumber = ?";
		try {
			list = this.getHibernateTemplate().find(sql , number);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return  list.get(0);
	}
	
	public Political getPoliticalByName(String name) {
		List<Political>  list = null  ;
		String sql = "from Political where politicalName = ?";
		try {
			list = this.getHibernateTemplate().find(sql , name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return  list.get(0);
	}

}
