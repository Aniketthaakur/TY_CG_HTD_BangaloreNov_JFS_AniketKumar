package com.cap.forestrymanagementsystem.controller;

import java.util.Scanner;
import java.util.Set;

import com.cap.forestrymanagementsystem.dto.UserLand;
import com.cap.forestrymanagementsystem.exception.IdNotFoundException;
import com.cap.forestrymanagementsystem.factory.Factory;
import com.cap.forestrymanagementsystem.service.LandService;
import com.cap.forestrymanagementsystem.validation.NameValidation;
import com.cap.forestrymanagementsystem.validation.StreetAddressValidation;
import com.cap.forestrymanagementsystem.validation.ValidationNumber;

public class LandStaticMethods {

	static Scanner sc = new Scanner(System.in);
	static UserLand land;
	static LandService landService=Factory.getInstanceOfLand();
	static Set<UserLand> setland;
	static char ch='y';
	public static void addLandRecord() {
		
		land = new UserLand();
		
		while (ch == 'y') {
			System.out.println("Enter ParcelId :");
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
					land.setParcelID(id);
					ch = 'n';

				} else {
					throw new IdNotFoundException("Invalid  ParcelId Please Type In Range 0 to 999999");

				}
			} catch (IdNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}

		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter parcel Area ");
			String parcelArea = sc.next();
			if (StreetAddressValidation.validate(parcelArea)) {
				land.setParcelArea(parcelArea);
				ch = 'n';
			} else {
				System.err.println("Wrong  parcel Area Please provide  Valid Address like (61 Park Street)..");
			}
		}
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Parcel Payment Status");
			String PaymentStatus = sc.next();
			if (NameValidation.validate(PaymentStatus)) {
				land.setParcelPaymentSlip(PaymentStatus); ;
				ch = 'n';
			} else {
				System.err.println("Wrong  Payment Status Please  provide Valid Paymnet like(Done or Failed)..");
			}
		}
	
		
		
		ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter Parcel Related Issue if any ");
			String transactionIssue = sc.next();
			if (StreetAddressValidation.validate(transactionIssue)) {
				land.setPaymentDescription(transactionIssue);
				ch = 'n';
			} else {
				System.err.println("Wrong  transactionIssue Please  provide Valid transactionIssue like..");
			}
		}
		
		

		if(landService.addLandRecord(land)) {
			System.out.println("Land Record Added Sucessfully..");
		}else {
		
			System.err.println("Wrong input..");
		}
	}// end of add land
	
	public static void paymentStatus() {
		land=new UserLand();
		System.out.println("Enter Transaction Details To Update Parcel payment Status");
		land.setParcelPaymentSlip(sc.next());
		System.out.println("Enter Parcel Id To Confirm The Update");
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
		land.setParcelID(id);
		
		if(landService.paymentStatus(land.getParcelPaymentSlip(), land.getParcelID())) {
			System.out.println("Payment Status Updated Successfully");
		}else {
			System.err.println("Failed to Update Paymnet status..");
		}
	}//end of payment status

	public static void updatePaymentDescription(){
		land=new UserLand();
		System.out.println("Enter Transaction Issue To Update payment Status");
		sc.next();
		land.setPaymentDescription(sc.nextLine());
		System.out.println("Enter Parcel Id To Confirm The Update");
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
		land.setParcelID(id);
		
		if(landService.paymentStatus(land.getPaymentDescription(), land.getParcelID())) {
			System.out.println("Payment Issue  Updated Successfully");
		}else {
			System.err.println("Failed to Update Paymnet Issue..");
		}	
		
	}//end of payment description
	
	
	public static void getAllLandDetails() {
		setland=landService.getAllLandDetails();
		if(setland!=null) {
			for(UserLand user:setland) {
				System.out.println(user);
			}
		}else {
			System.err.println("Unable to display Land details..");
		}
	}
}//end of class
