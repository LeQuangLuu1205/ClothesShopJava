package com.luu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.luu.model.Category;
import com.luu.model.JDBCUtil;
import com.luu.model.Category;

public class CategoryDAO implements DAOInterface<Category>{

	@Override
	public int insert(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Category> selectAll() {
		List<Category> list = new ArrayList<Category>();
		try {
//			step 1: connect database
			Connection con = JDBCUtil.getConnection();
//			step 2: init statement
			String sql = "select * from category";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs=  pst.executeQuery();
			while (rs.next()) {
				int category_id = rs.getInt("category_id");
				String category_name = rs.getString("category_name");
				
				Category category = new Category(category_id, category_name);
				list.add(category);
			}
			
		} catch (Exception e) {
			System.out.println("that bai");
		}
		return list;
	}

	@Override
	public Category selectById(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> selectByCondition(String condi) {
		List<Category> list = new ArrayList<Category>();
		try {
//			step 1: connect database
			Connection con = JDBCUtil.getConnection();
//			step 2: init statement
			String sql = "select * from category where category = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, 0);
			ResultSet rs=  pst.executeQuery();
			while (rs.next()) {
				int category_id = rs.getInt("category_id");
				String category_name = rs.getString("category_name");
				
				Category category = new Category(category_id, category_name);
				list.add(category);
			}
			
		} catch (Exception e) {
			System.out.println("that bai");
		}
		return list;
	}

	@Override
	public Category selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		CategoryDAO catdao = new CategoryDAO();
		List<Category> list = catdao.selectAll();
		for (Category item : list){
			System.out.println(item.getCategory_name());
		}
	}
}
