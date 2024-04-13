package com.luu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.luu.model.JDBCUtil;
import com.luu.model.Product;


public class ProductDAO implements DAOInterface<Product>{

	@Override
	public int insert(Product t) {
//		int result=0;
//		//Buoc 1: Tao connection
//		try {
//			Connection con = JDBCUtil.getConnection();
//			//Tao cau lenh
//			String sql = "insert into Product(code,, address,contact,password) values (?,?,?,?,?)";
//			PreparedStatement pst = con.prepareStatement(sql);
//			pst.setString(1, t.getFullname());
//			pst.setString(2, t.getEmail());
//			pst.setString(3, t.getAddress());
//			pst.setString(4, t.getContract());
//			pst.setString(5, t.getPassword());
//			//Thuc hien cau lenh
//			result = pst.executeUpdate();
//			//Ngat ket noi
//			JDBCUtil.closeConnection(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return result;
		return 0;
	}

	@Override
	public int update(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		try {
//			step 1: connect database
			Connection con = JDBCUtil.getConnection();
//			step 2: init statement
			String sql = "select * from Product";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs=  pst.executeQuery();
			while (rs.next()) {
				String product_id = rs.getString("product_id");
				String product_name = rs.getString("product_name");
				double product_price = Double.parseDouble(rs.getString("product_price"));
				int product_quantity = Integer.parseInt(rs.getString("product_quantity"));
				String product_img = rs.getString("product_img");
				String product_description = rs.getString("product_description");
				String category_id = rs.getString("category_id");
				Product product = new Product(product_id, product_name, product_price, product_quantity, product_img, product_description, category_id);
				list.add(product);
			}
			
		} catch (Exception e) {
			System.out.println("that bai");
		}
		return list;
	}

	@Override
	public Product selectById(Product t) {
			
		return null;
	}
	@Override
	public Product selectById(String id) {
		Product product = new Product();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from Product where product_id =?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs= pst.executeQuery();
			while (rs.next()) {
				product.setProduct_id(rs.getString("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_price(rs.getDouble("product_price"));
				product.setProduct_quantity(rs.getInt("product_quantity"));
				product.setProduct_img(rs.getString("product_img"));
				product.setProduct_description(rs.getString("product_description"));
				product.setCategory_id(rs.getString("category_id"));
				
			}
			
		} catch (Exception e) {
			System.out.println("that bai");
		}
		return product;
	}

	@Override
	public List<Product> selectByCondition(String condi) {
		List<Product> list = new ArrayList<Product>();
		try {
//			step 1: connect database
			Connection con = JDBCUtil.getConnection();
//			step 2: init statement
			String sql = "select * from Product where category_id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			int cat_id = Integer.parseInt(condi);
			pst.setInt(1, cat_id);
			ResultSet rs=  pst.executeQuery();
			while (rs.next()) {
				String product_id = rs.getString("product_id");
				String product_name = rs.getString("product_name");
				double product_price = Double.parseDouble(rs.getString("product_price"));
				int product_quantity = Integer.parseInt(rs.getString("product_quantity"));
				String product_img = rs.getString("product_img");
				String product_description = rs.getString("product_description");
				String category_id = rs.getString("category_id");
				Product product = new Product(product_id, product_name, product_price, product_quantity, product_img, product_description, category_id);
				list.add(product);
			}
			
		} catch (Exception e) {
			System.out.println("that bai");
		}
		return list;
	}
	public void insert(String name, String description, String quantity, String price, String image, String category) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into Product(product_name, product_description, product_quantity, product_price, product_img, category_id)" 
					+ " values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, description);
			pst.setString(3, quantity);
			pst.setString(4, price);
			pst.setString(5, image);
			pst.setString(6, category);
			pst.executeUpdate();
			System.out.println("conected");
		} catch (Exception e) {
			System.out.println("that bai");
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		ProductDAO dao = new ProductDAO();
//		List<Product> list = dao.selectByCondition("2");
//		for (Product item : list) {
//			System.out.println(item.getProduct_name());
//		}
//	}

}
