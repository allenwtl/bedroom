package com.daoInterf;

import java.util.List;

import com.pojo.Nation;

public interface NationDaoInterf {
	/**得到所有的民*/
	List<Nation> getAllNations();
	
	/**根据民族代号得到民族	*/
	public Nation getNationById(String dm);
	
	/**根据民族名称得到民族	*/
	public Nation getNationByName(String Name);
}
