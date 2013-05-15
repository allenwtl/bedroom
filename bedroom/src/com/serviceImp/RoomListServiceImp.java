package com.serviceImp;

import com.daoImp.RoomListDaoImp;
import com.serviceInterf.RoomListServiceInterf;

public class RoomListServiceImp implements RoomListServiceInterf {

	private RoomListDaoImp roomListDaoImp;

	public void setRoomListDaoImp(RoomListDaoImp roomListDaoImp) {
		this.roomListDaoImp = roomListDaoImp;
	}
}
