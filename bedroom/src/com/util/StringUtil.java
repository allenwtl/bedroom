package com.util;

import java.util.List;

public class StringUtil {

	/**
	 * author高华锋
	 * function 将一个string的List集合拼成一个字符串
	 * parameter List
	 * return String*/
	public static String listToString(int leiXing,List str){
		
		String roomOfDong = "";
		String fuhao  ="'";
		//你想要''的
		if(leiXing==0)
			for(int j = 0 ; j < str.size();j++){
				roomOfDong+=fuhao+str.get(j)+fuhao+",";
			}
		else{
			fuhao="";
			for(int j = 0 ; j < str.size();j++){
				roomOfDong+=fuhao+str.get(j)+fuhao+",";
			}
		}
			
		return roomOfDong.substring(0,roomOfDong.length()-1);
	}
	
	public  static String replaceString(String juzi,String str1,String str2){
		//将str1替换成str2
		  return juzi.replace(str1, str2);
	}
	

}
