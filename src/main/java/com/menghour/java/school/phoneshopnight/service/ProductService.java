package com.menghour.java.school.phoneshopnight.service;

import java.math.BigDecimal;

import com.menghour.java.school.phoneshopnight.dto.ProductImportDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;

public interface ProductService {
	Product create(Product product);
	Product getById(Long id);
	
	void importProduct(ProductImportDTO importDTO);
	
	void setSalePrice(Long productId, BigDecimal price);


}
