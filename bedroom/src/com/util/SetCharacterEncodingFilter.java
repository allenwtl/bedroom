package com.util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SetCharacterEncodingFilter implements Filter {
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	protected boolean ignore = true;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		if (value == null)
			this.ignore = true;
		else if (value.equalsIgnoreCase("true"))
			this.ignore = true;
		else
			this.ignore = false;
	}
	public void doFilter(ServletRequest svlrequest, ServletResponse svlresponse,
			FilterChain chain) throws IOException, ServletException {
		// TODO �Զ���ɷ������
		 //��Servlet��������Ӧ����ת����HttpServlet��������Ӧ����
	       HttpServletRequest request=(HttpServletRequest)svlrequest;
	       HttpServletResponse response=(HttpServletResponse)svlresponse;
//	       String encoding="UTF-8";
//	       System.out.println(request.getRequestURL());
 		if (ignore || (request.getCharacterEncoding() == null)) {
			encoding= selectEncoding(request);
//			if (encoding != null)
//				request.setCharacterEncoding(encoding);
		}
		//�������ķ�ʽ(1.post or 2.get),��ݲ�ͬ����ʽ���в�ͬ����
	       String method = request.getMethod();
	       //1.��post��ʽ�ύ������,ֱ�����ñ���ΪUTF-8
	      
	       if(method.equalsIgnoreCase("post"))
	       {
//	    	   System.out.println(request.getRequestURL());
	           try
	           {
	              request.setCharacterEncoding(encoding);
	           } catch (UnsupportedEncodingException e)
	           {
	              e.printStackTrace();
	           }
	       }
	       //2.��get��ʽ�ύ������
	       else
	       {
//	    	   System.out.println(request.getRequestURL());
	           //ȡ���ͻ��ύ�Ĳ���
	           Enumeration<String> paramNames = request.getParameterNames();
	           //�������ȡ��ÿ���������Ƽ�ֵ
	           while(paramNames.hasMoreElements())
	           {
	              String name = paramNames.nextElement();//ȡ���������
//	              System.out.println("name:"+name);
	              String values[] = request.getParameterValues(name);//��ݲ������ȡ����ֵ
	              //������ֵ����Ϊ��
	              if(values != null)
	              {
	                  //������ֵ����ֻ��һ��ֵ
	                  if(values.length == 1)
	                  {
	                     try
	                     {
	                         //����toUTF(values[0])����,(values[0]����һ������ֵ)����ת������ֵ����Ԫ����                         
	                         String vlustr = toUTF(values[0]);
//	                         System.out.println(vlustr);
	                         //������ֵ�����Ե���ʽ����request
	                         request.setAttribute(name, vlustr);
	                     } catch (UnsupportedEncodingException e)
	                     {
	                         e.printStackTrace();
	                     }
	                  }
	                  //������ֵ�����ж��ֵ
	                  else
	                  {
	                     //�������ֵ��
	                     for(int i=0;i<values.length;i++)
	                     {
	                         try
	                         {
	                            //��Ȧ���ν�ÿ��ֵ����toUTF(values[i])����ת������ֵ����Ԫ����
	                            String vlustr=toUTF(values[i]);
	                            values[i] = vlustr;
//	                            System.out.println(vlustr);
	                         } catch (UnsupportedEncodingException e)
	                         {
	                            e.printStackTrace();
	                         }
	                     }
	                     //����ֵ�����Ե���ʽ����request
	                     request.setAttribute(name, values);
	                  }
	              }
	           }
	 
	       }
	        //������Ӧ��ʽ��֧�����ĵ���Ԫ��
//	       response.setContentType("text/html;charset=UTF-8");  
	 
	       //����ִ����һ��filter,��һ�¸�filter��ִ������
	       chain.doFilter(request, response);

	}
	/**
     * ��inStrתΪUTF-8�ı�����ʽ
     * @param inStr �����ַ�
     * @return UTF-8�ı�����ʽ���ַ�
     * @throws UnsupportedEncodingException
     */
    private String toUTF(String inStr) throws UnsupportedEncodingException
    {
       String outStr = "";
       if(inStr != null)
       {
           //outStr=java.net.URLDecoder.decode(inStr);//����decode��,�����ʱ����Ѿ��Զ�decode����
           //���ַ�תΪUTF-8������ʽ
           outStr = new String(inStr.getBytes("iso-8859-1"),encoding);         
       }
       return outStr;
    } 
	public void destroy() {
		// TODO �Զ���ɷ������
		this.encoding = null;
		this.filterConfig = null;
	}
	protected String selectEncoding(ServletRequest request) {
		return (this.encoding);
	}
}
