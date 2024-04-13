package com.luu.model;

import java.sql.Timestamp;

public class Order {
	private String order_id;
	private Account acc;
	private String order_address;
	private String payemntmethod;
	private Timestamp dateOfPurchase;
	private int order_condition;
	
	
	public Order() {
	}


	public Order(String order_id, Account acc, String order_address, String payemntmethod, Timestamp dateOfPurchase,
			int order_condition) {
		super();
		this.order_id = order_id;
		this.acc = acc;
		this.order_address = order_address;
		this.payemntmethod = payemntmethod;
		this.dateOfPurchase = dateOfPurchase;
		this.order_condition = order_condition;
	}


	public String getOrder_id() {
		return order_id;
	}


	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	public Account getAcc() {
		return acc;
	}


	public void setAcc(Account acc) {
		this.acc = acc;
	}


	public String getOrder_address() {
		return order_address;
	}


	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}


	public String getPayemntmethod() {
		return payemntmethod;
	}


	public void setPayemntmethod(String payemntmethod) {
		this.payemntmethod = payemntmethod;
	}


	public Timestamp getDateOfPurchase() {
		return dateOfPurchase;
	}


	public void setDateOfPurchase(Timestamp dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}


	public int getOrder_condition() {
		return order_condition;
	}


	public void setOrder_condition(int order_condition) {
		this.order_condition = order_condition;
	}


	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", acc=" + acc + ", order_address=" + order_address + ", payemntmethod="
				+ payemntmethod + ", dateOfPurchase=" + dateOfPurchase + ", order_condition=" + order_condition + "]";
	}


	
	
	
	
}
