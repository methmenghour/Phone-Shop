package com.menghour.java.school.phoneshopnight.service;

import com.menghour.java.school.phoneshopnight.dto.ProductImportDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;

public interface ProductService {
	Product create(Product product);
	Product getById(Long id);
	
	void importProduct(ProductImportDTO importDTO);


}
