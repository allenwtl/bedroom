package com.serviceInterf;

import java.util.List;

import com.pojo.Kezhi;

public interface KezhiServiceInterf {
	
	/**根据kezhi的主键查询kezhi	*/
	Kezhi getKezhi(Short id);

	/**得到专业的所有类型*/
	List<Kezhi>  getAllKezhi();
}
