package com.serviceImp;


import com.daoImp.Leave1DaoImp;
import com.daoImp.LeavetypeDaoImp;
import com.daoImp.StudentsDaoImp;
import com.daoImp.TeacherDaoImp;
import com.model.Leave1Vo;
import com.pojo.Leave1;
import com.serviceInterf.Leave1ServiceInterf;

public class Leave1ServiceImp implements Leave1ServiceInterf {
	private Leave1DaoImp leave1DaoImp;
	
	private TeacherDaoImp teacherDaoImp;
	private LeavetypeDaoImp leavetypeDaoImp;
	private StudentsDaoImp studentsDaoImp;
	

	public void setTeacherDaoImp(TeacherDaoImp teacherDaoImp) {
		this.teacherDaoImp = teacherDaoImp;
	}

	public void setLeavetypeDaoImp(LeavetypeDaoImp leavetypeDaoImp) {
		this.leavetypeDaoImp = leavetypeDaoImp;
	}

	public void setStudentsDaoImp(StudentsDaoImp studentsDaoImp) {
		this.studentsDaoImp = studentsDaoImp;
	}

	public void setLeave1DaoImp(Leave1DaoImp leave1DaoImp) {
		this.leave1DaoImp = leave1DaoImp;
	}

	public void registLeave1(Leave1Vo le1vo) {

		Leave1 po = new Leave1();
		System.out.println(teacherDaoImp.findById(Short.valueOf(le1vo.getTeacher())).getTeacherName());
		System.out.println(leavetypeDaoImp.findById(Byte.valueOf(le1vo.getLeavetype())).getLeavetypeDays());
		
		System.out.println(le1vo.getStudents());
		//System.out.println(studentsDaoImp.findById(Short.valueOf(le1vo.getStudents())).getPhonelists());
		//DozerBeanMapper beanmap = new DozerBeanMapper();		
		//beanmap.map(le1vo,po);
		po.setLeaveXiaojiastatus(true);
		po.setLeaveIsxiaojia(true);
		po.setLeaveBegintime(new java.sql.Timestamp(le1vo.getLeaveBegintime().getTime()));
		po.setLeaveEndtime(new java.sql.Timestamp(le1vo.getLeaveEndtime().getTime()));
		po.setLeaveTeachertime(new java.sql.Timestamp(le1vo.getLeaveTeachertime().getTime()));
		po.setLeaveTime(new java.sql.Timestamp(le1vo.getLeaveTime().getTime()));
		
		po.setLeaveReason(le1vo.getLeaveReason());
		po.setLeaveAddress(le1vo.getLeaveAddress());
		po.setTeacher(teacherDaoImp.findById(Short.valueOf(le1vo.getTeacher())));//要转换
		po.setLeavetype(leavetypeDaoImp.findById(Byte.valueOf(le1vo.getLeavetype())));
		po.setStudents(studentsDaoImp.findById(Short.valueOf(le1vo.getStudents())));
		leave1DaoImp.save(po);

	}

}
