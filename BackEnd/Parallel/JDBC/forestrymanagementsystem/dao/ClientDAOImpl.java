package com.cap.forestrymanagementsystem.dao;

import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import com.cap.forestrymanagementsystem.dto.UserAdmin;
import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserOrder;
import com.cap.forestrymanagementsystem.dto.UserProduct;

public class ClientDAOImpl implements ClientDAO {

	FileReader reader;
	Properties properties;
	UserProduct product;
	UserClient client;
	UserOrder order;
	UserAdmin admin;
	UserContractor contractor;
	UserContractor scheduler;
	
   Set<UserOrder> setOrder;
   Set<UserClient> setclient;
   Set<UserContractor> setContractor;
   
    public ClientDAOImpl() {
    	try {
    		reader = new FileReader("db.properties");
			properties = new Properties();
			properties.load(reader);
    	}catch (Exception e) {
    	e.printStackTrace();
    	}
    
    }
   
   
	@Override
	public boolean orderContracts(UserContractor contract)
	{
		try (Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("dbUser"),properties.getProperty("dbPassword"));
				PreparedStatement pstmt= con.prepareStatement(properties.getProperty("insertContractor"));
				){
			
			pstmt.setInt(1, contract.getHaulierId());
			pstmt.setInt(2, contract.getContractorNo());
			pstmt.setInt(3, contract.getCustomerId());
			pstmt.setInt(4, contract.getProductId());
			pstmt.setInt(5, contract.getQuantity());
			pstmt.setString(6, contract.getDeliveryDate());
			pstmt.setString(7, contract.getDeliveryDay());
			pstmt.setInt(8, contract.getParcelId());
			
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	

	@Override
	public boolean updateProduct(int productId, String productName)
	{
		
		try (Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("dbUser"),properties.getProperty("dbPassword"));
				PreparedStatement pstmt= con.prepareStatement(properties.getProperty("updateProduct"));
				){
			
			pstmt.setString(1, productName);
			pstmt.setInt(2, productId);
			
			
			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
			
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		
		
		return false;
	}
	@Override
	public Set<UserOrder> showOrder() {
		setOrder =new HashSet<UserOrder>();
	
		try(Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("dbUser"),properties.getProperty("dbPassword"));
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(properties.getProperty("ShowOrder"))){
			    while(rs.next()) {
			    	order=new UserOrder();
			    	order.setOrderNO(rs.getInt(1));
			    	order.setCustomerId(rs.getInt(2));
			    	order.setHaulierId(rs.getInt(3));
			    	order.setProductId(rs.getInt(4));
			    	order.setQuantity(rs.getInt(5));
			    	order.setDeliveryDate(rs.getString(6));
			    	
			    	setOrder.add(order);
			    }
			    return setOrder;
		}catch (Exception e) {
			e.getMessage();
		}
		return null;
	}


	@Override
	public Set<UserClient> getAllClient() {
		setclient=new HashSet<UserClient>();
		try(Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("dbUser"),properties.getProperty("dbPassword"));	
						Statement stmt=con.createStatement();
								ResultSet rs=stmt.executeQuery(properties.getProperty("queryGetAllClient"))){
					
				while(rs.next())
				{
					client=new UserClient();
					client.setCustomerId(rs.getInt(1));
					client.setPhoneNumber(rs.getLong(2));
					client.setCustomerName(rs.getString(3));
					client.setStreetAddess1(rs.getString(4));
					client.setStreetAddess2(rs.getString(5));
					client.setTown(rs.getString(6));
					client.setPostalCode(rs.getInt(7));
					client.setEmail(rs.getString(8));
					setclient.add(client);
				}
				
			return setclient;
		}catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean updateContract(int contractorNo, int haulierId) {

		try (Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("dbUser"),properties.getProperty("dbPassword"));
				PreparedStatement pstmt= con.prepareStatement(properties.getProperty("queryUpdateContract"));
				){
			
			pstmt.setInt(1, contractorNo);
			pstmt.setInt(2, haulierId);
			
			
			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
			
			
		}catch (Exception e) {
			e.getMessage();
		}
		

		return false;
	}


	@Override
	public boolean deleteContract(int haulierId) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("queryDeleteContract"));) {
			pstmt.setInt(1, haulierId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;

	}
		
	

	@Override
	public boolean addProduct(UserProduct product) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("queryAddProduct"));) {
			
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getProductDescription());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return false;
	}
		


	@Override
	public boolean deleteProduct(int prouctId) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("queryDeleteProduct"));) {
			pstmt.setInt(1, prouctId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;

	}



	@Override
	public String clientLogin(String name, String password) {
		
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("queryLogin"));) {
			pstmt.setString(1, name);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			String user=null;
			while (rs.next()) {
			
				user=rs.getString(1);
			}
			return user;
		} catch (Exception e) {
			e.getMessage();
		}
		
		return null;
	}


	@Override
	public Set<UserContractor> contractInformation() {
		 setContractor=new HashSet<UserContractor>();
		try(Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("dbUser"),properties.getProperty("dbPassword"));
				Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(properties.getProperty("queryGetAllContract"))){
			while(rs.next()) {
			contractor=new UserContractor();
			contractor.setHaulierId(rs.getInt(1));
			contractor.setContractorNo(rs.getInt(2));
			contractor.setCustomerId(rs.getInt(3));
			contractor.setProductId(rs.getInt(4));
			contractor.setQuantity(rs.getInt(5));
			contractor.setDeliveryDate(rs.getString(6));
			contractor.setDeliveryDay(rs.getString(7));
			contractor.setParcelId(rs.getInt(8));
			 
			setContractor.add(contractor);
			}
			return setContractor;
		}catch (Exception e) {
			e.getMessage();
		}
		
		return null;
	}

	@Override
	public boolean searchProduct(int productId) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("searchProduct"));) {
			pstmt.setInt(1, productId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}} catch (Exception e) {
				e.getMessage();
			}
	return false;	
	}


	@Override
	public boolean searchClient(int customerId) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("searchClient"));) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}} catch (Exception e) {
				e.getMessage();
			}
		return false;
	}


	@Override
	public boolean searchContractor(int haulierId) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("searchContractor"));) {
			pstmt.setInt(1, haulierId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}} catch (Exception e) {
				e.getMessage();
			}
		return false;
		
	}


	@Override
	public boolean searchParcel(int parcelId) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("searchParcel"));) {
			pstmt.setInt(1, parcelId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}} catch (Exception e) {
				e.getMessage();
			}
		return false;
	}
}
