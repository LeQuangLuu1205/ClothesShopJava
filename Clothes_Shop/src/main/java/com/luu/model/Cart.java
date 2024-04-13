package com.luu.model;

import java.util.TreeMap;

public class Cart {
	private TreeMap<Product, Integer> list;
	private long cart_id;
	
	public Cart() {
		list = new TreeMap<>();
		cart_id = (long)Math.random()*10000+1;
	}
	public Cart(TreeMap<Product, Integer> list,long cart_id) {
		this.list = list;
		this.cart_id = cart_id;
	}
	public TreeMap<Product, Integer> getList() {
		return list;
	}
	public void setList(TreeMap<Product, Integer> list) {
		this.list = list;
	}
	public long getCart_id() {
		return cart_id;
	}
	public void setCart_id(long cart_id) {
		this.cart_id = cart_id;
	}
	
	public void addToCart(Product p, int quantity) {
		boolean isExist = list.containsKey(p);
		if (isExist) {
			int count = list.get(p);
			quantity += count;
			list.put(p, quantity);
		}else {
			list.put(p, quantity);
		}
	}
	public void subToCart(Product p, int quantity) {
		boolean bln = list.containsKey(p);
		if (bln) {
			int count = list.get(p);
			quantity = count - quantity;
			if (quantity<=0) {
				list.remove(p);
			}else {
				list.remove(p);
				list.put(p, quantity);
			}
		}
	}
	public void removeToCart(Product p) {
		boolean bln = list.containsKey(p);
		if (bln) {
			list.remove(p);
		}
	}
//	public static void main(String[] args) {
//		System.out.println();
//	}
}
