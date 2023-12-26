package com.menghour.java.school.phoneshopnight.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.menghour.java.school.phoneshopnight.dto.ProductImportDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;
import com.menghour.java.school.phoneshopnight.entity.ProductImportHistory;
import com.menghour.java.school.phoneshopnight.exception.ApiException;
import com.menghour.java.school.phoneshopnight.exception.ResourceNotFoundException;
import com.menghour.java.school.phoneshopnight.mapper.ProductMapper;
import com.menghour.java.school.phoneshopnight.repository.ProductImportHistoryRepository;
import com.menghour.java.school.phoneshopnight.repository.ProductRepository;
import com.menghour.java.school.phoneshopnight.service.ProductService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository importHistoryRepository;
	private final ProductMapper productMapper;
	@Override
	public Product create(Product product) {
		String name = "%s %s"
				.formatted(product.getModel().getName(), product.getColor().getName()) ;
		product.setName(name);		
		return productRepository.save(product);
	}
	@Override
	public Product getById(Long id) {
		return productRepository.findById(id)
			  .orElseThrow(() -> new ResourceNotFoundException("Product", id));
	}
	@Override
	public void importProduct(ProductImportDTO importDTO) {
		// check importDTO.getImportUnit() 
		if(importDTO.getImportUnit()==null) {
			 throw new ApiException(HttpStatus.BAD_REQUEST,"Import unit can't be null ");
		}
		// update available product unit
		Product product = getById(importDTO.getProductId());
		
		Integer availableUnit = 0;
		if(product.getAvailableUnit() != null) {
			availableUnit = product.getAvailableUnit();
		}
		
		product.setAvailableUnit(availableUnit + importDTO.getImportUnit());
		productRepository.save(product);
		
		// save product import history
		ProductImportHistory importHistory = productMapper.toProductImportHistory(importDTO, product);
		importHistoryRepository.save(importHistory);
		
	}

}
