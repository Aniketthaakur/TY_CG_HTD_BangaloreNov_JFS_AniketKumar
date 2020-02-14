package com.capgimini.forestrymanagementsystem.controller;

import java.util.Scanner;

import com.capgimini.forestrymanagementsystem.exception.WrongInputException;

public class App {
	public static void main(String[] args) {

		while(true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("********Welcome To Forestry Managemet System******************");
			System.out.println();
			System.out.println();
			System.out.println("Press 1: Login as Admin");
			System.out.println("Press 2: Login as Client");

			int choice = 0;
			char temp='y';
			while(temp=='y') {
				try {
					choice = Integer.parseInt(sc.next());
					temp='n';
				} catch (Exception e) {
					System.err.println("Wrong input type provide integer only");

				}
			}
			switch (choice) {
			case 1:
				if (StaticMethods.adminLogin()) {
					System.out.println("Login sucessfully....");

					while (true) {

						System.out.println("Press 1: Client");
						System.out.println("Press 2: Scheduler");
						System.out.println("Press 3: Land");
						System.out.println("Press 4:Logout");
						int ch = 0;
						char temp1='y';
						while(temp1=='y') {
							try {
								ch = Integer.parseInt(sc.next());
								temp1='n';
							} catch (Exception e) {
								System.err.println("Wrong input type provide integer only");

							}
						}

						switch (ch) {
						case 1:
							System.out.println("Press 1: Add New Client");
							System.out.println("Press 2: Show All Client");
							System.out.println("Press 3: Modify Existing Client");
							System.out.println("Press 4: Delete Existing Client");
							System.out.println("Press 5: Show Product Details");
							System.out.println("Press 6: Logout");
							System.out.println("Press 7: Go Back");
							int a = sc.nextInt();
							switch (a) {
							case 1:
								StaticMethods.addClient();
								continue;
							case 2:
								StaticMethods.getAllClient();
								continue;
							case 3:
								StaticMethods.modifyClient();
								continue;
							case 4:
								StaticMethods.deleteClient();
								continue;
							case 5:
								StaticMethods.getAllProduct();
								continue;
							case 6:
								System.out.println("Logout Sucessully....");

								break;
							default:
								continue;
							}// end of client switch

							break;// end of client case 1
						case 2:
							System.out.println("Press 1: Schedule New Contractor");
							System.out.println("Press 2: Delete Particular Contract");
							System.out.println("Press 3: Show all Contracts");
							System.out.println("Press 4: Add New Product which Are In Demand");
							System.out.println("Press 5: Modify Particular Product");
							System.out.println("Press 6: Delete product Which Are Not In Demand ");
							System.out.println("Press 7: Show All Product Informations");
							System.out.println("Press 8: Logout");
							System.out.println("Press 9: Go Back");
							int b = 0;
							char temp2='y';
							while(temp2=='y') {
								try {
									b = Integer.parseInt(sc.next());
									temp2='n';
								} catch (Exception e) {
									System.err.println("Wrong input type provide integer only");

								}
							}
							switch (b) {
							case 1:
								StaticMethods.addContractor();
								continue;
							case 2:
								StaticMethods.deleteContractor();
								continue;
							case 3:
								StaticMethods.getAllContactor();
								continue;
							case 4:
								StaticMethods.addProduct();
								continue;
							case 5:
								StaticMethods.modifyProduct();
								continue;
							case 6:
								StaticMethods.deleteProduct();
								continue;
							case 7:
								StaticMethods.getAllProduct();
								continue;
							case 8:
								System.out.println("Logout Sucessully....");
								break;
							default:
								continue;

							}// end of scheduler switch

							break;// break of scheduler case
						case 3:
							System.out.println("Press 1: Show Contract Present ");
							System.out.println("Press 2: Get all Infomation of product");
							System.out.println("Press 3: Send Message Regarding Payment Issue");
							System.out.println("Press 4: Payment Status");
							System.out.println("Press 5: Logout");
							System.out.println("Press 6: Go Back");
							int c = 0;
							char temp3='y';
							while(temp3=='y') {
								try {
									c = Integer.parseInt(sc.next());
									temp3='n';
								} catch (Exception e) {
									System.err.println("Wrong input type provide integer only");

								}
							}
							switch (c) {
							case 1:
								StaticMethods.getAllContactor();
								continue;
							case 2:
								StaticMethods.getAllProduct();
								continue;
							case 3:
								StaticMethods.issueMessage();
								continue;
							case 4:
								StaticMethods.paymentStatus();
								continue;
							case 5:
								System.out.println("Logout Sucessully....");
								break;

							default:
								System.err.println("Wrong Input Please try Again....");
								continue;
							}// end of switch land

							break;// end of land case
						case 4:
							System.out.println("Logout Sucessully....");
							break;
						default:
							System.err.println("Wrong Input Please try Again....");
							continue;
						}// end of admin and client switch

						break;// break of admin case

					} // end of for
				} else {
					System.err.println("Wrong user name or password..");
					// end of if admin login
				}
				break;
			case 2:
				if (StaticMethods.clientLogin()) {
					System.out.println("Login sucessfully....");
					while (true) {
						System.out.println("Press 1: Add New Client");
						System.out.println("Press 2: Show All Client");
						System.out.println("Press 3: Modify Existing Client");
						System.out.println("Press 4: Delete Existing Client");
						System.out.println("Press 5: Logout");
						System.out.println("Press 6: Go Back");
						int d = 0;
						char temp4='y';
						while(temp4=='y') {
							try {
								d = Integer.parseInt(sc.next());
								temp4='n';
							} catch (Exception e) {
								System.err.println("Wrong input type provide integer only");

							}
						}
						switch (d) {
						case 1:
							StaticMethods.addClient();
							continue;
						case 2:
							StaticMethods.getAllClient();
							continue;
						case 3:
							StaticMethods.modifyClient();
							continue;
						case 4:
							StaticMethods.deleteClient();
							continue;
						case 5:
							System.out.println("Logout Sucessfully....");
							break;
						default:
							System.err.println("Wrong Input Please try Again....");
							continue;
						}
						break;
					}
					// end of client 
					// end of client case
				} else {
					System.err.println("Wrong user name or password..");
					// end of admin and client switch
				}
				break;
			}

		} // end of while
	}// end of main()
}// end of class
