package com.cap.forestrymanagementsystemhibernat.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidation {

	static  private Matcher matcher;

	 private static final String USERNAME_PATTERN = "[A-Z][a-zA-Z]{3,10}";
	  
	  
	 static private Pattern pattern = Pattern.compile(USERNAME_PATTERN);
	  
	  
	  
	  public static boolean validate(final String username){
		  
		  matcher = pattern.matcher(username);
		  return matcher.matches();
	    	    
	  }
}

