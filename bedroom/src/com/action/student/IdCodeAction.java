package com.action.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class IdCodeAction  extends ActionSupport {
	
	
	public  String  getIdCode(){
		HttpServletRequest request  = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
 		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random   random = new   Random();
		char[] code = new char[4];
		for(int i=0;i<4;i++){
			int n = random.nextInt(62);
			code[i] = str.charAt(n);
		}
		
		String  code2 = new String(code);
		request.getSession().setAttribute("code2", code2);
		
		//图片区域
		BufferedImage bufferedImage = new  BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		
		//产生绘图对象
		Graphics  g = bufferedImage.getGraphics();
		
		//填充区域
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 100, 30);
		
		//把验证码写在图片上
		g.setColor(Color.RED);//验证码的颜色
	    g.setFont(new Font("宋体",Font.BOLD,30));//验证码的字体的设置
	    //验证码一个个的写
		g.drawString(code[0]+"",10,20);
		g.drawString(code[1]+"", 30, 25);
	    g.drawString(code[2]+"", 50, 17);
	    g.drawString(code[3]+"", 70, 26);
		
	    //四根干扰线
	    g.setColor(Color.RED);
	    Random r  = new Random();
	    g.drawLine(r.nextInt(100), r.nextInt(30),r.nextInt(100), r.nextInt(30));
	    g.drawLine(r.nextInt(100), r.nextInt(30),r.nextInt(100), r.nextInt(30));
	    g.drawLine(r.nextInt(100), r.nextInt(30),r.nextInt(100), r.nextInt(30));
	    g.drawLine(r.nextInt(100), r.nextInt(30),r.nextInt(100), r.nextInt(30));
		
	    //产生jpeg格式,并发送到客户端
	    OutputStream out =null;
	    try {
			out = response.getOutputStream();
		    ImageIO.write(bufferedImage,"jpeg",out);
		    out.close();
	    } catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public  String   checkCode(){
		HttpServletRequest   request  = ServletActionContext.getRequest();
		HttpServletResponse  response = ServletActionContext.getResponse();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		
		String code  = request.getParameter("val");
		String code2 = (String) request.getSession().getAttribute("code2");
		try {
		if(!code2.equalsIgnoreCase(code))
			response.getWriter().print("验证码输入不正确");
		else 
			response.getWriter().print("OK");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;
	}
	
}
