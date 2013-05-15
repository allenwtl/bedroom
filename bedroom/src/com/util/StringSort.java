package com.util;

public class StringSort {

	public static String stringSort(String str){
		//创建一个新的字符串
		String returnBed="";
		char tempChar;
		//分解成数组
		char[] charBed = str.toCharArray();
		//for
		for(int i =0; i<charBed.length;i++){
			for(int m=i+1;m<charBed.length;m++){
				if(charBed[i]>charBed[m]){
					tempChar = charBed[i];
					charBed[i] = charBed[m];
					charBed[m] = tempChar;
				}
			}
			returnBed+= charBed[i];
		}
		return returnBed;
		//冒泡
		
	}
}
