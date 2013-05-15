package com.util;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BaseInfor {

	public static List<String> xueYear;
	private static String beds = "ABCDEFGHIJKLMNOPQISTUVWXYZ";
	
	public static String getBeds() {
		return beds;
	}

	public static List<String> getXueYear(){
		xueYear = new ArrayList<String>();
		Date d = new Date();
		for(int i = 0;i<4; i++){
			if(d.getMonth()+1<9){
				xueYear.add(d.getYear()+1900-4+i+"级");
			}
			else{
				xueYear.add(d.getYear()+1900-3+i+"级");
			}
		}
		return xueYear;
	}
	
	public static void main(String[] args) {
		System.out.println(new Date().getYear());
	}

}
