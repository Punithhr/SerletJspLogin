package com.bridgelabz.webapp.util;

import java.util.regex.Pattern;

public class Utility {
public static String getValidPhoneNumber(String number)
{
	if(Pattern.matches("[789]{1}[0-9]{9}",number))
	{
		return "Valid Phone Number";
				
	}
	return "Invalid Phone Number";
}
public static String getValidFirstName(String firstName)
{
	if(Pattern.matches("[a-zA-Z]{3,20}",firstName))
	{
		return "Valid FirstName";
		
	}
	return "Invalid FirstName";
}
public static String getValidLastName(String lastName)
{
	if(Pattern.matches("[a-zA-Z ]{3,10}",lastName))
	{
		return "Valid lastName";
		
	}
	return "Invalid lastName";
}
public static String getValidEmail(String email)
{
	if(Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",email))
	{
		return "Valid email";
		
	}
	return "Invalid email";
}
public static String getValidUserName(String userName)
{
	if(Pattern.matches("[a-zA-Z]{3,10}",userName))
	{
		return "Valid userName";
		
	}
	return "Invalid userName";
}
public static String getValidPassword(String password)
{
	if(Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",password))
	{
		return "Valid Password";
		
	}
	return "Invalid Password";
}
}
