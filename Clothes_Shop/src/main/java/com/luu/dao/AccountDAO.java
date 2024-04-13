package com.luu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.luu.model.Account;
import com.luu.model.JDBCUtil;


public class AccountDAO implements DAOInterface<Account>{

	@Override
	public int insert(Account t) {
		int result=0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into account(acc_name,acc_username,acc_password,acc_access,acc_address,acc_contact,acc_condition)"
					+ " values(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getAcc_name());
			pst.setString(2, t.getAcc_username());
			pst.setString(3, t.getAcc_password());
			pst.setInt(4, t.getAcc_access());
			pst.setNString(5, t.getAcc_address());
			pst.setString(6, t.getAcc_contact());
			pst.setInt(7, t.getAcc_condition());
			result = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public boolean checkInfoAccount(String username, String password) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from account where acc_username=? and acc_password =?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2,password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public int update(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectById(Account t) {
		return null;
	}

	@Override
	public List<Account> selectByCondition(String condi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectById(String username) {
		
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from account where acc_username =?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Account acc= new Account();
				acc.setAcc_id(rs.getInt("acc_id"));
				return acc;
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean checkAccount(String username) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from account where acc_username =?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				return true;
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}	
//	public static void main(String[] args) {
//		AccountDAO acc = new AccountDAO();
//		System.out.println(acc.checkInfoAccount("luyenluuchimai@gmail.com","Cntt@9876"));
//	}

}
