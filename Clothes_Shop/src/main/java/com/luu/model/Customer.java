package com.luu.model;

public class Customer {
	private int id;
	private String fullname;
	private String email;
	private String address;
	private String contract;
	private String password;
	
	public Customer() {
	}

	public Customer(int id, String fullname, String email, String address, String contract, String password) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.contract = contract;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
