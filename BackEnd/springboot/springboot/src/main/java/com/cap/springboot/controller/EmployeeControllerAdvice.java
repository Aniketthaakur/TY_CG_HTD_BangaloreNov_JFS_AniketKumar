package com.cap.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cap.springboot.dto.EmployeeResponce;
import com.cap.springboot.exception.EmployeeException;

@RestControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponce handleEmployeeException( EmployeeException e) {
		EmployeeResponce responce=new EmployeeResponce();
		responce.setStatusCode(501);
		responce.setMessage("Exception");
		responce.setDescription(e.getMessage());
		return responce;
	}
}
