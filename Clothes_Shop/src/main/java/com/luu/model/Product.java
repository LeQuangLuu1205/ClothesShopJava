package com.luu.model;

public class Product implements Comparable<Product>{
	private String product_id;
	private String product_name;
	private double product_price;
	private int product_quantity;
	private String product_img;
	private String product_description;
	private String category_id;
	
	public Product() {
	}

	public Product(String product_id, String product_name, double product_price, int product_quantity,
			String product_img, String product_description, String category_id) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_img = product_img;
		this.product_description = product_description;
		this.category_id = category_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	@Override
	public int compareTo(Product p) {
		return Integer.parseInt(this.product_id) - Integer.parseInt(p.getProduct_id());
	}

	
	
}
