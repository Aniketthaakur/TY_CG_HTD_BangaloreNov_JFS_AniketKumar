package com.cap.forestrymanagementsystemhibernat.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dto.UserClient;
import com.cap.forestrymanagementsystemhibernat.dto.UserContractor;
import com.cap.forestrymanagementsystemhibernat.dto.UserLand;
import com.cap.forestrymanagementsystemhibernat.dto.UserOrder;
import com.cap.forestrymanagementsystemhibernat.dto.UserProduct;
import com.cap.forestrymanagementsystemhibernat.exception.IdNotFoundException;
import com.cap.forestrymanagementsystemhibernat.exception.WrongInputException;
import com.cap.forestrymanagementsystemhibernat.factory.Factory;
import com.cap.forestrymanagementsystemhibernat.service.AdminService;
import com.cap.forestrymanagementsystemhibernat.service.ClientService;
import com.cap.forestrymanagementsystemhibernat.service.LandService;
import com.cap.forestrymanagementsystemhibernat.validation.DateValidation;
import com.cap.forestrymanagementsystemhibernat.validation.DayValidation;
import com.cap.forestrymanagementsystemhibernat.validation.NameValidation;
import com.cap.forestrymanagementsystemhibernat.validation.StreetAddressValidation;
import com.cap.forestrymanagementsystemhibernat.validation.ValidationNumber;



public class ClientStaticMethod {
	static ClientService clientService = Factory.getClientObject();
	static UserContractor scheduler;
	static Set<UserContractor> setContractor;
	static Set<UserOrder> setOrder;
	static UserOrder order;
	static UserClient client;
	static Set<UserClient> setClient;
	static UserProduct product;
	static UserContractor contractor;
	static Scanner sc = new Scanner(System.in);
	static char ch='y';
	public static boolean clientLogin() {
		System.out.println("Please Login As Client");
		System.out.println("Enter Client Name:");
		String username=sc.next();
		System.out.println("Enter Client password:");
		String password=sc.next();
		String user=clientService.clientLogin(username, password);
		if(user==null) {
			user="Anik";
		}
		if(user.equals("Client")) {
			System.out.println("login successfully");
			return true;
		}
	return false;
	}

	public static void addContractor() {
		scheduler = new UserContractor();
		while (ch == 'y') {
			
			System.out.println("Enter HaulierId :");
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
					scheduler.setHaulierId(id);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid HaulierId Please Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				System.err.println(e.getMessage());
			}
			}
		
		
		ch='y';
		while (ch == 'y') {
			System.out.println("Enter contractNo:");
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
			if (ValidationNumber.customerId(id)) {
				scheduler.setContractorNo(id);
				ch = 'n';

			} else {
				System.err.println("Invalid contractNo Please Type In Range 0 to 999999");

			}
		}
		ch='y';
		while (ch == 'y') {
			System.out.println("Enter CustomerId:");
			int id = 0;
			char temp='y';
			while(temp=='y') {
			try {
				id = Integer.parseInt(sc.next());
				if(clientService.searchClient(id)) {
				temp='n';
				}else {
					System.err.println("Customer Id Not Present Provide Correct Customer Id From List");
					AdminService service=Factory.getAdminService();
					Set<UserContractor> contractors=new HashSet<UserContractor>();
					contractors=service.showContracts();
					if(contractors!=null) {
						for (UserContractor userContractor : contractors) {
							System.out.println(userContractor);
						}
					}else {
						System.out.println("No Customer Present!!!");
					}
					
				
				}
				} catch (Exception e) {
				System.err.println("Please provide integer only");
			 
			}
			}
			try {
				if (ValidationNumber.customerId(id)) {
					scheduler.setCustomerId(id);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid CustomerId Please Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				e.getMessage();
			}
		}

		ch='y';
		while (ch == 'y') {
			System.out.println("Enter productId:");
			int id = 0;
			char temp='y';
			while(temp=='y') {
			try {
				id = Integer.parseInt(sc.next());
				if(clientService.searchProduct(id)) {
				temp='n';
				}else {
					System.err.println("Product Id Not Present Provide Correct Product Id From List");
					AdminService service=Factory.getAdminService();
					Set<UserProduct> product=new HashSet<UserProduct>();	
					product=service.getAllProduct();
							
							if(product!=null) {
								for (UserProduct userProduct : product) {
							System.out.println(userProduct);		
								}
						}else {
							System.err.println("Order Not Present");
						}
				}
			} catch (Exception e) {
				System.err.println("Please provide integer only");
			 
			}
			}
			try {
				if (ValidationNumber.customerId(id)) {
					scheduler.setProductId(id);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid productId Please Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				e.getMessage();
			}
		}
		
		ch='y';
		while (ch == 'y') {
			System.out.println("Enter quantity:");
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
			if (ValidationNumber.customerId(id)) {
				scheduler.setQuantity(id);
				ch = 'n';

			} else {
				System.err.println("Invalid quantity Number Please Type In Range 0 to 999999");

			}
		}
		
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Delivery Date");
			try {
			String date1=sc.next();
			if (DateValidation.isValidDate(date1)) {
				scheduler.setDeliveryDate(date1);
				ch = 'n';

			}else{
				System.err.println("Enter correct  Future Date dd/MM/YYYY\"");	
				System.out.println();
				}
			
			}catch(ParseException e) {
			
				System.err.println("Enter correct  Future Date DD/MM/YYYY");
			}
}
		
		ch='y';	

		while (ch == 'y') {
			System.out.println("Enter Delivery Day");
			String day=sc.next();
			if (DayValidation.dayValidate(day)){
				scheduler.setDeliveryDay(day);
				ch = 'n';

			} else {
				System.err.println("Enter Valid Day In Formate Of (Mon)");

			}
		}
		
		ch='y';
		while (ch == 'y') {
			System.out.println("Enter parcelID:");
			int id = 0;
			char temp='y';
			while(temp=='y') {
			try {
				id = Integer.parseInt(sc.next());
				if(clientService.searchParcel(id)) {
					temp='n';
					}else {
						System.err.println("Parcel Land Id Not Present Provide Correct Parcel Id From List");
						LandService service=Factory.getInstanceOfLand();
						Set<UserLand> land=new HashSet<UserLand>();	
						land=service.getAllLandDetails();
								
								if(land!=null) {
									for (UserLand userLand : land) {
								System.out.println(userLand);		
									}
							}else {
								System.err.println("Parcel Land Area Not Present");
							}
					}
			} catch (Exception e) {
				System.err.println("Please provide integer only");
			 
			}
			}
			try {
				if (ValidationNumber.customerId(id)) {
					scheduler.setParcelId(id);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid Parcel Id Please Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				e.getMessage();
			}
		}
		
		
		
		
		
		if (clientService.orderContracts(scheduler)) {
			System.out.println("Contractor added successfully .....");

		} else {
			System.err.println("Unable to add Contractor....");
		}
	}
	
	
	public static void updateInventoryProduct() {
		
		product=new UserProduct();
		
		System.out.println("Enter product ID to update product ");
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
		product.setProductId(id);
		System.out.println("Enter product Name in Demand:");
		product.setProductName(sc.next());
		if(clientService.updateProduct(product.getProductName(),product.getProductId())){
			
			System.out.println("product updated successfully...");
		}else {
			System.err.println("Not able Update product...!!!");
		}
		
	
	
	}

	public static void showOrder() {
	setOrder=clientService.showOrder();
		
		if(setOrder!=null) {
			for(UserOrder user:setOrder) {
				System.out.println(user);
			}
		}else {
			System.err.println("unable to show order..!!");
		}
	}
	
	public static void getAllClient() {
	 setClient=clientService.getAllClient();
		
		if(setClient !=null)
		{
			for(UserClient user:setClient)
			{
				System.out.println(user);
			}
		}
	}//end of getAllClient
	
	public static void updateContract() {
		contractor=new UserContractor();
		
		System.out.println("Enter The Haulier Id :");
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
		contractor.setHaulierId(id);
		System.out.println("Enter the Contractor Number Which you Want to Update :");
		int id1 = 0;
		char temp1='y';
		while(temp1=='y') {
		try {
			id = Integer.parseInt(sc.next());
			temp1='n';
		} catch (Exception e) {
			System.err.println("Please provide integer only");
		 
		}
		}
		contractor.setContractorNo(id1);
		
		if(clientService.updateContract(contractor.getContractorNo(), contractor.getHaulierId())){
			System.out.println("Contract Number Updated Successfully..");
		}else {
			System.out.println("Unable to update .....");
		}
		
	}//end of update contract
	
	public static void deleteContract() {
		contractor=new UserContractor();
		System.out.println("Enter the Haulier Id To Delete The Particular Contract");
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
		contractor.setHaulierId(id);
		if(clientService.deleteContract(contractor.getHaulierId())) {
			System.out.println("Contract Deleted Successfully ......");
		}else {
			System.err.println("Unable to delete Contract");
		}
	}
	
	public static void addProduct() {
		product=new UserProduct();
		
		ch='y';
		while (ch == 'y') {
			System.out.println("Enter Product Id:");
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
			try {
				if (ValidationNumber.customerId(id)) {
					product.setProductId(id);
					ch = 'n';

				} else {
					throw new WrongInputException("Invalid Please type In Range 0 to 999999");

				}
			} catch (WrongInputException e) {
				System.err.println(e.getMessage());
			}
		}
		
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Product Name :");
			String productName = sc.next();
			if (NameValidation.validate(productName)) {
				product.setProductName(productName);
				ch = 'n';
			} else {
				System.err.println("Enter Valid Customer Name...");
			}
		}
		
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Product Description");
			String ProductDescription = sc.next();
			if (StreetAddressValidation.validate(ProductDescription)) {
				product.setProductDescription(ProductDescription);
				ch = 'n';
			} else {
				System.err.println("Wrong Street Adress Please  Valid Address like (61 Park Street)..");
			}
		}
		
		
		
		
		if(clientService.addProduct(product)) {
			System.out.println("Product Added Successfully..");
		}
		else {
			System.err.println("Unable TO Add Product Please Try Again Later....");
		}
	}//end of product
	
	public static void deleteProduct() {
		product=new UserProduct();
		System.out.println("Enter Product Id To Delete The Product");
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
		product.setProductId(id);
		
		if(clientService.deleteProduct(product.getProductId())) {
			System.out.println("Product Deleted Successfully...");
		}else {
			System.err.println("Failed To Delete Product");
		}
	}// end of delete product
	
	public static void getAllContractor() {
		setContractor=clientService.contractInformation();
		
		if(setContractor!=null) {
			for(UserContractor user:setContractor) {
				System.out.println(user);
			}
		}else {
			System.err.println("There is No Value Present Inside Contractor");
		}
	}
	

}//end of class