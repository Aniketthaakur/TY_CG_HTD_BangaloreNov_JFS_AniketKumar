package com.capgemini.forestrymanagementsystemspring.validation;

import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	static Scanner sc = new Scanner(System.in);

	static private Matcher matcher;
	
	static public String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	static private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
 
	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */

	public static boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

	
}
