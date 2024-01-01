package com.menghour.java.school.phoneshopnight.service;

import com.menghour.java.school.phoneshopnight.dto.SaleDTO;
import com.menghour.java.school.phoneshopnight.entity.Sale;

public interface SaleService {
	
	void sell(SaleDTO saleDTO);
	Sale getById(Long saleId);
	void cancelSale(Long saleId);

}
