package com.capgemini.forestrymanagementsystemspring.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidation {
static  private Matcher matcher;
  
   static private String regex="^[1-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
  static private Pattern pattern=Pattern.compile(regex);
  
  public static boolean dateValidate(String hex) {
	  matcher=pattern.matcher(hex);
	  return matcher.matches();
			  
  }
  
  public static boolean isValidDate(String pDateString) throws ParseException {
	  if(DateValidation.dateValidate(pDateString)) {
      Date date = new SimpleDateFormat("dd/MM/yyyy").parse(pDateString);
	  
	  return new Date().after(date);
}
	  return false;
}
}
