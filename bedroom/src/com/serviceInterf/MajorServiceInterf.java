package com.serviceInterf;

import java.util.List;

import com.pojo.Major;

public interface MajorServiceInterf {

	/**
	 * author:高华锋
	 * function:根据学院得到所有的专业
	 * return：Major对象的list集合
	 * parameter：学院id
	 * */
	public List<Major> getAllMajorsByCollege(int id);

	/**添加major	*/
	public void addMajor(Major major);
	
	/**根据majorId查询major	*/
	public Major getMajor(Short majorId);
}
