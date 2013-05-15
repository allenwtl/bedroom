package com.action.student;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.City;
import com.pojo.District;
import com.pojo.Province;
import com.serviceImp.AddressInfoServiceImp;

public class AddressAction extends ActionSupport {
	private AddressInfoServiceImp addressInfoServiceImp;
	public void setAddressInfoServiceImp(AddressInfoServiceImp addressInfoServiceImp) {
		this.addressInfoServiceImp = addressInfoServiceImp;
	}
	
	//查询省的代码
	public String getPro() throws IOException{
		List<Province>  list =  addressInfoServiceImp.getProvince();
		if(list==null){
			ServletActionContext.getResponse().getWriter().print("");
			return null;
		}
		
		StringBuilder  sb = new StringBuilder();
		sb.append("[");
		int len  = list.size();
		for(int i=0;i<len;i++){
			if(i==len-1){
				sb.append("{id:'").append(list.get(i).getProvinceId());
				sb.append("',name:'").append(list.get(i).getProvinceName()).append("'}");
			}else {
				sb.append("{id:'").append(list.get(i).getProvinceId());
				sb.append("',name:'").append(list.get(i).getProvinceName()).append("'},");
			}
		}
		
		sb.append("]");
		
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(sb);
		return null;
	}
	
	
	//查询市的代码开始
	public String  getCity() throws IOException{
		String provinceId = ServletActionContext.getRequest().getParameter("province");
		List<City> cityList =  addressInfoServiceImp.getCity(provinceId);
		if(cityList==null){
			ServletActionContext.getResponse().getWriter().print("");
			return null;
		} 
		
		StringBuilder  sb = new StringBuilder();
		sb.append("[");
		int length =cityList.size();
		for(int i=0;i<length;i++){
			if(i==length-1){
				sb.append("{id:'").append(cityList.get(i).getCityId());
				sb.append("',name:'").append(cityList.get(i).getCityName()).append("'}");
			}else {
				sb.append("{id:'").append(cityList.get(i).getCityId());
				sb.append("',name:'").append(cityList.get(i).getCityName()).append("'},");
			}
		}
		sb.append("]");
		
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(sb);
		System.out.println(sb);
		return null;
	}
	
	//查询县级城市
	public String getDis() throws IOException{
		String cityId = ServletActionContext.getRequest().getParameter("city");
		List<District> disList = addressInfoServiceImp.getDistricts(cityId);
		if(disList==null)
		{
			ServletActionContext.getResponse().getWriter().print("");
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int length = disList.size();
		for(int i=0;i<length;i++){
			if(i==length-1){
				sb.append("{id:'").append(disList.get(i).getDistrictId());
				sb.append("',name:'").append(disList.get(i).getDistrictName()).append("'}");
			}else {
				sb.append("{id:'").append(disList.get(i).getDistrictId());
				sb.append("',name:'").append(disList.get(i).getDistrictName()).append("'},");
			}
		}
		sb.append("]");
		
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(sb);
		System.out.println(sb);
		return null;
	}
	
	
}
