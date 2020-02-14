package com.cap.forestrymanagementsystem.controller;

import java.util.Scanner;

public class AppFMS {
	public static void main(String[] args) {
		char ch='y';
		while (true) {
			
			Scanner sc = new Scanner(System.in);
		System.out.println("                 ==============================");
		System.out.println("**************Welcome To ForestryManagement System********************");
		System.out.println("                 ==============================");
		
			
			System.out.println("Press 1: Login As ADMIN");
			System.out.println("Press 2: Login As Existing Client");
			int chioce =0;
			try {
				chioce=Integer.parseInt(sc.next());
			}catch (Exception e) {
				System.err.println("Please Enter Integer Only");
			}
			switch (chioce) {
			case 1:

				if (AdminStaticMethods.login()) {
					
					ch='y';
					while (ch=='y') {
						System.out.println("Press 1: Admin");
						System.out.println("Press 2: Client");
						System.out.println("Press 3: Scheduler");
						System.out.println("Press 4: Land");
						System.out.println("Press 5: Logout");
						
						int choice =0;
						try {
							choice=Integer.parseInt(sc.next());
						}catch (Exception e) {
							System.err.println("Please Enter Integer Only");
						}
						switch (choice) {
						case 1:
							System.out.println("Press 1: Add Client");
							System.out.println("Press 2: Show All Product Details");
							System.out.println("Press 3: Show All Contracts");
							System.out.println("Press 4: Delete Existing Client");
							System.out.println("Press 5: Logout");
							int choice1 =0;
							try {
								choice1=Integer.parseInt(sc.next());
							}catch (Exception e) {
								System.err.println("Please Enter Integer Only");
							}
							switch (choice1) {
							case 1:
								AdminStaticMethods.addClient();
								continue;
							case 2:
								AdminStaticMethods.getAllProduct();
								continue;
							case 3:
								AdminStaticMethods.showContracts();
								continue;
							case 4:
								AdminStaticMethods.deleteClient();
								continue;
							case 5:
								ch='n';
							System.out.println();
							
							System.out.println();
								break;
							default:
								System.err.println("Please Enter Correct Input");
								continue;
							}

							break;
						case 2:
							System.out.println("press 1: for Order contract");
							System.out.println("press 2: for Update Inventory Product");
							System.out.println("press 3: to show orders");
							System.out.println("Press 4: to Show All Details of Client");
							System.out.println("press 5: To Update Contract Information ");
							System.out.println("Press 6: To Delete Specified Contract");
							System.out.println("Press 7: To Add New Product");
							System.out.println("Press 8: To Delete Existing Product");
							System.out.println("Press 9: To View All Contracts");
							System.out.println("press 10: To Logout");
							System.out.println("press 11: To Go Main Menu");
							int a =0;
							try {
								a=Integer.parseInt(sc.next());
							}catch (Exception e) {
								System.err.println("Please Enter Integer Only");
							}
							switch (a) {
							case 1:
								ClientStaticMethod.addContractor();
								continue;
							case 2:
								ClientStaticMethod.updateInventoryProduct();
								continue;
							case 3:
								ClientStaticMethod.showOrder();
								continue;
							case 4:
								ClientStaticMethod.getAllClient();
								continue;
							case 5:
								ClientStaticMethod.updateContract();
								continue;
							case 6:
								ClientStaticMethod.deleteContract();
								continue;
							case 7:
								ClientStaticMethod.addProduct();
								continue;
							case 8:
								ClientStaticMethod.deleteProduct();
								continue;
							case 9:
								ClientStaticMethod.getAllContractor();
								continue;
							case 10:ch='n';
							System.out.println();
							
							System.out.println();
								break;
							default:
								System.err.println("Please Enter Correct Input");
								continue;
							}// end of inner switch

							break;
						case 3:
							System.out.println("Press 1: To Show All  Product Present");
							System.out.println("Press 2: Add New Orders ");
							System.out.println("Press 3: Assign New Contracts");
							System.out.println("Press 4: Show All Order Presents");
							System.out.println("Press 5: Assign New Transportation");
							System.out.println("Press 6: Retrive All Transportation Details");
							System.out.println("Press 7: Update Transportaion Information ");
							System.out.println("Press 8: Logout");
							System.out.println("press 9: To Go Main Menu");
							int choice2 =0;
							try {
								choice2=Integer.parseInt(sc.next());
							}catch (Exception e) {
								System.err.println("Please Enter Integer Only");
							}
							switch(choice2) {
							
							case 1:
								AdminStaticMethods.getAllProduct();
								continue;
							case 2:
								SchedulerStaticMethods.addOrder();
								continue;
							case 3:
								ClientStaticMethod.addContractor();
								continue;
							case 4:
								ClientStaticMethod.showOrder();
								continue;
							case 5:
								SchedulerStaticMethods.addHaulier();
								continue;
							case 6:
								SchedulerStaticMethods.getAllHaulier();
								continue;
							case 7:
								SchedulerStaticMethods.updateHaulier();
								continue;
							case 8:
								ch='n';
								System.out.println();
								
								System.out.println();
								break;
							case 9:
								break;
							default:
								System.err.println("Please Enter Correct Input");
								continue;
							}
							break;
						case 4:
							System.out.println("Press 1: Add Parcel Land Area  ");
							System.out.println("Press 2: To Specify Parcel Transaction Status");
							System.out.println("Press 3: Update Issues You Are While Transaction");
							System.out.println("Press 4: Retrive Information Of Parcel ");
							System.out.println("Press 5: Logout");
							System.out.println("press 6: To Go Main Menu");
							int choice3 =0;
							try {
								choice3=Integer.parseInt(sc.next());
							}catch (Exception e) {
								System.err.println("Please Enter Integer Only");
							}
							switch(choice3) {
							case 1:LandStaticMethods.addLandRecord();
								continue;
							case 2:LandStaticMethods.paymentStatus();
							continue;
							case 3:LandStaticMethods.updatePaymentDescription();
							continue;
							case 4:LandStaticMethods.getAllLandDetails();
							continue;
							case 5:
								ch='n';
								System.out.println();
								
								System.out.println();
								break;
							case 6:
								continue;
							default:
								continue;
							}
							
							
							break;
						case 5:
							ch='n';
							System.out.println(); 
					
							break;
						default:
							break;
						}
					} // end of while
				} else {
					System.err.println("Invalid Credential  Please try again....!!!!");
				} // end else
			
				break;
			case 2:
				if (ClientStaticMethod.clientLogin()) {
					ch='y';
					while (ch=='y') {
						System.out.println("press 1 for Order contract");
						System.out.println("press 2 for Update Inventory Product");
						System.out.println("press 3 to show orders");
						System.out.println("Press 4 to Show All Details of Client");
						System.out.println("press 5 To Update Contract Information ");
						System.out.println("Press 6 To Delete Specified Contract");
						System.out.println("Press 7 To Add New Product");
						System.out.println("Press 8 To Delete Existing Product");
						System.out.println("Press 9 To View All Contracts");
						System.out.println("press 10 To Logout");
						int a =0;
						try {
							a=Integer.parseInt(sc.next());
						}catch (Exception e) {
							System.err.println("Please Enter Integer Only");
						}
						switch (a) {
						case 1:
							ClientStaticMethod.addContractor();
							continue;
						case 2:
							ClientStaticMethod.updateInventoryProduct();
							continue;
						case 3:
							ClientStaticMethod.showOrder();
							continue;
						case 4:
							ClientStaticMethod.getAllClient();
							continue;
						case 5:
							ClientStaticMethod.updateContract();
							continue;
						case 6:
							ClientStaticMethod.deleteContract();
							continue;
						case 7:
							ClientStaticMethod.addProduct();
							continue;
						case 8:
							ClientStaticMethod.deleteProduct();
							continue;
						case 9:
							ClientStaticMethod.getAllContractor();
							continue;
						case 10:ch='n';
						System.out.println();
					
						System.out.println();
							break;
						default:
							System.err.println("Please Enter Correct Input");
							break;
						}// end of inner switch

					} // end of while
				} else {
					System.err.println("Invalid Credential  Please try again....!!!!");
				} // end of else

				break;
			}

	
		
		} // end of while
	}// end of main()
}// end of class
