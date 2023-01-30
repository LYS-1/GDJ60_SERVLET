package com.company.home.product.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.home.util.DBconnection;

public class BookProductDAO {
	
	public List<BookProductDTO> getBookProduct() throws Exception{
		ArrayList<BookProductDTO> arDTO = new ArrayList<BookProductDTO>();
		
		Connection con = DBconnection.getConnection();
		
		String sql = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_IS_SALE"
				+ " FROM BOOK_PRODUCT ORDER BY PRODUCT_ID ASC";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			BookProductDTO bookDTO = new BookProductDTO();
			bookDTO.setProduct_id(rs.getInt("PRODUCT_ID"));
			bookDTO.setProduct_name(rs.getString("PRODUCT_NAME"));
			bookDTO.setProduct_is_sale(rs.getInt("PRODUCT_IS_SALE"));
			
			arDTO.add(bookDTO);
		}
		
		DBconnection.disconnection(con, ps, rs);
		
		return arDTO;
	}
	
	public int addBookProduct(BookProductDTO bookproductDTO) throws Exception{
		
		Connection con = DBconnection.getConnection();
		
		String sql = "INSERT INTO BOOK_PRODUCT VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, bookproductDTO.getProduct_id());
		ps.setString(2, bookproductDTO.getProduct_name());
		ps.setDouble(3, bookproductDTO.getProduct_interest());
		ps.setInt(4, bookproductDTO.getProduct_is_sale());
		ps.setString(5, bookproductDTO.getProduct_detail());
		ps.setString(6, bookproductDTO.getProduct_condition());
		ps.setInt(7, bookproductDTO.getProduct_transfer_limit());
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	public static void main(String[] args) {
		BookProductDAO bDAO = new BookProductDAO();
		BookProductDTO bDTO = new BookProductDTO();
//		bDTO.setProduct_id(111);
//		bDTO.setProduct_name("JAVA_TEST_PRODUCT_NAME");
//		bDTO.setProduct_interest(0.1);
//		bDTO.setProduct_is_sale(1);
//		bDTO.setProduct_detail("JAVA_TEST_PRODUCT_DETAIL");
//		bDTO.setProduct_condition("JAVA_TEST_PRODUCT_CONDITION1");
//		bDTO.setProduct_transfer_limit(1000000);
//		
//		int result;
//		try {
//			result = bDAO.addBookProduct(bDTO);
//			System.out.println(result == 1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			List<BookProductDTO> ar = bDAO.getBookProduct();
			
			System.out.println(ar.size() > 0);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
