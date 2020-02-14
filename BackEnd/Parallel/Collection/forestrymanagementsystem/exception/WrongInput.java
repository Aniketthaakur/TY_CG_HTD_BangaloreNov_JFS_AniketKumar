package com.capgimini.forestrymanagementsystem.exception;

public class WrongInput {

	
public static	double productMRP(double  price) throws WrongInputException{
		String priceMrp="^\\d{0,8}[.]?\\d{1,4}$";
		String mrp=Double.toString(price);
		if(!mrp.matches(priceMrp)) {
			throw new WrongInputException("ENter valid number");
			 
		 }else {
			 return price;
		 }
	}
}
