package com.kate.util;

public class Customer {
	
	private int CustID;
	private String CustName;
	private String ContactName;
	private String Address;
	private String City;
	private String PostalCode;
	private String Country;
	
	public Customer(){
		
	}
	
	public Customer(int CustID, String CustName, String ContactName, String Address, String City, String PostalCode, String Country){
		this.CustID = CustID;
		this.CustName = CustName;
		this.ContactName = ContactName;
		this.Address = Address;
		this.City = City;
		this.PostalCode = PostalCode;
		this.Country = Country;
	}
	
	public int getCustID() {
		return CustID;
	}

	public void setCustID(int custID) {
		CustID = custID;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public String getContactName() {
		return ContactName;
	}

	public void setContactName(String contactName) {
		ContactName = contactName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString(){
		return "CustomerID=" + this.CustID + ", CustomerName=" + this.CustName;
	}
		

}
