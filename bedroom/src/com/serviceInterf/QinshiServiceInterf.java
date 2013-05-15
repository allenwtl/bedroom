package com.serviceInterf;

import java.util.List;
import java.util.Map;

import com.pojo.Qinshi;

public interface QinshiServiceInterf {

	/**
	 * author:高华锋
	 * function:将新建的寝室放到数据库中    寝室名称   有几层  每层有几个宿舍
	 * return:
	 * parameter:dongs 名称  cengs有几层  ccengx每层有几个宿舍*/
	public Map createRoom(Integer dongs, Integer cengs, List<Integer> ccengx,Integer sex);
	
	/**
	 * author:高华锋
	 * function:得到所有的栋 然后发到页面   
	 * return:无
	 * parameter：无
	 * */
	public List<String> getDong();
}
