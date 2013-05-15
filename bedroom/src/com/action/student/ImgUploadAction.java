package com.action.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.kenai.jaffl.annotations.Out;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Students;
import com.serviceImp.StudentsServiceImp;

public class ImgUploadAction extends ActionSupport {
	
	private  StudentsServiceImp studentsServiceImp;

	public void setStudentsServiceImp(StudentsServiceImp studentsServiceImp) {
		this.studentsServiceImp = studentsServiceImp;
	}

	private File image;
	private String imageFileName;
	private String imageContentType;

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	
	//照片上传
	public String upLoad(){
		//得到照片存放的位置
		String  path  = ServletActionContext.getServletContext().getRealPath("/image");
		
		//从登陆的session里面得到学号
		if(image!=null){
			File  saveFile =  new File(new File(path),"10415400118."+imageContentType.substring(6));
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			try {
				InputStream is = new  FileInputStream(image);
				OutputStream out = new FileOutputStream(saveFile);
				
				byte[] buffer = new  byte[1024];
				int length =0;
				
				while((length = is.read(buffer))>0){
					out.write(buffer,0,length);
				}
				is.close();
				out.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return SUCCESS;
		}
		
		return null;
	}
	
	//显示照片
	public String getImg(){
		HttpServletResponse response = ServletActionContext.getResponse();
		
		//根据登陆session得到学号
		
		//根据学号查询图片的url
		Students student = studentsServiceImp.getStudentByNumber("10415400118");
		String  url = student.getStudentsImage();
		File imageFile = new File(url);
		
	
		try {
			if(imageFile.exists()){
				response.setContentType("image/jpeg; charset=GBK");
				InputStream is = new FileInputStream(imageFile);
				ServletOutputStream outputStream = response.getOutputStream();
				byte[] buffer = new byte[1024];
				int i= -1;
				while((i=is.read(buffer))!=-1){
					outputStream.write(buffer,0,i);
				}
				outputStream.flush();
				outputStream.close();
				is.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;
	}
}
