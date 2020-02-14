package com.cap.forestrymanagementsystemhibernat.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dto.UserContractor;
import com.cap.forestrymanagementsystemhibernat.dto.UserHaulier;
import com.cap.forestrymanagementsystemhibernat.dto.UserOrder;
import com.cap.forestrymanagementsystemhibernat.dto.UserProduct;
import com.cap.forestrymanagementsystemhibernat.exception.IdNotFoundException;
import com.cap.forestrymanagementsystemhibernat.factory.Factory;
import com.cap.forestrymanagementsystemhibernat.service.AdminService;
import com.cap.forestrymanagementsystemhibernat.service.ClientService;
import com.cap.forestrymanagementsystemhibernat.service.SchedulerService;
import com.cap.forestrymanagementsystemhibernat.validation.DateValidation;
import com.cap.forestrymanagementsystemhibernat.validation.NameValidation;
import com.cap.forestrymanagementsystemhibernat.validation.TownValidation;
import com.cap.forestrymanagementsystemhibernat.validation.ValidationNumber;


public class SchedulerStaticMethods {

	static UserHaulier haulier;
	static UserOrder order;
	static Scanner sc = new Scanner(System.in);
	static SchedulerService schedulerService = Factory.getInstanceOfScheduler();
	static Set<UserHaulier> setHaulier;
	static ClientService clientService = Factory.getClientObject();
	static char ch = 'y';

	public static void addHaulier() {
		haulier = new UserHaulier();

		while (ch == 'y') {
			System.out.println("Enter Haulier Id :");
			int id = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					id = Integer.parseInt(sc.next());
					if (clientService.searchContractor(id)) {
						temp = 'n';
					} else {
						System.err.println("haulier Id Not Present Provide Correct hualier Id From List");
						ClientService service = Factory.getClientObject();
						Set<UserContractor> contractors = new HashSet<UserContractor>();
						contractors = service.contractInformation();
						if (contractors != null) {
							for (UserContractor userContractor : contractors) {
								System.out.println(userContractor);
							}
						} else {
							System.out.println("No Customer Present!!!");
						}

					}
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			try {
				if (ValidationNumber.customerId(id)) {
					haulier.setHaulierId(id);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid Haulier Id Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				e.getMessage();
			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Haulier Name:");
			String haulierName = sc.next();
			try {
				if (NameValidation.validate(haulierName)) {
					haulier.setHaulierName(haulierName);
					ch = 'n';
				} else {
					throw new IdNotFoundException("Enter Valid Customer Name...");
				}
			} catch (IdNotFoundException e) {
				e.getMessage();
			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Haulier Phone Number");
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
				haulier.setHaulierPhoneNo(phno);
				ch = 'n';
			} else {
				System.err.println("Not a Valid Phone Numer Enter ten Digit Phone Number");
			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Haulier Town:");
			String townName = sc.next();
			if (TownValidation.validate(townName)) {
				haulier.setHaulierTown(townName);
				ch = 'n';
			} else {
				System.err.println("Please Enter Right Formate of Town like(Sans-fransico) ");
			}
		}

		if (schedulerService.addHaulier(haulier)) {
			System.out.println("Haulier Added Successfully.....");
		} else {

			System.err.println("Failed TO Add Haulier..");

		}

	}

	public static void addOrder() {
		order = new UserOrder();
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Order No :");
			int orderNo = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					orderNo = Integer.parseInt(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			try {
				if (ValidationNumber.customerId(orderNo)) {
					order.setOrderNO(orderNo);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Order No Cannot be Duplicated and type in range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}

		ch = 'y';

		while (ch == 'y') {
			System.out.println("Enter Customer Id:");
			int id = 0;
			char temp = 'y';
			while (temp == 'y') {
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
					order.setCustomerId(id);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid CustomerId Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}

		ch = 'y';

		while (ch == 'y') {
			System.out.println("Enter Haulier Id :");
			int id = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					id = Integer.parseInt(sc.next());
					if (clientService.searchContractor(id)) {
						temp = 'n';
					} else {
						System.err.println("haulier Id Not Present Provide Correct hualier Id From List");
						ClientService service = Factory.getClientObject();
						Set<UserContractor> contractors = new HashSet<UserContractor>();
						contractors = service.contractInformation();
						if (contractors != null) {
							for (UserContractor userContractor : contractors) {
								System.out.println(userContractor);
							}
						} else {
							System.out.println("No Customer Present!!!");
						}

					}
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			try {
				if (ValidationNumber.customerId(id)) {
					order.setHaulierId(id);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid Haulier Id Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}

		ch = 'y';

		while (ch == 'y') {
			System.out.println("Enter Product Id :");
			int id = 0;
			char temp = 'y';
			while (temp == 'y') {
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
					order.setProductId(id);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid Product Id Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}

		ch = 'y';

		while (ch == 'y') {
			System.out.println("Enter Qunatity :");
			int quantity = 0;
			char temp = 'y';
			while (temp == 'y') {
				try {
					quantity = Integer.parseInt(sc.next());
					temp = 'n';
				} catch (Exception e) {
					System.err.println("Please provide integer only");

				}
			}
			try {
				if (ValidationNumber.customerId(quantity)) {
					order.setQuantity(quantity);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid Product Id Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Delivery Date :");
			try {
				String date1 = sc.next();
				if (DateValidation.isValidDate(date1)) {
					order.setDeliveryDate(date1);
					ch = 'n';

				} else {
					System.err.println("Enter correct  Future Date dd/MM/YYYY\"");
					System.out.println();
				}

			} catch (ParseException e) {

				System.err.println("Enter correct  Future Date DD/MM/YYYY");
			}
		}

		if (schedulerService.addOrder(order)) {
			System.out.println("Order Added Successfully..");
		} else {
			System.err.println("Failed to Add Order..");
		}

	}// end of add order

	public static void getAllHaulier() {
		setHaulier = schedulerService.getAllHaulier();
		if (setHaulier != null) {
			for (UserHaulier user : setHaulier) {
				System.out.println(user);
			}
		} else {
			System.err.println("Unable to display Haulier details..");
		}

	}// end of get all haulier

	public static void updateHaulier() {
		haulier = new UserHaulier();
		System.out.println("Enter The Phone Number That You To Update");
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
		haulier.setHaulierPhoneNo(phNo);
		System.out.println("Enter The Haulier Name TO Confirm Upadte ");
		haulier.setHaulierName(sc.next());
		if (schedulerService.updateHaulier(haulier.getHaulierPhoneNo(), haulier.getHaulierName())) {
			System.out.println("Phone Number Updated Successfully...");
		} else {
			System.err.println("Unable to add Phone Number...");
		}
	}

}
