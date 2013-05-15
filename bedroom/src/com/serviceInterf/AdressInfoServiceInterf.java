package com.serviceInterf;

import java.util.List;

import com.pojo.City;
import com.pojo.District;
import com.pojo.Province;

public interface AdressInfoServiceInterf {
	
   /**查询中国的各个省	*/
	public List<Province> getProvince();
	
   /**查询每个省中的一级城市	*/
	public List<City>  getCity(String provinceId);
	
   /**查询二级城市	*/
	public List<District> getDistricts(String cityId);

	
	/**根据市的名称查询市的编码	*/
	public List<String> getCityId(String city);
	
	/**根据省的id查询省的名称	*/
	public  Province  getProvinceNameById(String  id);
	
	/**	根据市的id查询市的名称*/
	public  City      getCityNameById(String id);
	
	/**	根据县的id查询县的名称*/
	public  District   getDistrictNameById(String id);
}
