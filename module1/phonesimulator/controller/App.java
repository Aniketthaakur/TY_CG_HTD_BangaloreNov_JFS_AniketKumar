package com.cap.appdevelopment.controller;

import java.util.List;
import java.util.Scanner;

import com.cap.appdevelopment.dao.ContactDAO;
import com.cap.appdevelopment.dto.Contact;
import com.cap.appdevelopment.factory.Factory;

public class App {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Contact contact;
		
		
		
		
		ContactDAO dao=Factory.objectContact();
		
		while(true)
		{
		System.out.println("Press 1 to show all contacts");
		System.out.println("Press 2 to Search for contact");
		System.out.println("Press 3 to Operate on contact");
		int a=sc.nextInt();

		
			contact=new Contact();

			switch(a)
			{
			case 1:
				List<Contact> list=dao.getAllContact();

				if(list !=null)
				{
					for(Contact user:list)
					{
						System.out.println(user);
					}

				}


				break;
			case 2:
				System.out.println("Press 1 to call");
				System.out.println("Press 2 to message");
				System.out.println("Press 3 to go back main menu");
				int b=sc.nextInt();
				switch(b)
				{
				case 1:

					List<Contact> list1	=dao.getAllContact();

					if(list1 !=null)
					{
						for(Contact user:list1)
						{
							System.out.println(user);
						}

					}
					System.out.println("press 1 to call");
					System.out.println("press 2 to end call");
					
					int b1=sc.nextInt();
					System.out.println("Calling ....");
					int b2=sc.nextInt();
					System.out.println("Call end....");

					break;
				case 2:

					System.out.println("Write some message");
					String msg=sc.next();
					System.out.println(msg);

					System.out.println("Click 1 to sent message");
					int a1=sc.nextInt();
					System.out.println("Message sent succesfully....");


					break;
				default:
					break;
				}

				break;
			case 3:
				
				System.out.println("Press 1 to add contact");
				System.out.println("Press 2 to delete contact");
				System.out.println("Press3 3 to edit contact");
				
				int c=sc.nextInt();
				switch(c)
				{
				case 1:
					
					System.out.println("Enter  name");
					contact.setName(sc.next());
					System.out.println("Enter phone number..");
					contact.setNumber(Integer.parseInt(sc.next()));
					System.out.println("Enter user group");
					contact.setGroup(sc.next());
					
					if(dao.addContact(contact))
					{
						System.out.println("contact inserted...");
					}else
					{
						System.err.println("Something went wrong..");
					}
					
					break;
				case 2:
					System.out.println("Enter Name...");
					contact.setName(sc.next());
					
					if(dao.deleteContact(contact.getName()))
					{
						System.out.println("contact deleted");
					}else
					{
						System.err.println("something went wrong...");
					}
					
					break;
				case 3:
					
					System.out.println("Enter Name...");
					contact.setName(sc.next());
					System.out.println("enter number to update..");
					contact.setNumber(Integer.parseInt(sc.next()));
				
				
					
					if(dao.updateContact(contact.getName(), contact.getNumber()))
					{
						System.out.println("Number update successfully....");
					}else
					{
						System.err.println("something went wrong....");
					}
					
					break;
				default:
					break;
				}

				break;

			default :
				break;
			}


		}

	}
}