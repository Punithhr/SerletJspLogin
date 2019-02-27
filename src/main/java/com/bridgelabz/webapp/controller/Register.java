package com.bridgelabz.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.webapp.model.User;

public class Register extends HttpServlet{

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();  
    
	String firstName=request.getParameter("firstName");  
	String lastName=request.getParameter("lastName");  
	String Uname=request.getParameter("Uname");  
	String email=request.getParameter("email");  
	String pass=request.getParameter("pass");  
	String Mnum=request.getParameter("Mnum");  
User user=new User(firstName,lastName,Uname,email,pass,Mnum);
request.setAttribute("msg", "The actual error message to be displayed");
RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
rd.forward(request, response);
}
}
