package com.serviceImp;

import com.daoImp.RoomandBanjiDaoImp;
import com.serviceInterf.RoomandBanjiServiceInterf;

public class RoomandBanjiServiceImp implements RoomandBanjiServiceInterf {

	private RoomandBanjiDaoImp roomandbanjiDaoImp;

	public void setRoomandbanjiDaoImp(RoomandBanjiDaoImp roomandbanjiDaoImp) {
		this.roomandbanjiDaoImp = roomandbanjiDaoImp;
	}
}
