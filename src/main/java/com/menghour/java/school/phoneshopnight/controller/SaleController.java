package com.menghour.java.school.phoneshopnight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menghour.java.school.phoneshopnight.dto.SaleDTO;
import com.menghour.java.school.phoneshopnight.service.SaleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("sales")
public class SaleController {
	
	private final SaleService saleService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody SaleDTO saleDTO) {
		saleService.sell(saleDTO);
		return ResponseEntity.ok().build();
	}

}
