package com.xipunet.servlet;


import com.xipunet.entity.User;
import com.xipunet.entity.Log;
import com.xipunet.service.UserService;
import com.xipunet.service.LogService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = -9221167986176489426L;
	UserService userService = new UserService();
	String uri="";
	LogService logService = new LogService();
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码统一
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if("login".equals(method)){
			login(request, response);	
		}
		else if("logout".equals(method)){
			logout(request, response);
		}
		else if("changePassword".equals(method)){
			changePassword(request, response);
		}
		
	}
	//登录方法
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String loginInfo = request.getParameter("username");
		String password = request.getParameter("password");
//	    System.out.println("当前IP地址："+request.getRemoteAddr()); //：获得客户端的ip地址
		User loginByUsernameResult = userService.loginByUsername(loginInfo, password);
		if(loginByUsernameResult == null){
			User loginByEmailResult = userService.loginByEmail(loginInfo, password);
				if(loginByEmailResult == null){
					loginFailed(request, response);
					 }
		else{
			User aa = userService.findUsernameByEmail(loginInfo);
			String name =   aa.getUsername();
			request.getSession().setAttribute("sessionUser", name);
			request.getSession().setMaxInactiveInterval(30*60);
		
				addLog(request, response);
			
			// 获取用户名保存到cookie中
			String loginname = loginInfo;
			loginname = URLEncoder.encode(loginname, "utf-8");
			Cookie cookie = new Cookie("loginname", loginname);
			cookie.setMaxAge(60 * 60 * 24 * 10);//保存10天
			response.addCookie(cookie);
		//跳转到主页
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			//return;
		}
				}
		else{
			request.getSession().setAttribute("sessionUser", loginInfo);
			request.getSession().setMaxInactiveInterval(30*60);
			addLog(request, response);
		
			// 获取用户名保存到cookie中
			String loginname = loginInfo;
			loginname = URLEncoder.encode(loginname, "utf-8");
			Cookie cookie = new Cookie("loginname", loginname);
			cookie.setMaxAge(60 * 60 * 24 * 10);//保存10天
			response.addCookie(cookie);
		//跳转到主页
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
			
	}
	//登出方法
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//记录日志
		Log log = new Log();
		log.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		log.setOperator(request.getSession().getAttribute("sessionUser").toString());
		log.setContent("用户退出");
		log.setRemark("用户名："+request.getSession().getAttribute("sessionUser").toString());
		logService.add(log);
		
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/login.jsp");
			
	}
	//修改密码
	public void changePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//User user = (User)request.getSession().getAttribute("userSession");
		String user = request.getSession().getAttribute("sessionUser").toString();
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		System.out.println(user);
		boolean bool = userService.findPasswordByUsername(user, oldpwd);
//		if(oldpwd!=newpwd){
//			request.setAttribute("msg", "新密码和确认新密码不一致！");	
//			RequestDispatcher rd = request.getRequestDispatcher("/detail/changePassword.jsp");
//			try {
//				rd.forward(request, response);
//				
//			} catch (Exception e) {}	
//		}
		if(bool==false){
			request.setAttribute("msg", "原密码错误！");	
			RequestDispatcher rd = request.getRequestDispatcher("/detail/changePassword.jsp");
			try {
				rd.forward(request, response);
				
			} catch (Exception e) {}
		}
		else{
		userService.changePassword(newpwd, user); 
		PrintWriter out = response.getWriter();
		out.println("  <script type='text/javascript'> alert('密码修改成功！')</script>");
		out.println("</HTML>");
		out.flush();
		out.close();
		}

	}
	
	public void loginFailed(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg", "用户名或密码错误！");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
			
	}
	//添加用户登录日志信息
	public void addLog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//记录日志
		Log log = new Log();
		log.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		log.setOperator(request.getSession().getAttribute("sessionUser").toString());
		log.setContent("用户登录");
		log.setRemark("用户名："+request.getParameter("username"));
		logService.add(log);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
