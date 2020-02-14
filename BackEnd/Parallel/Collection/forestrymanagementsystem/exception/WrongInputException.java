package com.capgimini.forestrymanagementsystem.exception;

public class WrongInputException  extends RuntimeException{
	 String msg;
	public WrongInputException(String msg) {
	super();
	this.msg=msg;
	}
 
 public WrongInputException() {

	 super();
 }
@Override
public String getMessage() {
	return msg;
}
}
