package com.capgimini.retailermaintenanceapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgimini.retailermaintenanceapp.dto.ProductInfo;
import com.capgimini.retailermaintenanceapp.dto.ProductResponse;
import com.capgimini.retailermaintenanceapp.dto.UserInfo;
import com.capgimini.retailermaintenanceapp.dto.UserResponse;
import com.capgimini.retailermaintenanceapp.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	UserService service;

	@PostMapping(path = "/create-profile", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse createProfile(@RequestBody UserInfo user) {
		UserResponse response = new UserResponse();
		if (service.createProfile(user)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product with same name already exists");
		}
		return response;
	}

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse login(@RequestBody UserInfo user) {
		UserInfo userInfo = service.login(user.getEmail(), user.getPassword());
		UserResponse responce = new UserResponse();
		if (userInfo != null) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee found for the credentials");
			responce.setBeans(Arrays.asList(userInfo));
		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Invalid credentials");
		}
		return responce;
	}

	@GetMapping(path = "/search-product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse searchProduct(@RequestParam("id") int id) {
		ProductResponse response = new ProductResponse();
		ProductInfo product = service.searchProduct(id);
		if (product != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product found");
			response.setBeans(Arrays.asList(product));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product id does not exist");
		}
		return response;
	}

	@PutMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse changePassword(@RequestBody UserInfo bean) {
		UserResponse responce = new UserResponse();
		if (service.updatePassword(bean.getId(), bean.getPassword())) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Password change ");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Password Not change ");
		}
		return responce;
	}
	
	@GetMapping(path="/get",produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<ProductInfo> totalAmountPayable(@RequestParam("key") String name) {
		ProductResponse responce=new ProductResponse();
		List<ProductInfo> beans=service.totalAmountPayable(name);
		if(beans.isEmpty()) {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("data not found  ");
		}else {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("data found ");
		}
		return service.totalAmountPayable(name);
	}
}
