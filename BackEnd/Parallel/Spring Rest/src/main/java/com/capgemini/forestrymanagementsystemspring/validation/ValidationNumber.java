package com.capgemini.forestrymanagementsystemspring.validation;

import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationNumber {
   static Scanner sc=new Scanner(System.in);

	static private Matcher matcher;
	static public	String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
	static private Pattern pattern = Pattern.compile(regex);
	
	public static boolean customerId(int id) {
		  
			int count =0;
			while(id>0) {
				count++;
				id=id/10;
			}
			if(count>=0&&count<=6) {
				
				return true;
			}
			return false;
	}
	public static boolean validateNumber(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
	
	
}
