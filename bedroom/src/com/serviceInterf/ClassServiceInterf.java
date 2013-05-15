package com.serviceInterf;

import java.util.List;
import java.util.Map;

import com.pojo.Classes;

public interface ClassServiceInterf {
	
	/**
	 * author:高华锋
	 * function:根据专业号得到班级
	 * return:装了 班级的  list集合
	 * parameter:专业的编号*/
	public List<Map<String,String>> getClassesByMajor(int majorId,String nianfen);
	
	/**根据班级编号查询班级名称	*/
	public Classes getClassName(Short classNumber) ;
	
	/**根据班级名称得到班级	*/
	public Classes getClasses(String  className);

	/**保存class	*/
	public void addClass(Classes clazz);
	
}
