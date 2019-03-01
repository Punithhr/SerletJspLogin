package com.bridgelabz.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.webapp.dao.DataBaseInterActionLogin;
import com.bridgelabz.webapp.model.Login;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6236450854618995608L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userName=request.getParameter("uname");
		String password=request.getParameter("pass");
		Login login=new Login(userName,password);
		DataBaseInterActionLogin toLogin=new DataBaseInterActionLogin();
		if(toLogin.isUser(login))
		{
			request.setAttribute("msg", "Welcome "+login.getUserName());
			HttpSession session=request.getSession(true);
			session.setAttribute("userName", userName);
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Login UnSuccessfull");
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}
}
