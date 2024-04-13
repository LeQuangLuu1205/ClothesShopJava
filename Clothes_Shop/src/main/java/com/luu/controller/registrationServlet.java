package com.luu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luu.dao.AccountDAO;
import com.luu.model.Account;

/**
 * Servlet implementation class registrationServlet
 */
@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDAO accDao = new AccountDAO(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String acc_name = request.getParameter("acc_name");
		String acc_username = request.getParameter("acc_username");	
		String acc_password = request.getParameter("acc_password");
		String acc_address = request.getParameter("acc_address");
		String acc_contact = request.getParameter("acc_contact");
		String acc_name_err = "",acc_username_err="", acc_password_err="",acc_address_err="",acc_contact_err="";
		if (acc_name.equals("")) {
			acc_name_err = "Vui lòng nhập lại họ tên";
		}
		
		if (acc_name_err.length()>0) {
			request.setAttribute("acc_name_err", acc_name_err);
		}
		if (acc_username.equals("")) {
			acc_username_err = "Vui lòng nhập email đăng kí";
		}
		else {
			if (accDao.checkAccount(acc_username)==true) {
				acc_username_err = "Địa chỉ email đã được đăng kí";
			}
		}
		if (acc_username_err.length()>0) {
			request.setAttribute("acc_username_err", acc_username_err);
		}
		if (acc_password.equals("")) {
			acc_password_err = "Vui lòng nhập password đăng kí";
		}
		if (acc_password_err.length()>0) {
			request.setAttribute("acc_password_err", acc_password_err);
		}
		if (acc_address.equals("")) {
			acc_address_err = "Vui lòng nhập lại địa chỉ";
		}
		
		if (acc_address_err.length()>0) {
			request.setAttribute("acc_address_err", acc_address_err);
		}
		if (acc_contact.equals("")) {
			acc_contact_err = "Vui lòng nhập lại số điện thoại";
		}
		
		if (acc_contact_err.length()>0) {
			request.setAttribute("acc_contact_err", acc_contact_err);
		}
		request.setAttribute("acc_username", acc_username);
		request.setAttribute("acc_password", acc_password);
		request.setAttribute("acc_name", acc_name);
		String url = "";
		try {
			if (acc_password_err.length()==0 && acc_username_err.length()==0 && acc_name_err.length()==0&&acc_address_err.length()==0&&acc_contact_err.length()==0) {
				Account uacc= new Account(0, acc_name, acc_username, acc_password, 2, acc_address, acc_contact, 1);
				accDao.insert(uacc);
				url= "/index.jsp";
			}else {
				url="/login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
