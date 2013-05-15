package com.daoImp;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.HomenumberDaoInterf;
import com.pojo.Homenumber;

public class HomenumberDaoImp extends HibernateDaoSupport implements HomenumberDaoInterf {

	public void save(Homenumber homenumber) {
		try {
			this.getHibernateTemplate().save(homenumber);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("保存学生的家庭成员  失败");
		}
		
	}

}
