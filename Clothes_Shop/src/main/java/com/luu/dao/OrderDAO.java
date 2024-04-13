package com.luu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.List;


import com.luu.model.JDBCUtil;
import com.luu.model.Order;


public class OrderDAO implements DAOInterface<Order>{

	@Override
	public int insert(Order t) {
		int result=0;
		try {
//			private String order_id;
//			private Account acc;
//			private String order_address;
//			private String payemntmethod;
//			private Timestamp dateOfPurchase;
//			private int order_condition;
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into orders(order_id,acc_id,order_address,paymentmethod,dateofpurchase,order_condition)"
					+ " values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getOrder_id());
			pst.setInt(2, t.getAcc().getAcc_id());
			pst.setString(3, t.getOrder_address());
			pst.setString(4, t.getPayemntmethod());
			pst.setTimestamp(5, t.getDateOfPurchase());
			pst.setInt(6, t.getOrder_condition());
			result = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(Order t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Order t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectById(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> selectByCondition(String condi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
