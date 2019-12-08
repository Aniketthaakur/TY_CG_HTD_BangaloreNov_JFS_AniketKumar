package com.caps.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.caps.dao.ContractorDAO;
import com.caps.dao.CustomerDAO;
import com.caps.dao.ProductDAO;
import com.caps.dao.ProductDAOImpl;
import com.caps.factory.Factory;
import com.caps.userbean.dto.UserContractor;
import com.caps.userbean.dto.UserCustomer;
import com.caps.userbean.dto.UserProduct;

public class App {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		UserContractor user;
		UserCustomer userC;
		UserProduct  prod;
		
		ContractorDAO contrator=Factory.objectContractor();		
		ProductDAO product=Factory.objectProduct();
		CustomerDAO customer=Factory.objectCustomer();
		
		Set<UserProduct> set=new HashSet<UserProduct>();
		Set<UserContractor> s=new HashSet<UserContractor>();
		Set<UserCustomer> s2=new HashSet<UserCustomer>();
		
		Map<Integer,Set<UserContractor>> m=new HashMap<Integer,Set<UserContractor>>();
		Map<Integer,Set<UserCustomer>> m1=new HashMap<Integer,Set<UserCustomer>>();
		Map<Integer,Set<UserProduct>> m2=new HashMap<Integer,Set<UserProduct>>();

		while(true) {
			user=new UserContractor();
			userC=new UserCustomer();
			prod=new UserProduct();
			System.out.println("------welcome------");
			System.out.println("Option 1 : Contractor");
			System.out.println("Option 2 : Customer");
			System.out.println("Option 3 : Product");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("select option to perform operation");
				System.out.println("Option 1 : Add contractor");
				System.out.println("Option 2 : Delete contractor");
				System.out.println("Option 3 : get all user ");
				int a=sc.nextInt();
				switch(a)
				{

				case 1:
					System.out.println("Enter Contract number");
					user.setContractorNo(sc.nextInt());
					System.out.println("Enter Contract Id");
					user.setContractorId(sc.nextInt());
					System.out.println("Enter Product Id");
					user.setProductId(sc.nextInt());
					System.out.println("Enter Delivery Date");
					user.setDate(sc.next());
					System.out.println("Enter Delivery Day");
					user.setDay(sc.next());
					System.out.println("Enter Quantity");
					user.setQuantity(sc.nextInt());
					System.out.println("create sucessfully......");
					contrator.addContractor(user);
					s=	contrator.getUser();		
					m.put(user.getContractorId(), s);
					break;


				case 2:
					System.out.println("Enter ContractorId");
					int ContractorId=sc.nextInt();
					if(contrator.deleteContactor(ContractorId, user))
					{
						m.remove(ContractorId);
						System.out.println("Deleted succcessfully........");
					}
					else
					{
						System.err.println("something went wrong");
					}
					break;
					
				case 3: 
					Set<Entry<Integer,Set<UserContractor>>> s1=m.entrySet();
					for(Entry<Integer,Set<UserContractor>> e:s1)
					{
						System.out.println("Customer Id --->"+e.getKey());
						System.out.println(e.getValue());
					}
					break;
				default:
					break;
				}



				break;

			case 2:
				System.out.println("select option to perform operation");
				System.out.println("Option 1 : Add customer");
				System.out.println("Option 2 : Delete customer");
				System.out.println("Option 3 : get all customer ");
				System.out.println("Option 4 : Modify Customer");
				int b=sc.nextInt();	
				switch(b)
				{

				case 1:
					System.out.println("Enter customer id:");
					userC.setCustomerId(sc.nextInt());
					System.out.println("Enter customer name:");
					userC.setCustomerName(sc.next());
					System.out.println("Enter Street Address 1:");
					userC.setStreetAddress1(sc.next());
					System.out.println("Enter Street Address 2:");
					userC.setStreetAddress2(sc.next());
					System.out.println("Enter Town name:");
					userC.setTown(sc.next());
					System.out.println("Enter PIN CODE :");
					userC.setPinCode(sc.nextInt());
					System.out.println("Enter Phone number:");
					userC.setPhNo(sc.nextLong());
					System.out.println("create sucessfully......");
					customer.addCustomer(userC);
					s2=	customer.getAllCustomer();		
					m1.put(userC.getCustomerId(), s2);
					
					break;


				case 2:
					System.out.println("Enter customerID:");
					int customerID=sc.nextInt();
					if(customer.deleteCustomer(customerID,userC))
					{
						m1.remove(customerID);
						System.out.println("Deleted succcessfully........");
					}
					else
					{
						System.err.println("something went wrong");
					}
					break;
					
				case 3: 
					Set<Entry<Integer,Set<UserCustomer>>> s3=m1.entrySet();
					for(Entry<Integer,Set<UserCustomer>> e:s3)
					{
						System.out.println("Customer Id --->"+e.getKey());
						System.out.println(e.getValue());
					}
					break;
				case 4:
					System.out.println("enter customer id:");
					int customerid=sc.nextInt();

					if(customer.modifyCustomer(customerid, userC))
					{
						m1.remove(customerid);
						System.out.println("Enter customer id:");
						userC.setCustomerId(customerid);
						System.out.println("Enter customer name:");
						userC.setCustomerName(sc.next());
						System.out.println("Enter Street Address 1:");
						userC.setStreetAddress1(sc.next());
						System.out.println("Enter Street Address 2:");
						userC.setStreetAddress2(sc.next());
						System.out.println("Enter Town name:");
						userC.setTown(sc.next());
						System.out.println("Enter PIN CODE :");
						userC.setPinCode(sc.nextInt());
						System.out.println("Enter Phone number:");
						userC.setPhNo(sc.nextLong());
						System.out.println("modify sucessfully......");
						customer.addCustomer(userC);
						s2=customer.getAllCustomer();
						m1.put(customerid, s2);
						System.out.println(m1.get(customerid));
						
						
					}
					break;
				default:
					break;
				}

				break;
				 

			case 3:

				System.out.println("select option to perform operation");
				System.out.println("Option 1 : Add Product");
				System.out.println("Option 2 : Delete Product");
				System.out.println("Option 3 : get all Product ");
				System.out.println("Option 4 : Modify Product");
				int c=sc.nextInt();	
				switch(c)
			
				{
				case 1:
					System.out.println("Enter Product Id:");
					prod.setProductId(sc.nextInt());
					System.out.println("Enter Product Name");
					prod.setProductName(sc.next());
					System.out.println("Enter Product Details");
					prod.setProductDetail(sc.next());
					System.out.println("Enter product MRP");
					prod.setProductMRP(sc.nextDouble());
					System.out.println("product added successfully.....");
					product.addProduct(prod);
					set=product.getProduct();
					m2.put(prod.getProductId(), set);
				
					break;
				case 2:
					System.out.println("Enter Product Id:");
					int productId=sc.nextInt();
					if(product.deleteProduct(productId, prod))
					{
						m2.remove(productId);
						System.out.println("Deleted Successfully");
					}
					else
					{
						System.err.println("Something went wrong");
					}
					break;
				case 3:
					   Set<Entry<Integer,Set<UserProduct>>> s9 = m2.entrySet();
					   for(Entry<Integer,Set<UserProduct>> e:s9)
					   {
						   System.out.println("Product Id :"+e.getKey());
						   System.out.println(e.getValue());
					   }
					   
					   
					   break;
				case 4:
					System.out.println("Enter Product id");
					int prodId=sc.nextInt();
					if(product.modifyProduct(prodId, prod))
					{
						m2.remove(prodId);
						System.out.println("Enter Product Id:");
						prod.setProductId(prodId);
						System.out.println("Enter Product Name");
						prod.setProductName(sc.next());
						System.out.println("Enter Product Details");
						prod.setProductDetail(sc.next());
						System.out.println("Enter product MRP");
						prod.setProductMRP(sc.nextDouble());
						System.out.println("Modify Successfully...");
						product.addProduct(prod);
						set=product.getProduct();
						m2.put(prodId, set);
						System.out.println(m2.get(prodId));
					}
					break;
				}

				
				
				break;
			}
		}

	}
}

