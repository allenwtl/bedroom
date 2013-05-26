package com.serviceInterf;

import java.util.List;

import com.pojo.Political;

public interface PoliticalServiceInter {
	/**得到所有的政治面貌	*/
	List<Political> getAllPoliticals();
	
	/**根据代码查询政治面貌	*/
	Political getPoliticalByNumber(String  number);
	
	/**根据名称查询政治面貌	*/
	Political getPoliticalByName(String name);
}
