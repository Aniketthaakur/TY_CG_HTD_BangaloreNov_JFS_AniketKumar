package com.cap.forestrymanagementsystem.exception;

public class IdNotFoundException extends Exception {
	String msg ;

	public IdNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public IdNotFoundException() {
		super();
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
