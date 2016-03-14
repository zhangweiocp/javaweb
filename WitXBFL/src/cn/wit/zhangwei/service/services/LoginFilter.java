package cn.wit.zhangwei.service.services;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.zhangwei.entity.User;

public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// ��������������Ҫ�õ�request��response��session����
		HttpServletRequest servletRequest = (HttpServletRequest)request;
		HttpServletResponse servletResponse = (HttpServletResponse)response;
		HttpSession session = servletRequest.getSession();
		
		// ����û������URI
		String path = servletRequest.getRequestURI();
		
		// ��session��ȡ���û���Ϣ
		User userInfo = (User)session.getAttribute("user");
		
		/*������Constants.java,����д����������˵�ҳ��
		 * for(int i = 0;i < Constants.NoFilter_Pages.length; i++){
		 * 	if(path.indexOf(Constants.NoFilter_Pages[i]) > -1){
		 * 		chain.doFilter(servletRequest,servletResponse);
		 * 		return;
		 * 	}
		 * }*/
		
		// ��½ҳ���������
		if(path.indexOf("login.action") > -1){
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		
		//�ж����û��ȡ���û���Ϣ������ת����½ҳ��
		if(null == userInfo){
			servletResponse.sendRedirect("login.action");
		}else{
			//�Ѿ���½�������˴�����
			chain.doFilter(servletRequest, servletResponse);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
