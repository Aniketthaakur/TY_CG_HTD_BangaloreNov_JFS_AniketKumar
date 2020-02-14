package com.cap.forestrymanagementsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TownValidation {

	static private Matcher matcher;
	static private final String TOWN_PATTERN="^[a-zA-Z]{4,10}+(?:[\\s-][a-zA-Z]{4,10}+)*$";
	static private Pattern pattern=Pattern.compile(TOWN_PATTERN);
	public static boolean validate(final String townName) {
		matcher=pattern.matcher(townName);
		 return matcher.matches();
	}
	
	
	
}
