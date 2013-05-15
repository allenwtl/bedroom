package com.daoImp;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.SQLQuery;
import com.daoInterf.ResumeDaoInterf;
import com.pojo.Resume;

public class ResumeDaoImp extends HibernateDaoSupport implements ResumeDaoInterf {

	public void save(Resume resume) {
		try {
			this.getHibernateTemplate().save(resume);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("学生的简历添加失败");
		}
		
		
	}



}
