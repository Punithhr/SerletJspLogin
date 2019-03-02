package com.bridgelabz.webapp.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import com.bridgelabz.webapp.dao.DataBaseInterActionLogin;
import com.bridgelabz.webapp.model.Login;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {

  
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String userName=req.getParameter("uname");
		String password=req.getParameter("pass");
		Login login=new Login(userName,password);
		DataBaseInterActionLogin toLogin=new DataBaseInterActionLogin();
		if(toLogin.isUser(login))
		{
			chain.doFilter(request, response);
		}
		else
		{
				request.setAttribute("msg", "Login UnSuccessfull<br/> userName or password wrong");
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
