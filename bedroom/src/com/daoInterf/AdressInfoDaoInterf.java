package com.daoInterf;

import java.util.List;

import com.pojo.City;
import com.pojo.District;
import com.pojo.Province;

public interface AdressInfoDaoInterf {
	/**查询所有的省	*/
	public List<Province> getPros();
	
	/**得到省中的一级城市	*/
	public List<City>   getCts(String provinceId);
	
	/**得到省中的二级城市	*/
	public List<District> getDis(String cityId);
	
	
	/**根据市的名称查询市的编码	*/
	public List<String> getCityIdByName(String city);
	
	/**根据省的id查询省的名称	*/
	public  Province  getProvinceNameById(String  id);
	
	/**	根据市的id查询市的名称*/
	public  City      getCityNameById(String id);
	
	/**	根据县的id查询县的名称*/
	public  District   getDistrictNameById(String id);

}
