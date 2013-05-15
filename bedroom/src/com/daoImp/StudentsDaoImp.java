package com.daoImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.daoInterf.StudentsDaoInterf;
import com.pojo.Homenumber;
import com.pojo.Resume;
import com.pojo.Roomandstudents;
import com.pojo.Socialrelations;
import com.pojo.Students;
import com.util.StringUtil;

public class StudentsDaoImp extends HibernateDaoSupport implements StudentsDaoInterf {

private static final Log log = LogFactory.getLog(StudentsDaoImp.class);
	public int getNumberOfStudents() {
		System.out.println("框架成功");
		return 0;
	}


	public Students getStuById(String id) {
		String  sql = "select * from students where  students_id=?";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(sql,Students.class);
		query.setParameter(0,id);
		Students  students = (Students) query.list();
		return students;
	}
	
	public void insert2Home(Homenumber homenumber){
		String sql ="insert into homenumber(students_id,homenumber_title,homenumber_name,homenumber_political,homenumber_unit,homenumber_phone) values(?,?,?,?,?,?)";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(sql,Homenumber.class);
		query.setParameter(0, homenumber.getStudents().getStudentsId());
		query.setParameter(1, homenumber.getHomenumberTitle());
		query.setParameter(2,homenumber.getHomenumberName());
		query.setParameter(3, homenumber.getHomenumberPolitical());
		query.setParameter(4, homenumber.getHomenumberUnit());
		query.setParameter(5, homenumber.getHomenumberPhone());
		query.executeUpdate();
	}


	public List<Students> getStuByNum(String studentsNumber) {
		List<Students> stuList = new ArrayList<Students>();
		String  sql = "from Students t where t.studentsNumber = ?";
		try {
			stuList = this.getHibernateTemplate().find(sql,studentsNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(stuList.isEmpty()) return null;
		else   return stuList;
	}

	public Students findById(java.lang.Short id) {
		log.debug("getting Students instance with id: " + id);
		try {
			Students students = (Students) getHibernateTemplate().get(Students.class, id);
			return students;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<HashMap> getStudentsByClass(String classId) {
		String sql ="select room_number,room_sex,class_id,students_id,students_name,class_number,students_inroomtime,students_bed,students_sex,room_id,students_number  from roomandstudents r where r.class_id="+classId;
		SQLQuery query = getSession().createSQLQuery(sql);
		List<HashMap> rass = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return rass;
	}


	@Override
	public List<Map<String, String>> getStuBySex(String classes, String sex) {
		String sql = "select students_name,students_number,students_nativeplace,students_bed from students where class_number=? and students_sex=? and (ISNULL(students_bed) or students_bed='')";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter(0, classes);
		query.setParameter(1, sex);
		List<Map<String,String>> stus = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return stus;
	}


	public void updateStudent(Students students) {
		try {
			this.getHibernateTemplate().save(students);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新学生数据失败");
		}
		
		
	}


	public void saveRelation(Socialrelations socialrelations) {
		try {
			this.getHibernateTemplate().save(socialrelations);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("保存影响学生的个人信息    失败");
		}
		
	}


	public void saveDataFromExcel(Students students) {
		try {
			this.getHibernateTemplate().save(students);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("保存来之Exel表中的数据  失败");
		}
		
	}


	public void stuToRoom( List<String> studentsNumber,
			List<String> studentsBed, List<String> roomNumber) {
	
		for(int i = 0 ; i < studentsNumber.size() ; i++){	
			String sql = "update students set students_inroomtime=?,students_bed=?,room_id=? where students_number=?";
			SQLQuery query = getSession().createSQLQuery(sql);
			if(studentsBed.get(i)==null)
				query.setParameter(0,null);
			else
				query.setParameter(0, new Date());
			query.setParameter(1, studentsBed.get(i));
			query.setParameter(2, roomNumber.get(i));
			query.setParameter(3,studentsNumber.get(i));
			query.executeUpdate();
		}
		
	}


	public List<Map<String, String>> addStuOfRoom(String classes, String sex) {
		String sql = "select room_number,room_id,students_bed,students_number,students_name,students_nativeplace from roomandstudents " +
				"where class_id=? and students_sex=? and (students_bed<>'' or students_bed is not null)";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter(0,classes);
		query.setParameter(1,sex);
		List<Map<String,String>> students = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return students;
	}

	

}
