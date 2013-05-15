package com.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.KezhiDaoInterf;
import com.pojo.Kezhi;

public class KezhiDaoImp extends HibernateDaoSupport implements KezhiDaoInterf {

	@Override
	public Kezhi getKezhi(Short id) {
		List<Kezhi>  kezhiList = new ArrayList<Kezhi>();
		String sql = "from Kezhi t where t.kezhiId=?";
		try {
			kezhiList = this.getHibernateTemplate().find(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据kezhi的主键查询kezhi失败");
		}
		if(kezhiList.isEmpty())  return null;
		else return kezhiList.get(0);
	}

	public List<Kezhi> getAllKezhi() {
		List<Kezhi> list = new ArrayList<Kezhi>();
		String sql = "from Kezhi";
		try {
			list = this.getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("得到专业的所有的类型失败");
		}
		return list;
	}

}
