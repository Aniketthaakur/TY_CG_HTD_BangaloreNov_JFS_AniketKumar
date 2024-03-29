package com.cap.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cap.springboot.dto.EmployeeBean;
import com.cap.springboot.dto.EmployeeResponce;
import com.cap.springboot.service.EmployeeService;
@RestController
public class EmployeeController {
 
	@Autowired
	private EmployeeService service;
	
	@PostMapping(path="/auth" ,produces=MediaType.APPLICATION_JSON_VALUE,
							consumes=MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponce auth(@RequestBody EmployeeBean bean) {
		EmployeeBean employeeBean= service.auth(bean.getEmail(),bean.getPassword() );
		EmployeeResponce responce=new EmployeeResponce();
		if(employeeBean!=null) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee found for the credentials");
			responce.setBeans(Arrays.asList(employeeBean));
		}else{
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Invalid credentials");
		}
		return responce;		
	}
	@PostMapping(path="/register",produces=MediaType.APPLICATION_JSON_VALUE
						,consumes=MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponce register(@RequestBody EmployeeBean bean) {
		EmployeeResponce responce=new EmployeeResponce();
		if(service.register(bean)) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee registered");
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Email already Exits"+ ".");
		}
		return responce;
	}
	@GetMapping(path="/get",produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<EmployeeBean> searchEmployee(@RequestParam("key") String Key) {
		EmployeeResponce responce=new EmployeeResponce();
		List<EmployeeBean> beans=service.getEmployees(Key);
		if(beans.isEmpty()) {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("data not found  ");
		}else {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("data found ");
		}
		return service.getEmployees(Key);
	}
	
	@PutMapping(path="/change-password",produces=MediaType.APPLICATION_JSON_VALUE
										,consumes=MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponce changePassword(@RequestBody EmployeeBean bean) {
		EmployeeResponce responce=new EmployeeResponce();
		if(service.changePassword(bean.getId(), bean.getPassword())) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Password change ");	
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Password Not change ");
		}
		return responce;
	}
	
	@DeleteMapping(path="/delete/{id}")
 public EmployeeResponce deleteEmployee(@PathVariable("id") int id) {
	 EmployeeResponce responce=new EmployeeResponce();
	 
	 service.deleteEmployee(id) ;
		 responce.setStatusCode(201);
		 responce.setMessage("Success");
	 responce.setDescription("Employee Details Deleted");
	 
	 return responce;
 }
}
