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

import com.cap.forestrymanagementsystem.dto.UserLand;

public class LandDAOImpl implements LandDAO {
	
	FileReader reader;
	Properties properties;
	 Set<UserLand> setLand;
	 UserLand land;
	public LandDAOImpl() {
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
	public boolean addLandRecord(UserLand land) {
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(properties.getProperty("queryAddLand"));) {
			pstmt.setInt(1, land.getParcelID());
			pstmt.setString(2,land.getParcelArea() );
			pstmt.setString(3, land.getParcelPaymentSlip());
			pstmt.setString(4, land.getPaymentDescription());
			
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
	public boolean paymentStatus(String parcelPaymentSlip, int parcelID) {

		try (Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("dbUser"),properties.getProperty("dbPassword"));
				PreparedStatement pstmt= con.prepareStatement(properties.getProperty("updatepaymentStatus"));
				){
			
			pstmt.setString(1, parcelPaymentSlip);
			pstmt.setInt(2, parcelID);
			
			
			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updatePaymentDescription(String paymentDescription, int parcelID) {
		try (Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("dbUser"),properties.getProperty("dbPassword"));
				PreparedStatement pstmt= con.prepareStatement(properties.getProperty("updatePaymentDescription"));
				){
			
			pstmt.setString(1, paymentDescription);
			pstmt.setInt(2, parcelID);
			
			
			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<UserLand> getAllLandDetails() {
		setLand = new HashSet<UserLand>();
		try (Connection con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPassword"));
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(properties.getProperty("queryGetAllLand"))) {

			while (rs.next()) {
				land=new UserLand();
				
				land.setParcelID(rs.getInt(1));
				land.setParcelArea(rs.getString(2));
				land.setParcelPaymentSlip(rs.getString(3));
				land.setPaymentDescription(rs.getString(4));
				setLand.add(land);
			}

			return setLand;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
