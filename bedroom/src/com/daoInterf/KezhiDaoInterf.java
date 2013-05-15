package com.daoInterf;

import java.util.List;

import com.pojo.Kezhi;

public interface KezhiDaoInterf {
	/**根据kezhi的主键查询kezhi	*/
	Kezhi getKezhi(Short id);
	
	/**查询专业的所有的类型	*/
	List<Kezhi> getAllKezhi();
	
}
