package com.bridgelabz.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession(false);
	if(session!=null)
	{
		session.removeAttribute("userName");
		session.invalidate();
		request.setAttribute("msg","You are Successfully Logged Out");
		RequestDispatcher rd = request.getRequestDispatcher("Logout.jsp");
		rd.forward(request, response);
	}
	else
	{
		request.setAttribute("msg","you are timed Out login again");
		RequestDispatcher rd = request.getRequestDispatcher("Logout.jsp");
		rd.forward(request, response);
	}
	}
}
