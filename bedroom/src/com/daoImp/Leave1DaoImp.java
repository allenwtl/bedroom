package com.daoImp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.Leave1DaoInterf;
import com.pojo.Leave1;

public class Leave1DaoImp extends HibernateDaoSupport implements Leave1DaoInterf {
	private static final Log log = LogFactory.getLog(Leave1DaoImp.class);
	public void registLeave() {
		// TODO Auto-generated method stub
		
	}

	public void save(Leave1 transientInstance) {
		log.debug("saving Leave1 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
}
