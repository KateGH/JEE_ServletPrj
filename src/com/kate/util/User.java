package com.kate.util;

//En klass som representerar en användare
public class User {
	
	private String name;
	private String email;
	private int id;

	public User(String name, String email, int id){
		this.name = name;
		this.email = email;
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return "Name=" + this.name + ", Email=" + this.email;
	}
}
