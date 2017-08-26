package com.xipunet.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xipunet.commons.PageBean;
import com.xipunet.entity.Log;
import com.xipunet.service.LogService;

public class LogServlet extends HttpServlet {
	LogService logService = new LogService();
	String uri = "";
	
	private static final long serialVersionUID = -4639142482935774372L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String method= request.getParameter("method");
		if("findByPage".equals(method)){
			findByPage(request, response);
		}
		else if("findLogByUsername".equals(method)){
			findLogByUsername(request, response);
		}
	}
	public void findByPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		try {

			String currPage = request.getParameter("currentPage");
			if (currPage == null || "".equals(currPage.trim())) {
				currPage = "1";
			}

			int currentPage = Integer.parseInt(currPage);

			PageBean<Log> pageBean = new PageBean<Log>();
			pageBean.setCurrentPage(currentPage);
			logService.getAll(pageBean);
			request.setAttribute("pageBean", pageBean);
			uri = "/detail/log.jsp";
		} catch (Exception e) {
			e.printStackTrace();

			uri = "/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}
	
	public void findLogByUsername(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String currPage = request.getParameter("currentPage");
		if (currPage == null || "".equals(currPage.trim())) {
			currPage = "1";
		}
		int currentPage = Integer.parseInt(currPage);

		String keyword = request.getParameter("keyword");
		PageBean<Log> pageBean = new PageBean<Log>();
		pageBean.setCurrentPage(currentPage);
		logService.findLogByOperator(pageBean, keyword);
		request.setAttribute("pageBean", pageBean);
		uri = "/detail/log.jsp";
		request.getRequestDispatcher(uri).forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}

}
