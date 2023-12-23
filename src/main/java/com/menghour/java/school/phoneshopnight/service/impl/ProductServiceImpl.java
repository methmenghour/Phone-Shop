package com.menghour.java.school.phoneshopnight.service.impl;

import org.springframework.stereotype.Service;

import com.menghour.java.school.phoneshopnight.entity.Product;
import com.menghour.java.school.phoneshopnight.exception.ResourceNotFoundException;
import com.menghour.java.school.phoneshopnight.repository.ProductRepository;
import com.menghour.java.school.phoneshopnight.service.ProductService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
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

}
