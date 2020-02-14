package com.capgimini.forestrymanagementsystem.validation;

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
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
			try {
				Date date = format.parse(pDateString);
				Date d1 = new Date();
				if (date.compareTo(d1) < 0) {
					return false;
				} else {
					return true;
				}
			} catch (ParseException e) {
				System.err.println("Incorrect Format");
			}
			return false;
		}
}
