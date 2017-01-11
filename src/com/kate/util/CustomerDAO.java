package com.kate.util;

import java.sql.*;
import java.util.*;

public class CustomerDAO {

	public static Connection getConnection(){
			Connection con = null;
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/JEE", "root", "");
			}catch(Exception e){
				System.out.println(e);
			}
			return con;	
	}
	
	// SAVE
	public static int save(Customer cust){
		int status=0;
		
		try{
			Connection con = CustomerDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Customers(CustomerName, ContactName, Address, City, PostalCode, Country) VALUES (?, ?, ?, ?, ?, ?)");
		
			ps.setString(1, cust.getCustName());
			ps.setString(2, cust.getContactName());
			ps.setString(3, cust.getAddress());
			ps.setString(4, cust.getCity());
			ps.setString(5, cust.getPostalCode());
			ps.setString(6, cust.getCountry());
		
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return status;
	}
	
	// UPDATE
	public static int update(Customer cust){
		int status=0;
		
		try{
			Connection con = CustomerDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE Customers SET CustomerName=?, ContactName=?, Address=?, City=?, PostalCode=?, Country=? WHERE CustomerID=?");
		
			ps.setString(1, cust.getCustName());
			ps.setString(2, cust.getContactName());
			ps.setString(3, cust.getAddress());
			ps.setString(4, cust.getCity());
			ps.setString(5, cust.getPostalCode());
			ps.setString(6, cust.getCountry());
			ps.setInt(7, cust.getCustID());
		
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return status;
	}
	
	//DELETE
	public static int delete(int CustID){
		int status =0;
		
		try{
			Connection con = CustomerDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM Customers WHERE CustomerID=?");
			
			ps.setInt(1, CustID);
			
			status = ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return status;
	}
	
	//GET Customer by ID
	public static Customer getCustomerById(int CustID){
		Customer cust = new Customer();
		
		try{
			Connection con = CustomerDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Customers WHERE CustomerID=?");
			
			ps.setInt(1, CustID);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				cust.setCustID(rs.getInt(1));
				cust.setCustName(rs.getString(2));
				cust.setContactName(rs.getString(3));
				cust.setAddress(rs.getString(4));
				cust.setCity(rs.getString(5));
				cust.setPostalCode(rs.getString(6));
				cust.setCountry(rs.getString(7));
			}
			
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return cust;
	}
	
	//GET ALL Customers
	public static List<Customer>getAllCustomers(){
		
		List<Customer> list = new ArrayList<Customer>();
		
		try{
			Connection con = CustomerDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Customers");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Customer cust = new Customer();
				
				cust.setCustID(rs.getInt(1));
				cust.setCustName(rs.getString(2));
				cust.setContactName(rs.getString(3));
				cust.setAddress(rs.getString(4));
				cust.setCity(rs.getString(5));
				cust.setPostalCode(rs.getString(6));
				cust.setCountry(rs.getString(7));
				list.add(cust);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
