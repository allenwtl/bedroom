package com.serviceInterf;

import com.pojo.User;

public interface UserServiceInterf {
	/**根据用户名查询用户	*/
	public User getUserByNumber(String number);
	
	/**保存用户名	*/
	public void addUser(User user);
	
	
	/**修改用户名密码	*/
	public void modifyUser(User user);
}
