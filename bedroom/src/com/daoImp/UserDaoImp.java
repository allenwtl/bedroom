package com.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.UserDaoInterf;
import com.pojo.User;

public class UserDaoImp extends HibernateDaoSupport implements UserDaoInterf {

	public User getUserByNumber(String number) {
		List<User> userList = new ArrayList<User>();
		String  sql = "from User t where t.userNumber=?";
		try {
			userList = this.getHibernateTemplate().find(sql,number);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据用户名查询用户失败");
		}
		if(userList.isEmpty()) return null;
		else return userList.get(0);
	}

	public void addUser(User user) {
		try {
			this.getHibernateTemplate().save(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("保存用户失败");
		}
	}

	public void modifyUser(User user) {
		try {
			this.getHibernateTemplate().update(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("修改用户密码失败");
		}
	}
}
