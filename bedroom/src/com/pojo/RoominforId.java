package com.pojo;

/**
 * RoominforId entity. @author MyEclipse Persistence Tools
 */

public class RoominforId implements java.io.Serializable {

	// Fields

	private String roomNumber;
	private Boolean roomSex;
	private Short roomId;
	private Short classId;
	private Short majorId;
	private String majorName;
	private String collegeName;
	private String className;
	private Short collegeId;

	// Constructors

	/** default constructor */
	public RoominforId() {
	}

	/** full constructor */
	public RoominforId(String roomNumber, Boolean roomSex, Short roomId,
			Short classId, Short majorId, String majorName, String collegeName,
			String className, Short collegeId) {
		this.roomNumber = roomNumber;
		this.roomSex = roomSex;
		this.roomId = roomId;
		this.classId = classId;
		this.majorId = majorId;
		this.majorName = majorName;
		this.collegeName = collegeName;
		this.className = className;
		this.collegeId = collegeId;
	}

	// Property accessors

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

	public Short getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Short roomId) {
		this.roomId = roomId;
	}

	public Short getClassId() {
		return this.classId;
	}

	public void setClassId(Short classId) {
		this.classId = classId;
	}

	public Short getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Short majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Short getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Short collegeId) {
		this.collegeId = collegeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoominforId))
			return false;
		RoominforId castOther = (RoominforId) other;

		return ((this.getRoomNumber() == castOther.getRoomNumber()) || (this
				.getRoomNumber() != null
				&& castOther.getRoomNumber() != null && this.getRoomNumber()
				.equals(castOther.getRoomNumber())))
				&& ((this.getRoomSex() == castOther.getRoomSex()) || (this
						.getRoomSex() != null
						&& castOther.getRoomSex() != null && this.getRoomSex()
						.equals(castOther.getRoomSex())))
				&& ((this.getRoomId() == castOther.getRoomId()) || (this
						.getRoomId() != null
						&& castOther.getRoomId() != null && this.getRoomId()
						.equals(castOther.getRoomId())))
				&& ((this.getClassId() == castOther.getClassId()) || (this
						.getClassId() != null
						&& castOther.getClassId() != null && this.getClassId()
						.equals(castOther.getClassId())))
				&& ((this.getMajorId() == castOther.getMajorId()) || (this
						.getMajorId() != null
						&& castOther.getMajorId() != null && this.getMajorId()
						.equals(castOther.getMajorId())))
				&& ((this.getMajorName() == castOther.getMajorName()) || (this
						.getMajorName() != null
						&& castOther.getMajorName() != null && this
						.getMajorName().equals(castOther.getMajorName())))
				&& ((this.getCollegeName() == castOther.getCollegeName()) || (this
						.getCollegeName() != null
						&& castOther.getCollegeName() != null && this
						.getCollegeName().equals(castOther.getCollegeName())))
				&& ((this.getClassName() == castOther.getClassName()) || (this
						.getClassName() != null
						&& castOther.getClassName() != null && this
						.getClassName().equals(castOther.getClassName())))
				&& ((this.getCollegeId() == castOther.getCollegeId()) || (this
						.getCollegeId() != null
						&& castOther.getCollegeId() != null && this
						.getCollegeId().equals(castOther.getCollegeId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getRoomNumber() == null ? 0 : this.getRoomNumber()
						.hashCode());
		result = 37 * result
				+ (getRoomSex() == null ? 0 : this.getRoomSex().hashCode());
		result = 37 * result
				+ (getRoomId() == null ? 0 : this.getRoomId().hashCode());
		result = 37 * result
				+ (getClassId() == null ? 0 : this.getClassId().hashCode());
		result = 37 * result
				+ (getMajorId() == null ? 0 : this.getMajorId().hashCode());
		result = 37 * result
				+ (getMajorName() == null ? 0 : this.getMajorName().hashCode());
		result = 37
				* result
				+ (getCollegeName() == null ? 0 : this.getCollegeName()
						.hashCode());
		result = 37 * result
				+ (getClassName() == null ? 0 : this.getClassName().hashCode());
		result = 37 * result
				+ (getCollegeId() == null ? 0 : this.getCollegeId().hashCode());
		return result;
	}

}