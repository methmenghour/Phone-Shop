package com.menghour.java.school.phoneshopnight.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.menghour.java.school.phoneshopnight.dto.PriceDTO;
import com.menghour.java.school.phoneshopnight.dto.ProductDTO;
import com.menghour.java.school.phoneshopnight.dto.ProductImportDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;
import com.menghour.java.school.phoneshopnight.mapper.ProductMapper;
import com.menghour.java.school.phoneshopnight.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {
	private final ProductService productService;
	private final ProductMapper productMapper;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO ) {
		Product product = productMapper.toProduct(productDTO);
		product = productService.create(product);
		
		return ResponseEntity.ok(product);
	}
	
	@PostMapping("importProduct")
	public ResponseEntity<?> importProduct(@RequestBody @Valid ProductImportDTO importDTO){
		productService.importProduct(importDTO);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("{productId}/setSalePrice")
	public ResponseEntity<?> setSalePrice(@PathVariable("productId") Long productId,@RequestBody PriceDTO priceDTO){
		productService.setSalePrice(productId, priceDTO.getPrice());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("uploadProduct")
	public ResponseEntity<?> uploadProduct(@RequestParam("file") MultipartFile file){
		Map<Integer, String> errorMap = productService.uploadProduct(file);
		return ResponseEntity.ok(errorMap);
	}
	
	
}
