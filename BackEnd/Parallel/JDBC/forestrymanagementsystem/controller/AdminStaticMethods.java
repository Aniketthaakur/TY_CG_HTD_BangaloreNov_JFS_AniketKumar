package com.cap.forestrymanagementsystem.controller;

import java.util.Scanner;
import java.util.Set;

import com.cap.forestrymanagementsystem.dto.UserAdmin;
import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserProduct;
import com.cap.forestrymanagementsystem.exception.WrongInputException;
import com.cap.forestrymanagementsystem.factory.Factory;
import com.cap.forestrymanagementsystem.service.AdminService;
import com.cap.forestrymanagementsystem.validation.EmailValidator;
import com.cap.forestrymanagementsystem.validation.NameValidation;
import com.cap.forestrymanagementsystem.validation.StreetAddressValidation;
import com.cap.forestrymanagementsystem.validation.TownValidation;
import com.cap.forestrymanagementsystem.validation.ValidationNumber;


public class AdminStaticMethods {
static	AdminService service=Factory.getAdminService();
static UserAdmin admin;
static	UserClient client;
static Set<UserProduct> setProduct;
static Set<UserContractor>  setContractor;
static	Scanner sc=new Scanner(System.in);
static char ch='y';

	public static void addClient() {
		client=new UserClient();
		while (ch == 'y') {
			System.out.println("Enter  customerId :");
			int id = 0;
			char temp='y';
			while(temp=='y') {
				try {
					id=Integer.parseInt(sc.next());
					temp='n';
				}catch (Exception e) {
					System.err.println("Enter Digit only");
				}
			}
			try {
			if (ValidationNumber.customerId(id)) {
				client.setCustomerId(id);
				ch = 'n';

			} else {
				throw new WrongInputException("Enter Digits in range of 0 to 999999 ");
			}
			}catch(WrongInputException e) {
				System.err.println(e.getMessage());
			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Customer name");
			String customerName = sc.next();
			if (NameValidation.validate(customerName)) {
				client.setCustomerName(customerName);
				ch = 'n';
			} else {
				System.err.println("Enter Valid Customer Name...");
			}
		}
		
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Customer email");
			String st4 = sc.next();
			if (EmailValidator.validate(st4)) {
				client.setEmail(st4);
				ch = 'n';
			} else {
				System.err.println("Wrong Email Please Enter Valid Email..");
			}
		}
	
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Customer phone number:");
			int count = 0;
			long phNo=0;
			char temp='y';
			while(temp=='y') {
				try {
					phNo = Long.parseLong(sc.next());
					temp='n';
				} catch (Exception e) {
					System.err.println("Please provide interger only");
				}
				}
			long phno = phNo;
			while (phNo > 0) {
				count++;
				phNo = phNo / 10;
			}
			if (count == 10) {
				client.setPhoneNumber(phno);
				ch = 'n';			} else {
				System.err.println("Not a Valid Phone Numer Enter ten Digit Phone Number");
			}
		}
		
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter PIN CODE :");
			int count = 0;
			int pinCode = 0;
			char temp='y';
			while(temp=='y') {
			try {
				pinCode = Integer.parseInt(sc.next());
				temp='n';
			} catch (Exception e) {
				System.err.println("Please provide integer only");
			 
			}
			}
			int pincode = pinCode;
			while (pinCode > 0) {
				count++;
				pinCode = pinCode / 10;
			}
			try {
				if (count == 6) {
					client.setPostalCode(pincode);
					ch = 'n';
				} else {
					throw new WrongInputException("Data Invalid Enter Six Digit only!!!!");

				}
			} catch (WrongInputException e) {
				System.err.println(e.getMessage());
				}
		}
		
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter customer Steet Address 1:");
			String streetAddress = sc.next();
			try {
				if (StreetAddressValidation.validate(streetAddress)) {
					client.setStreetAddess1(streetAddress);
					ch = 'n';
				} else {
					throw new WrongInputException("Street Address Not Matches Provide Address like 21 park");
				}
			} catch (WrongInputException e) {
				System.err.println(e.getMessage());
			}
		}
		
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter customer Steet Address 2:");
			String streetAddress = sc.next();
			if (StreetAddressValidation.validate(streetAddress)) {
				client.setStreetAddess2(streetAddress);
				ch = 'n';
			} else {
				System.err.println("Wrong Street Adress Please  Valid Address like ( Park Street)..");
			}
		}
		
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Customwr Town name :");
			String townName = sc.next();
			if (TownValidation.validate(townName)) {
				client.setTown(townName);
				ch = 'n';
			} else {
				System.err.println("Please Enter Right Formate of Town like(Sans-fransico) ");
			}
		}
		
		
		
		if(service.addClient(client)) {
			System.out.println("client added successfully");
		}else {
			System.err.println("Unable to add please try again....");
		}
		
	}
	
	public static boolean login() {
		System.out.println("please login First as Admin");
		System.out.println("Enter User Name:");
		String username=sc.next();
		System.out.println("Enter Password:");
		String password=sc.next();
		String userType=service.login(username, password);
		if(userType==null) {
			userType="anik";
		}
		if(userType.equals("Admin")) {
			System.out.println("login successfully");
			return true;
		}
	return false;
	}
	public static void  getAllProduct(){
		setProduct=service.getAllProduct();
		if(setProduct!=null) {
			for(UserProduct user:setProduct) {
				System.out.println(user);
			}
		}else {
			System.err.println("Unable to display product details..");
		}
		
	}
	public static void showContracts() {
		setContractor=service.showContracts();
		if(setContractor!=null) {
			for(UserContractor scheduler:setContractor) {
				System.out.println(scheduler);
			}
			
		}else {
			System.err.println("Not able to display contract information...");
		}
	}
	
	public static void deleteClient() {
		client=new UserClient();
		System.out.println("Enter Customer id To Delete the Customer: ");
		int id = 0;
		char temp='y';
		while(temp=='y') {
		try {
			id = Integer.parseInt(sc.next());
			temp='n';
		} catch (Exception e) {
			System.err.println("Please provide integer only");
		 
		}
		}
		client.setCustomerId(id);
		try {
			if(service.deleteClient(client.getCustomerId())) {
				System.out.println("Customer deleted Successfully....");
			}else {
				throw new WrongInputException("Customer Id Does Not Exist!!");
			}
		} catch (WrongInputException e) {
			System.err.println(e.getMessage());
		}
	}
}
