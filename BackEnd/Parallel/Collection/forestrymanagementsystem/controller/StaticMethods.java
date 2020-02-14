package com.capgimini.forestrymanagementsystem.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.capgimini.forestrymanagementsystem.dto.UserAdmin;
import com.capgimini.forestrymanagementsystem.dto.UserClient;
import com.capgimini.forestrymanagementsystem.dto.UserContractor;
import com.capgimini.forestrymanagementsystem.dto.UserProduct;
import com.capgimini.forestrymanagementsystem.exception.WrongInputException;
import com.capgimini.forestrymanagementsystem.factory.Factory;
import com.capgimini.forestrymanagementsystem.service.AdminService;
import com.capgimini.forestrymanagementsystem.service.ClientService;
import com.capgimini.forestrymanagementsystem.service.ContractorService;
import com.capgimini.forestrymanagementsystem.service.ProductService;
import com.capgimini.forestrymanagementsystem.validation.DateValidation;
import com.capgimini.forestrymanagementsystem.validation.DayValidation;
import com.capgimini.forestrymanagementsystem.validation.EmailValidator;
import com.capgimini.forestrymanagementsystem.validation.NameValidation;
import com.capgimini.forestrymanagementsystem.validation.StreetAddressValidation;
import com.capgimini.forestrymanagementsystem.validation.TownValidation;
import com.capgimini.forestrymanagementsystem.validation.ValidationNumber;

public class StaticMethods {

	static Scanner sc = new Scanner(System.in);
	static private String message;
	static char ch = 'y';
	static EmailValidator emailValidator;
	static UserAdmin admin;
	static UserContractor userContractor;
	static UserClient userClient;
	static UserProduct product1;

	static ContractorService contrator = Factory.objectContractor();
	static ProductService product = Factory.objectProduct();
	static ClientService customer = Factory.objectCustomer();
	static AdminService admindao = Factory.objectAdmin();

	static Set<UserProduct> setProduct = new HashSet<UserProduct>();
	static Set<UserContractor> setContractor = new HashSet<UserContractor>();
	static Set<UserClient> s2 = new HashSet<UserClient>();

	static Map<Integer, Set<UserContractor>> mapContractor = new HashMap<Integer, Set<UserContractor>>();
	static Map<Integer, Set<UserClient>> mapClient = new HashMap<Integer, Set<UserClient>>();
	static Map<Integer, Set<UserProduct>> mapProduct = new HashMap<Integer, Set<UserProduct>>();

	public static void addContractor() {
		userContractor = new UserContractor();
		while (ch == 'y') {

			System.out.println("Enter Contract number");
			int id = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					id = Integer.parseInt(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			try {
				if (ValidationNumber.customerId(id)) {
					userContractor.setContractorNo(id);
					ch = 'n';

				} else {
					throw new WrongInputException("Invalid Contract Number In Range 0 to 999999");

				}
			} catch (WrongInputException e) {
				System.err.println(e.getMessage());
			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Contract Id");
			int id = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					id = Integer.parseInt(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			try {
				if (ValidationNumber.customerId(id)) {
					userContractor.setContractorId(id);
					ch = 'n';

				} else {
					throw new WrongInputException("Invalid Contract Id In Range 0 to 999999");

				}
			} catch (WrongInputException e) {
				System.err.println(e.getMessage());
			}
		}
		ch = 'y';

		while (ch == 'y') {
			System.out.println("Enter Product Id");
			int id = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					id = Integer.parseInt(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			if (ValidationNumber.customerId(id)) {
				userContractor.setProductId(id);
				ch = 'n';

			} else {
				System.err.println("Invalid Product Id In Range 0 to 999999");

			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Delivery Date");
			try {
				String date1 = sc.next();
				if (DateValidation.isValidDate(date1)) {
					userContractor.setDate(date1);
					ch = 'n';

				} else {
					System.err.println("Enter correct  Future Date dd/MM/YYYY\"");
					System.out.println();
				}

			} catch (ParseException e) {

				System.err.println("Enter correct  Future Date DD/MM/YYYY");
			}
		}
		ch = 'y';

		while (ch == 'y') {
			System.out.println("Enter Delivery Day");
			String day = sc.next();
			if (DayValidation.dayValidate(day)) {
				userContractor.setDay(day);
				ch = 'n';

			} else {
				System.err.println("Enter Valid Day In Formate Of (mon|tues|wed...)");

			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Quantity");
			int id = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					id = Integer.parseInt(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			if (ValidationNumber.customerId(id)) {
				userContractor.setQuantity(id);
				ch = 'n';

			} else {
				System.err.println("Invalid Quantity Please Type In Range 0 to 999999");

			}
		}

		System.out.println("create sucessfully......");
		contrator.addContractor(userContractor);
		setContractor = contrator.getAllContractor();
		mapContractor.put(userContractor.getContractorId(), setContractor);
	}

	public static void deleteContractor() {

		System.out.println("Enter ContractorId");
		int ContractorId = 0;
		char temp = 'y';
		while (temp == 'y') {
			try {
				ContractorId = Integer.parseInt(sc.next());
				temp = 'n';
			} catch (Exception e) {

				System.err.println("Please provide integer only");

			}
		}
		try {
			if (contrator.deleteContactor(ContractorId, mapContractor)) {
				mapContractor.remove(ContractorId);
				System.out.println("Deleted succcessfully........");
			} else {
				throw new WrongInputException("Please Enter Correct Contract Id");
			}
		} catch (WrongInputException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void getAllContactor() {
		Set<Entry<Integer, Set<UserContractor>>> s1 = mapContractor.entrySet();
		if (s1.isEmpty()) {
			System.out.println("No Data Present");
		}
		
			for (Entry<Integer, Set<UserContractor>> e : s1) {
				System.out.println("Customer Id --->" + e.getKey());
				System.out.println(e.getValue());
			}
		} 
	

	public static void addClient() {
		userClient = new UserClient();
		while (ch == 'y') {
			
			System.out.println("Enter customer id:");
			int id =0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					id = Integer.parseInt(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			if (ValidationNumber.customerId(id)) {
				userClient.setCustomerId(id);
				ch = 'n';

			} else {
				System.err.println("Invalid Customer Id In Range 0 to 999999");

			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter customer name:");
			String customerName = sc.next();
			if (NameValidation.validate(customerName)) {
				userClient.setCustomerName(customerName);
				ch = 'n';
			} else {
				System.err.println("Enter Valid Customer Name...");
			}
		}
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Street Address 1:");
			String streetAddress = sc.next();
			if (StreetAddressValidation.validate(streetAddress)) {
				userClient.setStreetAddress1(streetAddress);
				ch = 'n';
			} else {
				System.err.println("Wrong Street Adress Please  Valid Address like (61 Park Street)..");
			}
		}
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Street Address 2:");
			String streetAddress = sc.next();
			if (StreetAddressValidation.validate(streetAddress)) {
				userClient.setStreetAddress2(streetAddress);
				ch = 'n';
			} else {
				System.err.println("Wrong Street Adress Please  Valid Address like ( Park Street)..");
			}
		}
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Town name:");
			String townName = sc.next();
			if (TownValidation.validate(townName)) {
				userClient.setTown(townName);
				ch = 'n';
			} else {
				System.err.println("Please Enter Right Formate of Town like(Sans-fransico) ");
			}
		}
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter PIN CODE :");
			int count = 0;
			int pinCode = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					pinCode = Integer.parseInt(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			int pincode = pinCode;
			while (pinCode > 0) {
				count++;
				pinCode = pinCode / 10;
			}
			if (count == 6) {
				userClient.setPinCode(pincode);
				ch = 'n';
			} else {
				System.err.println("Not a Valid Pincode Enter six Digit Pin Code");

			}
		}
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Phone number:");
			int count = 0;

			long phNo = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					phNo = Long.parseLong(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide Digits only");
				}
			}
			long phno = phNo;
			while (phNo > 0) {
				count++;
				phNo = phNo / 10;
			}
			if (count == 10) {
				userClient.setPhNo(phno);
				ch = 'n';
			} else {
				System.err.println("Not a Valid Phone Numer Enter ten Digit Phone Number");
			}
		}
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter email:");
			String st4 = sc.next();
			if (EmailValidator.validate(st4)) {
				userClient.setEmail(st4);
				ch = 'n';
			} else {
				System.err.println("Wrong Email Please Enter Valid Email.. like (Aniket@gmail.com)");
			}
		}
		System.out.println("create sucessfully......");
		customer.addCustomer(userClient);
		s2 = customer.getAllCustomer();
		mapClient.put(userClient.getCustomerId(), s2);
	}// end of clientAdd

	public static void deleteClient() {
		System.out.println("Enter customerID:");
		int customerID = 0;
		char temp = 'y';
		while (temp == 'y') {
			try {
				customerID = Integer.parseInt(sc.next());
				temp = 'n';
			} catch (Exception e) {
				System.err.println("Please provide integer only");

			}
		}
		try {
			if (customer.deleteCustomer(customerID, mapClient)) {
				mapClient.remove(customerID);
				System.out.println("Deleted succcessfully........");
			} else {
				throw new WrongInputException("Customer Id is Not Present");
			}
		} catch (WrongInputException e) {
			System.err.println(e.getMessage());
		}
	}// end of clientdelete

	public static void getAllClient() {
		if (mapClient.isEmpty()) {
			System.out.println("No data Found");
		} else {
			Set<Entry<Integer, Set<UserClient>>> s3 = mapClient.entrySet();
			for (Entry<Integer, Set<UserClient>> e : s3) {
				System.out.println("Customer Id --->" + e.getKey());
				System.out.println(e.getValue());
			}
		}
	}// end of getallclient

	public static void modifyClient() {
		userClient = new UserClient();
		System.out.println("enter customer id:");
		int customerid = 0;
		char temp = 'y';
		while (temp == 'y') {
			try {
				customerid = Integer.parseInt(sc.next());
				temp = 'n';
			} catch (Exception e) {
				System.err.println("Please provide integer only");

			}
		}
		if (mapClient.containsKey(customerid)) {
			if (customer.modifyCustomer(customerid, userClient)) {
				mapClient.remove(customerid);
				userClient.setCustomerId(customerid);
				System.out.println(" customer id:");
				System.out.println(userClient.getCustomerId());
				ch = 'y';
				while (ch == 'y') {
					System.out.println("Enter customer name:");
					String customerName = sc.next();
					if (NameValidation.validate(customerName)) {
						userClient.setCustomerName(customerName);
						ch = 'n';
					} else {
						System.err.println("Enter Valid Customer Name...");
					}
				}

				ch = 'y';
				while (ch == 'y') {
					System.out.println("Enter Street Address 1:");
					String streetAddress = sc.next();
					if (StreetAddressValidation.validate(streetAddress)) {
						userClient.setStreetAddress1(streetAddress);
						ch = 'n';
					} else {
						System.err.println("Wrong Street Adress Please  Valid Address like (61 Park Street)..");
					}
				}
				ch = 'y';
				while (ch == 'y') {
					System.out.println("Enter Street Address 2:");
					String streetAddress = sc.next();
					if (StreetAddressValidation.validate(streetAddress)) {
						userClient.setStreetAddress2(streetAddress);
						ch = 'n';
					} else {
						System.err.println("Wrong Street Adress Please  Valid Address like ( Park Street)..");
					}
				}
				ch = 'y';
				while (ch == 'y') {
					System.out.println("Enter Town name:");
					String townName = sc.next();
					if (TownValidation.validate(townName)) {
						userClient.setTown(townName);
						ch = 'n';
					} else {
						System.err.println("Please Enter Right Formate of Town like(Sans-fransico) ");
					}
				}
				ch = 'y';
				while (ch == 'y') {
					System.out.println("Enter PIN CODE :");
					int count = 0;
					int pinCode = 0;
					char temp1 = 'y';
					while (temp1 == 'y') {
						try {
							pinCode = Integer.parseInt(sc.next());
							temp1 = 'n';
						} catch (Exception e) {
							System.err.println("Please provide integer only");

						}
					}
					int pincode = pinCode;
					while (pinCode > 0) {
						count++;
						pinCode = pinCode / 10;
					}
					if (count == 6) {
						userClient.setPinCode(pincode);
						ch = 'n';
					} else {
						System.err.println("Not a Valid Pincode Enter six Digit Pin Code");

					}
				}
				ch = 'y';
				while (ch == 'y') {
					System.out.println("Enter Phone number:");
					int count = 0;
					long phNo = 0;
					char temp1 = 'y';
					while (temp1 == 'y') {
						try {
							phNo = Long.parseLong(sc.next());
							temp1 = 'n';
						} catch (Exception e) {
							System.err.println("Please provide integer only");

						}
					}
					long phno = phNo;
					while (phNo > 0) {
						count++;
						phNo = phNo / 10;
					}
					if (count == 10) {
						userClient.setPhNo(phno);
						ch = 'n';
					} else {
						System.err.println("Not a Valid Phone Numer Enter ten Digit Phone Number");
					}
				}
				ch = 'y';
				while (ch == 'y') {
					System.out.println("Enter email:");
					String st4 = sc.next();
					if (EmailValidator.validate(st4)) {
						userClient.setEmail(st4);
						ch = 'n';
					} else {
						System.err.println("Wrong Email Please Enter Valid Email..");
					}
				}
				System.out.println("modify sucessfully......");
				customer.addCustomer(userClient);
				s2 = customer.getAllCustomer();
				mapClient.put(customerid, s2);
				System.out.println(mapClient.get(customerid));

			}
		}
	}// end of modify client

	public static void addProduct() {
		product1 = new UserProduct();
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Product Id:");
			int id = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					id = Integer.parseInt(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			if (ValidationNumber.customerId(id)) {
				product1.setProductId(id);
				ch = 'n';

			} else {
				System.err.println("Invalid Product Id In Range 0 to 999999");

			}
		}
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Product Name");
			String productName = sc.next();
			if (NameValidation.validate(productName)) {
				product1.setProductName(productName);
				ch = 'n';
			} else {
				System.err.println("Enter Valid Product Name...");
			}
		}
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Product Details");
			String productDetails = sc.next();
			if (StreetAddressValidation.validate(productDetails)) {
				product1.setProductDetail(productDetails);
				ch = 'n';
			} else {
				System.err.println("Wrong Product Details..");
			}
		}

		System.out.println("Enter product MRP");
		product1.setProductMRP(sc.nextDouble());
		System.out.println("product added successfully.....");
		product.addProduct(product1);
		setProduct = product.getProduct();
		mapProduct.put(product1.getProductId(), setProduct);
	}

	public static void deleteProduct() {
		product1 = new UserProduct();
		System.out.println("Enter Product Id:");
		int productId = 0;
		char temp = 'y';
		while (temp == 'y') {
			try {
				productId = Integer.parseInt(sc.next());
				temp = 'n';
			} catch (Exception e) {
				System.err.println("Enter Integer Only In range of 0 to 999999");
			}
		}
		try {
			if (product.deleteProduct(productId, mapProduct)) {
				mapProduct.remove(productId);
				System.out.println("Deleted Successfully");
			} else {
				throw new WrongInputException("Product Id Not Found Enter Correct Product Id");
			}
		} catch (WrongInputException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getAllProduct() {
		if (mapProduct.isEmpty()) {
			System.out.println("No Data Present");
		}
		Set<Entry<Integer, Set<UserProduct>>> s9 = mapProduct.entrySet();

		for (Entry<Integer, Set<UserProduct>> e : s9) {
			System.out.println("Product Id :" + e.getKey());
			System.out.println(e.getValue());
		}
	}

	public static void modifyProduct() {
		product1 = new UserProduct();
		System.out.println("Enter Product id");

		int prodId = 0;
		char temp = 'y';
		while (temp == 'y') {
			try {
				prodId = Integer.parseInt(sc.next());
				temp = 'n';
			} catch (Exception e) {
				System.err.println("Enter Integer Only In range of 0 to 999999");
			}
		}
		if (product.modifyProduct(prodId, product1)) {
			mapProduct.remove(prodId);
			System.out.println("Enter Product Id:");
			product1.setProductId(prodId);
			ch = 'y';
			while (ch == 'y') {
				System.out.println("Enter Product Name");
				String productName = sc.next();
				if (NameValidation.validate(productName)) {
					product1.setProductName(productName);
					ch = 'n';
				} else {
					System.err.println("Enter Valid Product Name...");
				}
			}
			ch = 'y';
			while (ch == 'y') {
				System.out.println("Enter Product Details");
				String productDetails = sc.next();
				if (StreetAddressValidation.validate(productDetails)) {
					product1.setProductDetail(productDetails);
					ch = 'n';
				} else {
					System.err.println("Wrong Product Details..");
				}
			}

			System.out.println("Enter product MRP");
			while (ch == 'y') {
				double mrp = 0;
				char temp1 = 'y';
				while (temp1 == 'y') {
					try {
						mrp = Double.parseDouble(sc.next());
						temp1 = 'n';
					} catch (WrongInputException e) {
						System.out.println(e.getMessage());
					}
				}

				product1.setProductMRP(mrp);

				System.out.println("Modify Successfully...");
				product.addProduct(product1);
				setProduct = product.getProduct();
				mapProduct.put(prodId, setProduct);
				System.out.println(mapProduct.get(prodId));
			}
		}
	}

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		StaticMethods.message = message;
	}

	public static void issueMessage() {
		System.out.println("Enter message that u face problem while payment");

		String msg1 = sc.next();
		StaticMethods.setMessage(msg1);
		System.out.println("The Problem that are Facing is:");
		System.err.println(StaticMethods.getMessage());
		System.out.println("Your Problem Submitted SuccessFully ...!!!");
	}

	public static void paymentStatus() {
		try {
			if (!StaticMethods.getMessage().isEmpty()) {
				System.err.println("Payment Failure......");
			}
		} catch (Exception e) {
			System.out.println("Payment Successfully Done....");
		}

	}

	public static boolean adminLogin() {
		admin = new UserAdmin();
		System.out.println("Enter user name");
		admin.setUserName(sc.next());
		System.out.println("Enter password");
		admin.setPassword(sc.next());
		if (admindao.login(admin.getUserName(), admin.getPassword())) {

			return true;
		}

		return false;
	}

	public static boolean clientLogin() {
		userClient = new UserClient();
		System.out.println("Enter Client Name:");
		userClient.setName(sc.next());
		System.out.println("Enter Client Password:");
		userClient.setPassword(sc.next());
		if (customer.clientLogin(userClient.getName(), userClient.getPassword())) {
			return true;
		}
		return false;
	}

}// end of class
