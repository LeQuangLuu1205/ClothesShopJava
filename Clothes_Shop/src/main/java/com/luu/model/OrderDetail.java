package com.luu.model;

public class OrderDetail {
	private int orderdetail_id;
	private Order order;
	private Product product;
	private int quantity;
	private double price;
	
	public OrderDetail() {
	}

	public OrderDetail(int orderdetail_id, Order order, Product product, int quantity, double price) {
		this.orderdetail_id = orderdetail_id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderdetail_id() {
		return orderdetail_id;
	}

	public void setOrderdetail_id(int orderdetail_id) {
		this.orderdetail_id = orderdetail_id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
