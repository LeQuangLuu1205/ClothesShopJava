package com.luu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.luu.model.JDBCUtil;
import com.luu.model.OrderDetail;


public class OrderDetailDAO implements DAOInterface<OrderDetail>{

	@Override
	public int insert(OrderDetail t) {
		int result=0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into order_detail(order_id,product_id,quantity,price)"
					+ " values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, t.getOrder().getOrder_id());
			pst.setString(2, t.getProduct().getProduct_id());
			pst.setInt(3, t.getQuantity());
			pst.setDouble(4, t.getPrice());
		
			result = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(OrderDetail t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(OrderDetail t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderDetail> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail selectById(OrderDetail t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> selectByCondition(String condi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
