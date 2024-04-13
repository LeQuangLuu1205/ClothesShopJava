package com.luu.model;

public class Account {

	  private int acc_id;
	  private String acc_name;
	  private String acc_username;
	  private String acc_password;
	  private int acc_access;
	  private String acc_address;
	  private String acc_contact;
	  private int acc_condition;
	  
	public Account() {
		super();
	}
	

	public Account(int acc_id, String acc_name, String acc_username, String acc_password, int acc_access,
			String acc_address, String acc_contact, int acc_condition) {
		this.acc_id = acc_id;
		this.acc_name = acc_name;
		this.acc_username = acc_username;
		this.acc_password = acc_password;
		this.acc_access = acc_access;
		this.acc_address = acc_address;
		this.acc_contact = acc_contact;
		this.acc_condition = acc_condition;
	}


	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public String getAcc_username() {
		return acc_username;
	}

	public void setAcc_username(String acc_username) {
		this.acc_username = acc_username;
	}

	public String getAcc_password() {
		return acc_password;
	}

	public void setAcc_password(String acc_password) {
		this.acc_password = acc_password;
	}

	public int getAcc_access() {
		return acc_access;
	}

	public void setAcc_access(int acc_access) {
		this.acc_access = acc_access;
	}

	public String getAcc_address() {
		return acc_address;
	}

	public void setAcc_address(String acc_address) {
		this.acc_address = acc_address;
	}

	public String getAcc_contact() {
		return acc_contact;
	}

	public void setAcc_contact(String acc_contact) {
		this.acc_contact = acc_contact;
	}

	public int getAcc_condition() {
		return acc_condition;
	}

	public void setAcc_condition(int acc_condition) {
		this.acc_condition = acc_condition;
	}

	
	
	  
}
