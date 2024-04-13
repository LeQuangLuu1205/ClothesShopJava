package com.luu.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luu.dao.AccountDAO;
import com.luu.dao.OrderDAO;
import com.luu.dao.OrderDetailDAO;
import com.luu.model.Account;
import com.luu.model.Cart;
import com.luu.model.Order;
import com.luu.model.OrderDetail;
import com.luu.model.Product;

/**
 * Servlet implementation class paymentServlet
 */
@WebServlet("/paymentServlet")
public class paymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderDAO orderdao = new OrderDAO();
	private OrderDetailDAO orderdetaildao = new OrderDetailDAO();
	private AccountDAO accdao = new AccountDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String order_address = request.getParameter("order_address");	
		String paymentmethod = request.getParameter("paymentmethod");
		String acc_username = request.getParameter("acc_username");
		System.out.println(acc_username);
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		try {
			Date date = new Date();
			String order_id = ""+date.getTime();
			Account tk  = new Account();
			tk.setAcc_id(accdao.selectById(acc_username).getAcc_id());
			Order order = new Order(order_id,tk, order_address, paymentmethod,new Timestamp(new Date().getTime()), 0);
			order.setOrder_id(order_id);
			System.out.println(order);
			System.out.println(order.getAcc().getAcc_id());
			orderdao.insert(order);
			TreeMap<Product, Integer> list = cart.getList();
			for(Map.Entry<Product, Integer> ds: list.entrySet()) {
				Product sp = new Product();
				sp.setProduct_id(ds.getKey().getProduct_id());
				orderdetaildao.insert(new OrderDetail(0,order,sp,ds.getValue(),ds.getKey().getProduct_price()));
			}
			response.sendRedirect("/Clothes_Shop/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
