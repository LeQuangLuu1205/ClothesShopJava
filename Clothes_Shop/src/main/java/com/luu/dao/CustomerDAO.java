
package com.luu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.luu.model.Customer;
import com.luu.model.JDBCUtil;


public class CustomerDAO implements DAOInterface<Customer>{

	@Override
	public int insert(Customer t) {
		int result=0;
		//Buoc 1: Tao connection
		try {
			Connection con = JDBCUtil.getConnection();
			//Tao cau lenh
			String sql = "insert into KhachHang(name, email, address,contact,password) values (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getFullname());
			pst.setString(2, t.getEmail());
			pst.setString(3, t.getAddress());
			pst.setString(4, t.getContract());
			pst.setString(5, t.getPassword());
			//Thuc hien cau lenh
			result = pst.executeUpdate();
			//Ngat ket noi
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectById(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> selectByCondition(String condi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
