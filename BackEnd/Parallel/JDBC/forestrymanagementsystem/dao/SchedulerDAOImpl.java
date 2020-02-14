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

import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserHaulier;
import com.cap.forestrymanagementsystem.dto.UserOrder;
import com.cap.forestrymanagementsystem.dto.UserProduct;

public class SchedulerDAOImpl implements SchedulerDAO{

	FileReader reader;
	Properties properties;
	UserContractor contractor;
	UserOrder order;
	UserHaulier haulier;
	UserProduct product;
	Set<UserProduct> setProduct;
	Set<UserHaulier> setHaulier;
	Set<UserOrder> setOrder;
	public SchedulerDAOImpl() {
		try {
			reader = new FileReader("db.properties");
			properties = new Properties();
			properties.load(reader);
			Class.forName(properties.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addOrder(UserOrder order) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("queryAddOrder"));) {
			pstmt.setInt(1, order.getOrderNO());
			pstmt.setInt(2, order.getCustomerId());
			pstmt.setInt(3, order.getHaulierId());
			pstmt.setInt(4, order.getProductId());
			pstmt.setInt(5, order.getQuantity());
			pstmt.setString(6, order.getDeliveryDate());
			
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return false;
	}

	
	

	@Override
	public boolean addHaulier(UserHaulier haulier) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("queryAddHaulier"));) {
			pstmt.setInt(1, haulier.getHaulierId());
			pstmt.setString(2,haulier.getHaulierName());
			pstmt.setLong(3, haulier.getHaulierPhoneNo());
			pstmt.setString(4, haulier.getHaulierName());
			
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Set<UserHaulier> getAllHaulier() {
		setHaulier = new HashSet<UserHaulier>();
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(properties.getProperty("querygetAllHaulier"))) {

			while (rs.next()) {
				haulier=new UserHaulier();
				haulier.setHaulierId(rs.getInt(1));
				haulier.setHaulierName(rs.getString(2));
				haulier.setHaulierPhoneNo(rs.getLong(3));
				haulier.setHaulierTown(rs.getString(4));
				setHaulier.add(haulier);
			}

			return setHaulier;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateHaulier(long haulierPhoneNo, String haulierName) {

		try (Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("dbUser"),properties.getProperty("dbPassword"));
				PreparedStatement pstmt= con.prepareStatement(properties.getProperty("queryupdateHaulier"));
				){
			
			pstmt.setLong(1,haulierPhoneNo);
			pstmt.setString(2, haulierName );
			
			
			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
