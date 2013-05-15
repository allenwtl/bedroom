package com.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daoImp.QinshiDaoImp;
import com.pojo.Qinshi;
import com.serviceInterf.QinshiServiceInterf;

public class QinshiServiceImp implements QinshiServiceInterf {

	private QinshiDaoImp qinshiDaoImp;

	public void setQinshiDaoImp(QinshiDaoImp qinshiDaoImp) {
		this.qinshiDaoImp = qinshiDaoImp;
	}

	public Map<String,Integer> createRoom(Integer dongs, Integer cengs, List<Integer> ccengx,Integer sex) {
		Map<String,Integer> rooms = new HashMap<String,Integer>();
		try{
			rooms = qinshiDaoImp.createRoom(dongs,cengs,ccengx,sex);
		}catch(Exception e){
			System.out.println("QinshiServiceImp 20");
			e.printStackTrace();
			return null;
		}
		return rooms;
	}

	@Override
	public List<String> getDong() {
		try{
			return qinshiDaoImp.getDong();
		}catch(Exception e){
			System.out.println("qishiServiceImp出错了  第36行");
			e.printStackTrace();
			return null;
		}
	}


}
