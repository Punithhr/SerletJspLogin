package com.bridgelabz.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.webapp.dao.DataBaseForgotPassword;
import com.bridgelabz.webapp.model.ForgotPassword;

public class ForgotPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{String uname=request.getParameter("uname");
	String email=request.getParameter("email");
	String pass=request.getParameter("pass");
	ForgotPassword forgotObj=new ForgotPassword(uname,email,pass);
	DataBaseForgotPassword dbForgot=new DataBaseForgotPassword();
	String result="Incorrect userName Or Email";
	if(dbForgot.toCheckEmail(forgotObj))
	{
		request.setAttribute("msg", "Reset Password Successfull");
		dbForgot.updatePassword(forgotObj);
		RequestDispatcher rd = request.getRequestDispatcher("ForgotSuccessfull.jsp");
		rd.forward(request, response);
	}
	else
	{
		
		request.setAttribute("msg", result);
		RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
		rd.forward(request, response);
	}
	
	}

}
