package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bed {

	public static Map<String,String> getBeds(List<String> r){

		
		Map<String,String> rooms = new HashMap<String,String>();		
		String reg = "([0-9]{3})室-([A-Z]{1})";
			String bed ="";
			String roomNum="";
			String roomTemp="";
			Map<String,String> map = new HashMap<String,String>();
			Pattern pattern = Pattern.compile(reg);
			for(int i =0; i<r.size();i++){
				Matcher matcher = pattern.matcher(r.get(i));
				while(matcher.find()){
					roomNum = matcher.group(1);
					if(!roomTemp.equals(roomNum)){
						if(roomTemp.equals(""))
							map.put(roomNum, "");
						else
							map.put(roomTemp, bed);
						roomTemp = roomNum;
						bed="";
						bed=matcher.group(2);
						
					}else{
						bed+=matcher.group(2);
					}
					
				}
			}
			map.put(roomNum,bed);
		return map;
	}
	

}
