package com.company.home.test.product;

import com.company.home.test.product.option.ProductOptionDAO;
import com.company.home.test.product.option.ProductOptionDTO;

public class ProductService {
	public static void main(String[] args) {
		ProductDTO productDTO = new ProductDTO();
		ProductDAO productDAO = new ProductDAO();
		
		ProductOptionDTO productoptionDTO = new ProductOptionDTO();
		ProductOptionDAO productoptionDAO = new ProductOptionDAO();
		
		productDTO.setPro_num(null);
		productDTO.setPro_introduce(null);
		productDTO.setRating(null);
		productDTO.setTag(null);
		productDTO.setPro_name(null);
		
		try {
			productDAO.addProduct(productDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productoptionDTO.setOption_num(null);
		productoptionDTO.setPro_num(null);
		productoptionDTO.setOption_name(null);
		productoptionDTO.setOption_price(null);
		productoptionDTO.setOption_stock(null);
		
		
		
	}
}
