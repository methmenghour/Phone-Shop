package com.menghour.java.school.phoneshopnight.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.menghour.java.school.phoneshopnight.projection.ProductSold;
import com.menghour.java.school.phoneshopnight.repository.SaleRepository;
import com.menghour.java.school.phoneshopnight.service.ReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{
	
	private final SaleRepository saleRepository;

	@Override
	public List<ProductSold> getProductSold(LocalDate startDate, LocalDate endDate) {
		return saleRepository.findProductSold(startDate, endDate);
	}

}
