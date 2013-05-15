package com.daoInterf;

import java.util.List;

import com.pojo.Major;

public interface MajorDaoInterf {

	public List<Major> getAllMajorByCollege(int id);
	
	/**添加major	*/
	public void addMajor(Major major);
	
	/**根据majorId查询major	*/
	public Major getMajor(Short majorId);
	
}
