package com.luu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luu.dao.ProductDAO;
import com.luu.model.Cart;
import com.luu.model.Product;

/**
 * Servlet implementation class cartServlet
 */
@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductDAO productDAO = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		String product_id = request.getParameter("product_id");
		String command = request.getParameter("command");
		ArrayList<Long> listBuy = null;
		
		try {
			
			long idBuy = 0;
			listBuy =  (ArrayList<Long>) session.getAttribute("cart_id");
			if (request.getParameter("cart_id") != null) {
				idBuy = Long.parseLong(request.getParameter("cart_id"));
			}
			String url = " ";
				Product product = productDAO.selectById(product_id);
				switch (command) {
				case "insert": 
					if (listBuy == null)
					{
						listBuy = new ArrayList<>();
						session.setAttribute("cart_id", listBuy);
					}
					if(listBuy.indexOf(idBuy)==-1) {
						cart.addToCart(product, 1);
						listBuy.add(idBuy);
					}
					url = "/cart.html";
					break;
				case "sub":
					if (listBuy == null)
					{
						listBuy = new ArrayList<>();
						session.setAttribute("cart", listBuy);
					}
					if (listBuy.indexOf(idBuy) == -1) {
						cart.subToCart(product, 1);
						listBuy.add(idBuy);
					}
					url="/cart.jsp";
					break;
				case "plus":
					if (listBuy == null)
					{
						listBuy = new ArrayList<>();
						session.setAttribute("cart", listBuy);
					}
					if (listBuy.indexOf(idBuy) == -1) {
						cart.addToCart(product, 1);
						listBuy.add(idBuy);
					}
					url="/cart.jsp";
					break;
				case "remove":
					cart.removeToCart(product);
					url="/cart.jsp";
					break;
				default:
					break;
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/cart.jsp");
				rd.forward(request, response);
		} catch (Exception e) {
		}
	}

}
