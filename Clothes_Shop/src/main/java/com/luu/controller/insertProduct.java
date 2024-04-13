package com.luu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luu.dao.ProductDAO;

/**
 * Servlet implementation class insertProduct
 */
@WebServlet(name = "add", urlPatterns = { "/add" })
public class insertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("name");
		String pdescription = request.getParameter("description");
		String pquantity = request.getParameter("quantity");
		String pprice = request.getParameter("price");
		String pcategory = request.getParameter("category");
		String pimage = request.getParameter("image");
		ProductDAO daoProduct = new ProductDAO();
		daoProduct.insert(pname, pdescription, pquantity, pprice, pimage, pcategory);
		response.sendRedirect("inputProduct.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
