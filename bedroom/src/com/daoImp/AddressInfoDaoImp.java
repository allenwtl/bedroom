package com.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.AdressInfoDaoInterf;
import com.pojo.City;
import com.pojo.District;
import com.pojo.Province;


public class AddressInfoDaoImp extends HibernateDaoSupport implements AdressInfoDaoInterf {
	
	@Override
	public List<City> getCts(String provinceId) {
		List<City> cityList = null;
		String sql = "from City where cityUpId=?";
		try {
			cityList = this.getHibernateTemplate().find(sql,provinceId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("一级城市查询失败");
		}
		if(cityList.isEmpty()) return null;
		else return cityList;
	}

	@Override
	public List<District> getDis(String cityId) {
		List<District> disList = null;
		String sql = "from District where districtUpId=?";
		try {
			disList = this.getHibernateTemplate().find(sql,cityId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询二级城市失败");
		}
		if(disList.isEmpty()) return null;
		else return disList;
	}

	@Override
	public List<Province> getPros() {
		List<Province> proList = null;
		String query = "from Province ";
		try {
			proList = this.getHibernateTemplate().find(query );
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询省级出错了");
		}
		if(proList.isEmpty()){
			return null;
		}else {
			return proList;
		}
	}


	public List<String> getCityIdByName(String city) {
		List<String> cityIdList = new ArrayList<String>();
		String sql = "select cityId from City where cityName=?";
		try {
			cityIdList = this.getHibernateTemplate().find(sql,city);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据市的名称查询市的编码失败");
		}
		if(cityIdList.isEmpty()){
			return null;
		}
		else return cityIdList;
	}

	public City getCityNameById(String id) {
		List<City> cityList = new ArrayList<City>();
		String sql = "from City t where t.cityId=?";
		try {
			cityList = this.getHibernateTemplate().find(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据市的id查询市的名称失败");
		}
		if(cityList.isEmpty()) return  null;
		else  return cityList.get(0);
	}

	public District getDistrictNameById(String id) {
		List<District>  disList = new ArrayList<District>();
		String  sql = "from District t where t.districtId=?";
		try {
			disList = this.getHibernateTemplate().find(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据县的id查询县的名称失败");
		}
		if(disList.isEmpty())  return null;
		else return disList.get(0);
	}

	public Province getProvinceNameById(String id) {
		List<Province> proList = new ArrayList<Province>();
		String  sql = "from Province t where t.provinceId=?";
		try {
			proList = this.getHibernateTemplate().find(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据省的id查询省的名称");
		}
		if(proList.isEmpty())   return null;
		else return proList.get(0);
	}

}

