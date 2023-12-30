package com.menghour.java.school.phoneshopnight.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.menghour.java.school.phoneshopnight.dto.ProductImportDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;

public interface ProductService {
	Product create(Product product);
	Product getById(Long id);
	
	Product getByModelIdAndColorId(Long modelId, Long colorId);

	void importProduct(ProductImportDTO importDTO);
	
	void setSalePrice(Long productId, BigDecimal price);
	
	//void uploadProduct(MultipartFile file);
	Map<Integer, String> uploadProduct(MultipartFile file);

}
