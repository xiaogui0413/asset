package com.xipunet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


	public class LoginFilter implements Filter {
		public void doFilter(ServletRequest request, ServletResponse response,
				FilterChain chain) throws IOException, ServletException {
			 //把ServletRequest和ServletResponse转换成真正的类型
	        HttpServletRequest req = (HttpServletRequest)request;
	        HttpSession session = req.getSession();

	        //由于web.xml中设置Filter过滤全部请求，可以排除不需要过滤的url
	        String requestURI = req.getRequestURI();
	        if(requestURI.endsWith("login.jsp")){
	            chain.doFilter(request, response);
	            return;
	        }

	        //判断用户是否登录，进行页面的处理
	        if(null == session.getAttribute("sessionUser")){
	            //未登录用户，重定向到登录页面
	        	req.getRequestDispatcher("/login.jsp").forward(req, response);
	            return;
	        } else {
	            //已登录用户，允许访问
	            chain.doFilter(request, response);
	        }
		}  

		public void init(FilterConfig fConfig) throws ServletException {
		}

		public void destroy() {
		}
	}





