package com.capgemini.forestrymanagementsystemspring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestrymanagementsystemspring.dto.AdminResponce;
import com.capgemini.forestrymanagementsystemspring.exception.WrongInputException;

@RestControllerAdvice
public class ForestryControllerAdvice {
	@ExceptionHandler(WrongInputException.class)
	public AdminResponce handleWrongInputException( WrongInputException e) {
		AdminResponce responce=new AdminResponce();
		responce.setStatusCode(501);
		responce.setMessage("Exception");
		responce.setDescription(e.getMessage());
		return responce;
	}
}
