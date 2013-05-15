package com.serviceInterf;

import java.util.List;

import com.pojo.College;

public interface CollegeServiceInterf {

	/**
	 * author:高华锋
	 * function:得到所有的学院
	 * return:装着学院对象的list
	 * parameter:none*/
	public List<College> getAllCollege();
}
