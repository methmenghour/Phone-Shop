package com.menghour.java.school.phoneshopnight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.menghour.java.school.phoneshopnight.dto.ProductDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;
import com.menghour.java.school.phoneshopnight.mapper.ProductMapper;
import com.menghour.java.school.phoneshopnight.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {
	private final ProductService productService;
	private final ProductMapper productMapper;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO ) {
		Product product = productMapper.toProduct(productDTO);
		product = productService.create(product);
		
		return ResponseEntity.ok(product);
	}
}
