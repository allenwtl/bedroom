package com.serviceImp;

import com.daoImp.UserDaoImp;
import com.pojo.User;
import com.serviceInterf.UserServiceInterf;

public class UserServiceImp implements UserServiceInterf {
	private UserDaoImp userDaoImp;

	public void setUserDaoImp(UserDaoImp userDaoImp) {
		this.userDaoImp = userDaoImp;
	}

	public User getUserByNumber(String number) {
		User user = userDaoImp.getUserByNumber(number);
		if(user==null)	return null;
		else  return user;
	}

	public void addUser(User user) {
		userDaoImp.addUser(user);
	}

	public void modifyUser(User user) {
		userDaoImp.modifyUser(user);
	}

}
