package com.cap.appdevelopment.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cap.appdevelopment.dto.Contact;


public class ContactDAOImpl implements ContactDAO{
	FileReader reader;
	Properties prop;
	Contact user;
	
	

	public ContactDAOImpl() {
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public List<Contact> getAllContact() {
		List<Contact> list = new ArrayList<Contact>();
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query1"))) {
		while (rs.next()) {
				user = new Contact();
				user.setName(rs.getString(1));
				user.setNumber(rs.getInt(2));
				user.setGroup(rs.getString(3));
				list.add(user);
		}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateContact(String  name,int  number) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dbUrl"),
		prop.getProperty("dbUser"),prop.getProperty("dbPassword"));	
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("queryUpdate"));)
		{
			pstmt.setInt(1, number);
			pstmt.setString(2, name);
			
			
			int count =pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteContact(String  name) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("queryDelete"));)
		{
			pstmt.setString(1, name);
			
			int count =pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addContact(Contact user) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("insertQuery"));) {
			pstmt.setInt(2, user.getNumber());
			pstmt.setString(1, user.getName());
			pstmt.setString(3, user.getGroup());
			
			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
