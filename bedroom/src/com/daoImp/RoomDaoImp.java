package com.daoImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.daoInterf.RoomDaoInterf;
import com.pojo.Qinshi;
import com.pojo.Room;
import com.pojo.RoomandstudentsId;
import com.pojo.Roominfor;
import com.util.BaseInfor;
import com.util.Bed;
import com.util.StringSort;
import com.util.StringUtil;

public class RoomDaoImp extends HibernateDaoSupport implements RoomDaoInterf {

	@SuppressWarnings("unchecked")
	public List<Roominfor> addRoomToCollege(List<Room> r, int classId,Map<String,String> beds) {
		for (Room r1 : r) {
			String sql = "select room_number from room where room_number=?";
			SQLQuery query = getSession().createSQLQuery(sql);
			query.setParameter(0, r1.getRoomNumber());
			List list = query.list();
			
			if (list.size() == 0) {
				getHibernateTemplate().save(r1);
			} else {
				System.out.println("已存在");
			}
		}
		List<String> bb =new ArrayList<String>();
		String reg="[0-9]{1,2}-([0-9]{3})";
		String roomNumber = "'" + "0" + "'";
		for (Room ro : r) {
			roomNumber = roomNumber + ",'" + ro.getRoomNumber() + "'";
			Pattern patter = Pattern.compile(reg);
			Matcher matcher= patter.matcher(ro.getRoomNumber());
			while(matcher.find()){
				bb.add(beds.get(matcher.group(1)));
			}
		}
		String hql = "select room_id from room  where room_number in("
				+ roomNumber + ")";
		SQLQuery query3 = getSession().createSQLQuery(hql);
		List<Short> roomIds = query3.list();
		
		

		String ids = "0";
		for (int i = 0; i < r.size(); i++) {
			String sql2 = "select r.room.roomId,r.classes.classId,r.bed from Roomandbanji r where r.room.roomId=? and r.classes.classId=? and r.bed=?";
			Query query2 = getSession().createQuery(sql2);
			query2.setParameter(0, roomIds.get(i));
			query2.setParameter(1, (short) classId);
			query2.setParameter(2, bb.get(i));
			List list = query2.list();
			int a  = list.size();
			if (list.size()==0) {
				ids = ids + "," + roomIds.get(i);
				String sql3= "delete from roomandbanji where room_id=? and class_id=?";
				SQLQuery query4 = getSession().createSQLQuery(sql3);
				query4.setParameter(0, roomIds.get(i));
				query4.setParameter(1, classId);
				query4.executeUpdate();
				String sql = "insert into roomandbanji (room_id,class_id,bed) values(?,?,?)";
				SQLQuery query = getSession().createSQLQuery(sql);
				query.setParameter(0, roomIds.get(i));
				query.setParameter(1, classId);
				query.setParameter(2, bb.get(i));
				query.executeUpdate();
			} else {
				System.out.println("已存在");
			}
		}

		String hql2 = "from Roominfor as r where r.id.roomId in(" + ids
				+ ") and r.id.classId=" + classId;
		Query query = getSession().createQuery(hql2);
		List<Roominfor> roomInfors = (query.list());
		return roomInfors;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void deletedeleteRoomNumber(String roomNumber, String classId) {
		String hql = "from Room r where r.roomNumber='" + roomNumber + "'";
		Query query = getSession().createQuery(hql);
		List<Room> rooms = query.list();
		for (Room r : rooms) {
			String sql2 = "delete from roomandbanji where room_id="
					+ r.getRoomId() + " and class_id=" + classId;
			SQLQuery query2 = getSession().createSQLQuery(sql2);
			query2.executeUpdate();
			sql2 = "delete from room where room_id=" + r.getRoomId();
			query2 = getSession().createSQLQuery(sql2);
			query2.executeUpdate();
		}
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<String> selectChuangWei(String roomNumber, String classId) {
		List<String> reBedList = new ArrayList<String>();
		String sql = "select room_number,class_id,bed,room_ps from roominfor where room_number='"+roomNumber+"'";

		SQLQuery query= getSession().createSQLQuery(sql);
		List<HashMap> chuangWei = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		String compareBed="";
		String returnBed ="";
		String quanBed	 ="";
		int ps = new Integer(chuangWei.get(0).get("room_ps").toString());
		
		for(int i =0 ; i < ps ; i++){
			quanBed+= BaseInfor.getBeds().substring(i, i+1);
			
		}
		String compareBedStr = "";
		for (HashMap c : chuangWei) {
			//吧各种 c。get(bed)取出来 拼接起来  有重复的 comparebed
			if(c.get("bed")==null)
				compareBedStr="";
			else
				compareBedStr = c.get("bed").toString();
			compareBed += compareBedStr;
		}
		//for()4
		for(int i =0;i<quanBed.length();i++){
		//compareBEd  是否包含  quanbed中的字母   不不含拼接  到 returnbed
			if(!compareBed.contains(quanBed.substring(i,i+1)))
				returnBed +=quanBed.subSequence(i,i+1);
		}
		//sql语句  查询出room_number 和classid 的床位号
		sql = "select bed,room_number,class_id from roominfor where room_number='"+roomNumber+"' and class_id="+classId;
		query = getSession().createSQLQuery(sql);
		List<Map> m = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		//为null   这个先来     直接返回returnbed
		if(m.size()==0){
			reBedList.add("");
			reBedList.add(returnBed);
			return reBedList;
		}
		//有值     c.get+returnbed  然后返回
		reBedList.add(m.get(0).get("bed").toString());
		String s = m.get(0).get("bed").toString()+returnBed;
		reBedList.add(StringSort.stringSort(s));
		return reBedList;
		//在排个序吧
	
	}
	
	@Override
	public List<Map> getRoomsByClass(String classId) {
		//寝室号 床位 学号姓名 班级
		String sql ="select room_number,room_sex,class_id,students_name,students_number," +
				"students_bed,students_sex from roomandstudents where class_id="+classId;
		SQLQuery query = getSession().createSQLQuery(sql);
		List<Map> map = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return map;
	}

	@Override
	public List getEmptyRoom(String dongs, String classes,String cengs, String sex) {
		String sql = "select class_id,qinshi_id,room_number,room_sex,room_ceng,room_ps,room_fun from roominfor where qinshi_id=? and room_sex=? and room_ceng=?  order by room_number";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter(0, dongs);
		query.setParameter(1, sex);
		query.setParameter(2,cengs);

		List<Map<String,String>> map  = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		
		//代表第几栋  
		List<List> xiangOfDong = new ArrayList<List>(); 
			

			//代表第一层中的  寝室们
		List xiangOfRooms = new ArrayList();
			
			for(int m=0;m<map.size();m++){
				List<String> xiangOfChuang = new ArrayList<String>();
				String roomNumber2 = map.get(m).get("room_number");
				
				String sql2 = "select distinct(college_name) from roominfor where room_number='"+roomNumber2+"'";
				List<String> cNameList = getSession().createSQLQuery(sql2).list();
				xiangOfChuang = selectChuangWei(roomNumber2, classes);
				String colAndClass= "";
				for (String string : cNameList) {
					String sql3 = "select distinct(class_name) from roomInfor where college_name='"+string+"' and room_number='"+roomNumber2+"'";
					List<String>  classNameList  = getSession().createSQLQuery(sql3).list();
					//得到学院的名称
					//下面是操作把班级
					String className = "";
					for (int n=0;n<classNameList.size();n++) {
						if(classNameList.size()-1==n)
							className+=classNameList.get(n);
						else
							className+=classNameList.get(n)+",";
					}
					colAndClass+=(string+"-"+className)+";</br>";
					
				}
				
				xiangOfChuang.add(0,colAndClass);
				xiangOfChuang.add(0, roomNumber2);
				xiangOfChuang.add(0,cengs);
				xiangOfRooms.add(xiangOfChuang);
			}
			xiangOfDong.add(xiangOfRooms);
		
		return xiangOfDong;
			
	}

	public Integer getCengOfDong(String dongs) {
		String sql = "select qinshi_ceng from qinshi where qinshi_id="+dongs;
		Integer ceng = (Integer) getSession().createSQLQuery(sql).list().get(0);
		return ceng;
	}

	public void addRoomToClass(List<String> rooms, List<String> chuangs,
			String classes) {
		String sql="";
		int i =0;
		for (String r : rooms) {
			sql = "select distinct (room_id) from roominfor where room_number='"+r+"'";
			Object o = getSession().createSQLQuery(sql).uniqueResult();
			
			String roomId= o.toString();
			sql = "select roomandbanji_id from roomandbanji where room_id="+roomId+" and class_id="+classes;
			Object o2 = getSession().createSQLQuery(sql).uniqueResult();
			if(o2==null){
				String sql2 = "insert into roomandbanji(room_id,class_id,bed) values(?,?,?)";
				SQLQuery query = getSession().createSQLQuery(sql2);
				query.setParameter(0, roomId);
				query.setParameter(1, classes);
				query.setParameter(2,chuangs.get(i));
				query.executeUpdate();
			}else{
				String sql2 = "update roomandbanji set bed=? where room_id=? and class_id="+classes;
				SQLQuery query = getSession().createSQLQuery(sql2);
				query.setParameter(0,chuangs.get(i));
				query.setParameter(1,roomId);
				query.executeUpdate();
			}
			
			i++;
		}
	}

	public List<Map<String, String>> getInforOfDong(String dong) {
		String sql = "select qinshi_id,qinshi_ceng,qinshi_address,qinshi_cengrooms from qinshi where qinshi_id=?";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter(0, dong);
		List<Map<String,String>> dongs = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return dongs;
	}

	public List<Map<String, String>> getRoomOfCeng(String dong, String hang) {
		
		String sql = "select room_number,room_sex,room_ps,room_fun,room_ceng from roomstatus where qinshi_id=? and room_ceng =? order by room_number";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter(0, dong);
		query.setParameter(1, hang);
		List<Map<String,String>> rooms = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return rooms;
	}

	
	public int createDong(String dong, List<String> room, String address,
			List<String> roomNum, List<String> roomSex, List<String> roomPs,
			List<String> roomFunc) {
		
			String s1 		= "select qinshi_id from qinshi where qinshi_id="+dong;
			List<String> s  = getSession().createSQLQuery(s1).list();
			//共有多少层楼
			int cengs = room.size();
			
			//每一层有多少个宿舍的集合
			String cengrooms = room.toString().substring(1,room.toString().length()-1);
			String userRooms = "";
			for(int m  =  0 ; m < room.size() ; m ++){
				userRooms += room.get(m).trim()+",";
			}
			userRooms = userRooms.substring(0,userRooms.length()-1);
			
			
			if(s.size()==0){
			
					String sql = "insert into qinshi(qinshi_id,qinshi_ceng,qinshi_address,qinshi_cengrooms) values(?,?,?,?)";
					SQLQuery query = getSession().createSQLQuery(sql);
					query.setParameter(0, dong);
					query.setParameter(1, cengs);
					query.setParameter(2,address);
					query.setParameter(3,userRooms);
					int i = query.executeUpdate();
					
					//开始插入room
					String[] cRooms = cengrooms.split(",");
					int ci   = 0;
					int ceng = 1;
					int c    = new Integer(cRooms[0]);
					
					for(int j =0; j < roomNum.size(); j++){
						if((j+1)>c){
							ci++;
							ceng++;
							c+= new Integer(cRooms[ci].trim());
						}
						String ps = roomPs.get(j);
						int func = roomFunc.get(j).equals("学")?1:roomFunc.get(j).equals("管")?2:3;
						String sql2 = "insert into room(room_number,room_sex,room_ceng,qinshi_id,room_ps,room_fun)" +
								"values('"+roomNum.get(j)+"',?,?,?,?,?)";
						int sex = roomSex.get(j).equals("男")?1:2;
						
						SQLQuery query2  = getSession().createSQLQuery(sql2);
					
						query2.setParameter(0,sex);
						query2.setParameter(1,ceng);
						query2.setParameter(2, dong);
						query2.setParameter(3,ps);
						query2.setParameter(4, func);
						query2.executeUpdate();
							
					}
					return i;
		}else{
			String updateQinShi = "update qinshi set qinshi_ceng=?,qinshi_address=?, qinshi_cengrooms=? where qinshi_id=?";
			SQLQuery updateQquery = getSession().createSQLQuery(updateQinShi);
			updateQquery.setParameter(0,cengs);
			updateQquery.setParameter(1,address);
			updateQquery.setParameter(2,userRooms);
			updateQquery.setParameter(3, dong);
			updateQquery.executeUpdate();
			String roomOfDong = "";
			for(int j = 0 ; j < roomNum.size();j++){
				String cRoomExit = " select room_id from room where room_number='"+roomNum.get(j)+"'";
				List<String> rooms = getSession().createSQLQuery(cRoomExit).list();
				//判断该宿舍是否存在
				if(rooms.size()!=0){
					
					String[] cRooms = cengrooms.split(",");
					int ci   = 0;
					int ceng = 1;
					int c    = new Integer(cRooms[0]);
					
					
						if((j+1)>c){
							ci++;
							ceng++;
							
							c+= new Integer(cRooms[ci].trim());
						}
						String ps = roomPs.get(j);
						int func = roomFunc.get(j).equals("学")?1:roomFunc.get(j).equals("管")?2:3;
						int sex = roomSex.get(j).equals("男")?1:2;
						
						String updateRoom = "update room set room_sex="+sex+",room_ceng=?,room_ps=?,room_fun=? where room_number='"+roomNum.get(j)+"'";
						SQLQuery updateRSQL = getSession().createSQLQuery(updateRoom);
						updateRSQL.setParameter(0,ceng);
						updateRSQL.setParameter(1,ps);
						updateRSQL.setParameter(2,func);
						updateRSQL.executeUpdate();
					
				}else{
					
					String[] cRooms = cengrooms.split(",");
					int ci   = 0;
					int ceng = 1;
					int c    = new Integer(cRooms[0]);
					
					
						if((j+1)>c){
							ci++;
							ceng++;
							
							c+= new Integer(cRooms[ci].trim());
						}
						String ps = roomPs.get(j);
						int func = roomFunc.get(j).equals("学")?1:roomFunc.get(j).equals("管")?2:3;
						int sex = roomSex.get(j).equals("男")?1:2;
						
						
						String insertRoom = "insert into room(room_number,room_sex,room_ceng,qinshi_id,room_ps,room_fun)" +
						"values(?,?,?,?,?,?)";
						SQLQuery query2  = getSession().createSQLQuery(insertRoom);
						query2.setParameter(0, roomNum.get(j));
						query2.setParameter(1,sex);
						query2.setParameter(2,ceng);
						query2.setParameter(3, dong);
						query2.setParameter(4,ps);
						query2.setParameter(5, func);
						query2.executeUpdate();
					
					}
					
				
				
			}
			
			
			deleteRooms(roomNum,dong);
			
			return 0;
		}
	}
	
	
	public void deleteRooms(List<String> roomNum,String dong){
		deleteJiOfRoomAndBanJi(1, roomNum);
		deleteJiOfRoom(1, roomNum);
	}
	
	public void deleteJiOfRoom(int status,List<String> roomNum){
		String rooms = StringUtil.listToString(0,roomNum);
		//0表示 in   1表示not in
		String sql = "delete from room where room_number";
		if(status==0){
			sql+=" in("+rooms+")";
		}else{
			sql+=" not in("+rooms+")";
		}
		SQLQuery query = getSession().createSQLQuery(sql);
		query.executeUpdate();
	}
	
	public void deleteJiOfRoomAndBanJi(int status,List<String> roomNum){
		String rooms = StringUtil.listToString(0,roomNum);
		String sql2  =  "select room_id from room where room_number in("+rooms+")";
		SQLQuery query2 = getSession().createSQLQuery(sql2);
		List<String> ids = query2.list();
		
		String idStr = StringUtil.listToString(1,ids);
		 
		//0表示 in   1表示not in
		String sql = "delete from roomandbanji where room_id";
		if(status==0){
			sql+=" in("+idStr+")";
		}else{
			sql+=" not in("+idStr+")";
		}
		SQLQuery query = getSession().createSQLQuery(sql);
		
		query.executeUpdate();
			
	}

	public List<Map<String, String>> getRoom(String classes, String sex) {
		String getRoom = "select room_id,bed,room_number,room_ps,room_sex,class_name,college_name from roominfor where class_id=? and room_sex=? order by room_number";
		SQLQuery query = getSession().createSQLQuery(getRoom);
		query.setParameter(0,classes);
		query.setParameter(1,sex);
		List<Map<String,String>> rooms = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return rooms;
	}

	public RoomandstudentsId getRoomandstudents(Short id) {
		List<RoomandstudentsId> list = null;
		String sql = "from RoomandstudentsId where roomId=?";
		try {
			list = this.getHibernateTemplate().find(sql , id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return list.get(0);
	}
	
	
	
	
	
	
}
	
	
