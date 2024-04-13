package com.luu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationControl
 */
@WebServlet("/register")
public class RegistrationControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ufullname = request.getParameter("fullname_signup");
		String uemail = request.getParameter("email_signup");
		String uaddress = request.getParameter("address_signup");
		String umobile = request.getParameter("contact_signup");
		String upwd = request.getParameter("password_signup");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=db_qlbanhangg;encrypt=false;IntegratedSecurity=true");
			PreparedStatement pst = con.prepareStatement("insert into KhachHang(name, email, address,contact,password) values (?,?,?,?,?)");
			pst.setString(1, ufullname);
			pst.setString(2, uemail);
			pst.setString(3, uaddress);
			pst.setString(4, umobile);
			pst.setString(5, upwd);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration_login.jsp");
			if (rowCount >0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failded");
			}
			
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
