package com.daoImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.QinshiDaoInterf;
import com.pojo.Qinshi;

public class QinshiDaoImp extends HibernateDaoSupport implements QinshiDaoInterf {

	public Map createRoom(Integer dongs, Integer cengs, List<Integer> ccengx,Integer sex) {
		String s3   = "select qinshi_id from qinshi where qinshi_id="+dongs;
		SQLQuery q  = getSession().createSQLQuery(s3);
		List<HashMap> r = q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		if(r.size()==0){
			String sql = "insert into qinshi(qinshi_id,qinshi_ceng,qinshi_chuangwei,qinshi_1,qinshi_2,qinshi_3,qinshi_4," +
					"qinshi_5,qinshi_6,qinshi_7,qinshi_8,qinshi_sex) values("+dongs+","+cengs+","+4;
			String s ="";
			for (int i =0; i<8;i++) {
				if(i<=ccengx.size()-1)
				{
					s+= ","+ ccengx.get(i);
				}else{
					s+=",0";
				}
			}
			String s2 =sql +s+","+sex+")";
			SQLQuery query = getSession().createSQLQuery(s2);
			query.executeUpdate();
		
			Map<String,Integer> rooms = new HashMap<String,Integer>();
			rooms.put("dongs", dongs);
			rooms.put("cengs", cengs);
			for (int i =0; i<8;i++) {
				if(i<=ccengx.size()-1)
				{
					rooms.put("di"+(i+1), ccengx.get(i));
				}else{
					rooms.put("di"+(i+1), 0);
				}
			}
			
			return rooms;
		}else{
			System.out.println("已存在");
			return null;
	}
		
	}

	public List<String> getDong() {
		String sql  = "select qinshi_id	from Qinshi order by qinshi_id ";
		SQLQuery query = getSession().createSQLQuery(sql);
		 List<String> q =query.list();
		return q;
	}
}
