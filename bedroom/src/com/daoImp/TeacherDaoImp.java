package com.daoImp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.TeacherDaoInterf;
import com.pojo.Teacher;

public class TeacherDaoImp extends HibernateDaoSupport implements TeacherDaoInterf {
	private static final Log log = LogFactory.getLog(TeacherDaoImp.class);


	public Teacher findById(java.lang.Short id) {
		log.debug("getting Teacher instance with id: " + id);
		try {
			Teacher instance = (Teacher) getHibernateTemplate().get(
					"com.pojo.Teacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
