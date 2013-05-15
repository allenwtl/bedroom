package com.pojo;

/**
 * RoomstatusId entity. @author MyEclipse Persistence Tools
 */

public class RoomstatusId implements java.io.Serializable {

	// Fields

	private Short qinshiId;
	private Short roomId;
	private String roomNumber;
	private Boolean roomSex;
	private Short roomCeng;
	private Short roomPs;
	private Short roomFun;
	private Integer qinshiCeng;
	private String qinshiAddress;
	private String qinshiCengrooms;

	// Constructors

	/** default constructor */
	public RoomstatusId() {
	}

	/** minimal constructor */
	public RoomstatusId(Short qinshiId, Short roomId, String roomNumber,
			Boolean roomSex) {
		this.qinshiId = qinshiId;
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.roomSex = roomSex;
	}

	/** full constructor */
	public RoomstatusId(Short qinshiId, Short roomId, String roomNumber,
			Boolean roomSex, Short roomCeng, Short roomPs, Short roomFun,
			Integer qinshiCeng, String qinshiAddress, String qinshiCengrooms) {
		this.qinshiId = qinshiId;
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.roomSex = roomSex;
		this.roomCeng = roomCeng;
		this.roomPs = roomPs;
		this.roomFun = roomFun;
		this.qinshiCeng = qinshiCeng;
		this.qinshiAddress = qinshiAddress;
		this.qinshiCengrooms = qinshiCengrooms;
	}

	// Property accessors

	public Short getQinshiId() {
		return this.qinshiId;
	}

	public void setQinshiId(Short qinshiId) {
		this.qinshiId = qinshiId;
	}

	public Short getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Short roomId) {
		this.roomId = roomId;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Boolean getRoomSex() {
		return this.roomSex;
	}

	public void setRoomSex(Boolean roomSex) {
		this.roomSex = roomSex;
	}

	public Short getRoomCeng() {
		return this.roomCeng;
	}

	public void setRoomCeng(Short roomCeng) {
		this.roomCeng = roomCeng;
	}

	public Short getRoomPs() {
		return this.roomPs;
	}

	public void setRoomPs(Short roomPs) {
		this.roomPs = roomPs;
	}

	public Short getRoomFun() {
		return this.roomFun;
	}

	public void setRoomFun(Short roomFun) {
		this.roomFun = roomFun;
	}

	public Integer getQinshiCeng() {
		return this.qinshiCeng;
	}

	public void setQinshiCeng(Integer qinshiCeng) {
		this.qinshiCeng = qinshiCeng;
	}

	public String getQinshiAddress() {
		return this.qinshiAddress;
	}

	public void setQinshiAddress(String qinshiAddress) {
		this.qinshiAddress = qinshiAddress;
	}

	public String getQinshiCengrooms() {
		return this.qinshiCengrooms;
	}

	public void setQinshiCengrooms(String qinshiCengrooms) {
		this.qinshiCengrooms = qinshiCengrooms;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoomstatusId))
			return false;
		RoomstatusId castOther = (RoomstatusId) other;

		return ((this.getQinshiId() == castOther.getQinshiId()) || (this
				.getQinshiId() != null
				&& castOther.getQinshiId() != null && this.getQinshiId()
				.equals(castOther.getQinshiId())))
				&& ((this.getRoomId() == castOther.getRoomId()) || (this
						.getRoomId() != null
						&& castOther.getRoomId() != null && this.getRoomId()
						.equals(castOther.getRoomId())))
				&& ((this.getRoomNumber() == castOther.getRoomNumber()) || (this
						.getRoomNumber() != null
						&& castOther.getRoomNumber() != null && this
						.getRoomNumber().equals(castOther.getRoomNumber())))
				&& ((this.getRoomSex() == castOther.getRoomSex()) || (this
						.getRoomSex() != null
						&& castOther.getRoomSex() != null && this.getRoomSex()
						.equals(castOther.getRoomSex())))
				&& ((this.getRoomCeng() == castOther.getRoomCeng()) || (this
						.getRoomCeng() != null
						&& castOther.getRoomCeng() != null && this
						.getRoomCeng().equals(castOther.getRoomCeng())))
				&& ((this.getRoomPs() == castOther.getRoomPs()) || (this
						.getRoomPs() != null
						&& castOther.getRoomPs() != null && this.getRoomPs()
						.equals(castOther.getRoomPs())))
				&& ((this.getRoomFun() == castOther.getRoomFun()) || (this
						.getRoomFun() != null
						&& castOther.getRoomFun() != null && this.getRoomFun()
						.equals(castOther.getRoomFun())))
				&& ((this.getQinshiCeng() == castOther.getQinshiCeng()) || (this
						.getQinshiCeng() != null
						&& castOther.getQinshiCeng() != null && this
						.getQinshiCeng().equals(castOther.getQinshiCeng())))
				&& ((this.getQinshiAddress() == castOther.getQinshiAddress()) || (this
						.getQinshiAddress() != null
						&& castOther.getQinshiAddress() != null && this
						.getQinshiAddress()
						.equals(castOther.getQinshiAddress())))
				&& ((this.getQinshiCengrooms() == castOther
						.getQinshiCengrooms()) || (this.getQinshiCengrooms() != null
						&& castOther.getQinshiCengrooms() != null && this
						.getQinshiCengrooms().equals(
								castOther.getQinshiCengrooms())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getQinshiId() == null ? 0 : this.getQinshiId().hashCode());
		result = 37 * result
				+ (getRoomId() == null ? 0 : this.getRoomId().hashCode());
		result = 37
				* result
				+ (getRoomNumber() == null ? 0 : this.getRoomNumber()
						.hashCode());
		result = 37 * result
				+ (getRoomSex() == null ? 0 : this.getRoomSex().hashCode());
		result = 37 * result
				+ (getRoomCeng() == null ? 0 : this.getRoomCeng().hashCode());
		result = 37 * result
				+ (getRoomPs() == null ? 0 : this.getRoomPs().hashCode());
		result = 37 * result
				+ (getRoomFun() == null ? 0 : this.getRoomFun().hashCode());
		result = 37
				* result
				+ (getQinshiCeng() == null ? 0 : this.getQinshiCeng()
						.hashCode());
		result = 37
				* result
				+ (getQinshiAddress() == null ? 0 : this.getQinshiAddress()
						.hashCode());
		result = 37
				* result
				+ (getQinshiCengrooms() == null ? 0 : this.getQinshiCengrooms()
						.hashCode());
		return result;
	}

}