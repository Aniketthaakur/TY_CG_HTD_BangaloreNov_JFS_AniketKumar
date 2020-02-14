package com.cap.forestrymanagementsystemhibernat.exception;

public class WrongInputException extends Exception{
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
