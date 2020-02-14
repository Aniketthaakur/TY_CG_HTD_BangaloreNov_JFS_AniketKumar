package com.capgemini.forestrymanagementsystemspring.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayValidation {
	static  private Matcher matcher;

	 private static final String USERNAME_PATTERN = "[A-Z][a-zA-Z]{3}";
	  
	  
	 static private Pattern pattern = Pattern.compile(USERNAME_PATTERN);
	  
	  
	  
	  public static boolean dayValidate(final String username){
		  
		  matcher = pattern.matcher(username);
		  return matcher.matches();
	    	    
	  }

}
