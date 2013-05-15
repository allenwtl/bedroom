package com.daoImp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.LeavetypeDaoInterf;
import com.pojo.Leavetype;

public class LeavetypeDaoImp extends HibernateDaoSupport implements LeavetypeDaoInterf {
	
	private static final Log log = LogFactory.getLog(LeavetypeDaoImp.class);
	
	public Leavetype findById(java.lang.Byte id) {
		log.debug("getting Leavetype instance with id: " + id);
		try {
			Leavetype instance = (Leavetype) getHibernateTemplate().get(
					"com.pojo.Leavetype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
