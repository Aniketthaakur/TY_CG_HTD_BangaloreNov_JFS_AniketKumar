package com.cap.forestrymanagementsystemhibernat.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayValidation {
	
	static private Matcher matcher;

	static public String USERNAME_PATTERN = "\\b((mon|tues|wed(nes)?|thur(s)?|fri|sat(ur)?|sun)(day)?)\\b";
	  
	  
	 static private Pattern pattern = Pattern.compile(USERNAME_PATTERN);
	  
	  
	  
	  public static boolean dayValidate(final String username){
		  
		  matcher = pattern.matcher(username);
		  return matcher.matches();
	    	    
	  }

}
