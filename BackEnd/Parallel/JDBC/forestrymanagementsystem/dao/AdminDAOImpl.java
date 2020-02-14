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
import com.cap.forestrymanagementsystem.dto.UserProduct;
import com.cap.forestrymanagementsystem.dto.UserContractor;

public class AdminDAOImpl implements AdminDAO {

	FileReader reader;
	Properties prop;
	UserAdmin user;
	UserProduct product;
	UserContractor scheduler;
	Set<UserProduct> set;
	Set<UserContractor> set1;

	public AdminDAOImpl() {
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String login(String username, String password) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("queryLogin"));) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			String result=null;
			while (rs.next()) {
				result=rs.getString(1);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addClient(UserClient bean) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("insertquery"));) {
			pstmt.setInt(1, bean.getCustomerId());
			pstmt.setLong(2, bean.getPhoneNumber());
			pstmt.setString(3, bean.getCustomerName());
			pstmt.setString(4, bean.getStreetAddess1());
			pstmt.setString(5, bean.getStreetAddess2());
			pstmt.setString(6, bean.getTown());
			pstmt.setInt(7, bean.getPostalCode());
			pstmt.setString(8, bean.getEmail());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return false;
	}

	public Set<UserProduct> getAllProduct() {
		set = new HashSet<UserProduct>();
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("queryAllProduct"))) {

			while (rs.next()) {
				product = new UserProduct();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductDescription(rs.getString(3));

				set.add(product);
			}

			return set;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Set<UserContractor> showContracts() {
		set1 = new HashSet<UserContractor>();
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("queryAllScheduler"))) {
			while (rs.next()) {
				scheduler = new UserContractor();
				
				scheduler.setHaulierId(rs.getInt(1));
				scheduler.setContractorNo(rs.getInt(2));
				scheduler.setCustomerId(rs.getInt(3));
				scheduler.setProductId(rs.getInt(4));
				scheduler.setQuantity(rs.getInt(5));
				scheduler.setDeliveryDate(rs.getString(6));
				scheduler.setDeliveryDay(rs.getString(7));
				scheduler.setParcelId(rs.getInt(8));

				set1.add(scheduler);
			}
			return set1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean deleteClient(int customerId) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("queryDeleteClient"));) {
			pstmt.setInt(1, customerId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;

	}

}
