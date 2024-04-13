package com.luu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luu.dao.AccountDAO;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDAO accDao = new AccountDAO(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("command").equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/Clothes_Shop/index.jsp");
		}
		
		if (request.getParameter("command").equals("login")) {
			Cookie arr[] = request.getCookies();
			for (Cookie o: arr) {
				if (o.getName().equals("userC")) {
					request.setAttribute("userC", o.getValue());
				}
				if (o.getName().equals("passC")) {
					request.setAttribute("passC", o.getValue());
				}
			}
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String acc_username = request.getParameter("acc_username");	
		String acc_password = request.getParameter("acc_password");
		Cookie u = new Cookie("userC",acc_username);
		Cookie p = new Cookie("passC",acc_password);
		u.setMaxAge(60*60*24*365);
		p.setMaxAge(60);
		
		String err="";
		if (acc_username.equals("")||acc_password.equals("")) {
			err = "Vui lòng nhập đầy đủ thông tin";
		}
		else if(accDao.checkInfoAccount(acc_username, acc_password) == false) {
			err = "Mật khẩu hoặc email không hợp lệ";
		}
		
		if (err.length()>0) {
			request.setAttribute("err", err);
		}
		String url="/login.jsp";
		try {
			if (err.length()==0) {
				HttpSession session = request.getSession();
				session.setAttribute("acc_username", acc_username);
				url = "/index.jsp";
				response.addCookie(u);
				response.addCookie(p);
				
			}
			else {
				url = "/login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
