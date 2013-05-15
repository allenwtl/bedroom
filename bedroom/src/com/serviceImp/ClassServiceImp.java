package com.serviceImp;

import java.util.List;
import java.util.Map;

import com.daoImp.ClassDaoImp;
import com.pojo.Classes;
import com.serviceInterf.ClassServiceInterf;

public class ClassServiceImp implements ClassServiceInterf {

	private ClassDaoImp classDaoImp;

	public void setClassDaoImp(ClassDaoImp classDaoImp) {
		this.classDaoImp = classDaoImp;
	}


	public List<Map<String,String>> getClassesByMajor(int majorId,String nianfen) {
		try{
			return classDaoImp.getClassesByMajor(majorId,nianfen);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("classServiceImp 23行");
			return null;
		}
		
	}


	@Override
	public Classes getClassName(Short classNumber) {
		return classDaoImp.getClassName(classNumber);
	}


	@Override
	public Classes getClasses(String className) {
		return classDaoImp.getClasses(className);
	}


	@Override
	public void addClass(Classes clazz) {
		classDaoImp.addClass(clazz);
	}
}
