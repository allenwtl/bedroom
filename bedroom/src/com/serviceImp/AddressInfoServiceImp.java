package com.serviceImp;

import java.util.List;

import com.daoImp.AddressInfoDaoImp;
import com.pojo.City;
import com.pojo.District;
import com.pojo.Province;
import com.serviceInterf.AdressInfoServiceInterf;

public class AddressInfoServiceImp implements AdressInfoServiceInterf {
	private AddressInfoDaoImp addressInfoDaoImp;

	public void setAddressInfoDaoImp(AddressInfoDaoImp addressInfoDaoImp) {
		this.addressInfoDaoImp = addressInfoDaoImp;
	}

	@Override
	public List<City> getCity(String provinceId) {
		List<City> cityList = addressInfoDaoImp.getCts(provinceId);
		return cityList;
	}

	@Override
	public List<District> getDistricts(String cityId) {
		List<District>  disList = addressInfoDaoImp.getDis(cityId);
		return disList;
	}

	@Override
	public List<Province> getProvince() {
		List<Province> proList = addressInfoDaoImp.getPros();
		return proList;
	}


	public List<String> getCityId(String city) {
		return addressInfoDaoImp.getCityIdByName(city);
		
	}

	@Override
	public City getCityNameById(String id) {
		return addressInfoDaoImp.getCityNameById(id);
	}

	@Override
	public District getDistrictNameById(String id) {
		return addressInfoDaoImp.getDistrictNameById( id);
	}

	@Override
	public Province getProvinceNameById(String id) {
		return addressInfoDaoImp.getProvinceNameById( id);
	}

}
