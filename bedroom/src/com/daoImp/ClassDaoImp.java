package com.daoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.ClassDaoInterf;
import com.pojo.Classes;

public class ClassDaoImp extends HibernateDaoSupport implements ClassDaoInterf {


	public List<Map<String,String>> getClassesByMajor(int majorId, String nianfen) {
		String sql = "select class_id,major_id,class_name,class_intime,kezhi_id from classes where major_id=? and class_intime='"+nianfen+"'";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter(0, majorId);
		List<Map<String,String>> classes2 = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return classes2;
	}

	public Classes getClassName(Short classNumber) {
		List<Classes> clazz = new ArrayList<Classes>();
		String sql = "from Classes where classId =?";
		try {
			clazz =  this.getHibernateTemplate().find(sql,classNumber);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据班级编号查询班级名称失败");
		}
		if(clazz.isEmpty()) return null;
		else return clazz.get(0);
	}

	public Classes getClasses(String className) {
		List<Classes> claList = new ArrayList<Classes>();
		String  sql  = "from Classes where className =?";
		try {
			claList = this.getHibernateTemplate().find(sql, className);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据班级名称查询班级失败");
		}
		if(claList.isEmpty())  return null;
		else return claList.get(0);
	}

	public void addClass(Classes clazz) {
		try {
			this.getHibernateTemplate().save(clazz);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("保存clazz失败");
		}
	}

}
 