package com.bridgelabz.webapp.services;

import com.bridgelabz.webapp.model.User;
import com.bridgelabz.webapp.util.Utility;

public class ValidateUser {
	public static String getvalidateUser(User user)
	{

		String result="";

		if(user.getFirstName().trim().equals("")||user.getFirstName()==null||!Utility.getValidFirstName(user.getFirstName()))
		{
			result=result+"Invalid firstName\n";
		}
		if(user.getLastName().trim().equals("")||user.getLastName()==null||!Utility.getValidLastName(user.getLastName()))
		{
			result=result+"Invalid lastName\n";

		}
		if(user.getUserName().trim().equals("")||user.getUserName()==null||!Utility.getValidUserName(user.getUserName()))
		{
			result=result+"Invalid userName\n";
		}
		if(user.getEmail().trim().equals("")||user.getEmail()==null||!Utility.getValidEmail(user.getEmail()))
		{
			result=result+"Invalid Email\n";
		}
		if(user.getPassword().equals("")||!Utility.getValidPassword(user.getPassword()))
		{
			result=result+"\n" + "Invalid Password";
		}
		if(user.getMobileNo().equals("")||user.getMobileNo()==null||!Utility.getValidPhoneNumber(user.getMobileNo()))
		{
			result=result+ "\n" + "Invalid Mobile number";
		}
		return result;
	}
	

}
