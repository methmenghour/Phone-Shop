package com.menghour.java.school.phoneshopnight.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.menghour.java.school.phoneshopnight.dto.ProductSoldDTO;
import com.menghour.java.school.phoneshopnight.dto.SaleDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;
import com.menghour.java.school.phoneshopnight.entity.Sale;
import com.menghour.java.school.phoneshopnight.entity.SaleDetail;
import com.menghour.java.school.phoneshopnight.exception.ApiException;
import com.menghour.java.school.phoneshopnight.exception.ResourceNotFoundException;
import com.menghour.java.school.phoneshopnight.repository.ProductRepository;
import com.menghour.java.school.phoneshopnight.repository.SaleDetailRepository;
import com.menghour.java.school.phoneshopnight.repository.SaleRepository;
import com.menghour.java.school.phoneshopnight.service.ProductService;
import com.menghour.java.school.phoneshopnight.service.SaleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

	private final ProductService productService;
	private final ProductRepository productRepository;
	private final SaleRepository saleRepository;
	private final SaleDetailRepository saleDetailRepository;


	@Override
	public void sell(SaleDTO saleDTO) {
		List<Long> productIds = saleDTO.getProducts().stream()
				.map(ProductSoldDTO::getProductId)
				.toList();
			// validate product
		productIds.forEach(productService::getById);
		
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
			.collect(Collectors.toMap(Product::getId, Function.identity()));

		// validate stock
		saleDTO.getProducts()
		.forEach(ps ->{
			Product product = productMap.get(ps.getProductId());
			if(product.getAvailableUnit() < ps.getNumberOfUnit()) {
				throw new ApiException(HttpStatus.BAD_REQUEST, "Product [%s] is not enough in stock".formatted(product.getName()));
			}
		});
		
		// Sale
				Sale sale = new Sale();
				sale.setSoldDate(saleDTO.getSaleDate());
				saleRepository.save(sale);
				
	    // Sale Detail
				saleDTO.getProducts().forEach(ps ->{
					
					Product product = productMap.get(ps.getProductId());
					SaleDetail saleDetail = new SaleDetail();
					saleDetail.setAmount(product.getSalePrice());
					saleDetail.setProduct(product);
					saleDetail.setSale(sale);
					saleDetail.setUnit(ps.getNumberOfUnit());
					
					saleDetailRepository.save(saleDetail);	
				    
					// Cutting Stock 
					Integer availableUnit =  product.getAvailableUnit() - ps.getNumberOfUnit();
					product.setAvailableUnit(availableUnit);
					productRepository.save(product);				
				});
	}

	private void saveSale(SaleDTO saleDTO) {
		// sale
		Sale sale = new Sale();
		sale.setSoldDate(saleDTO.getSaleDate());
		saleRepository.save(sale);
		
		//Sale Detail
		
		saleDTO.getProducts().forEach(ps ->{
			SaleDetail saleDetail = new SaleDetail();
			saleDetail.setAmount(null);
		});
	}
	private void validate(SaleDTO saleDTO) {
		saleDTO.getProducts().forEach(ps ->{
			Product product = productService.getById(ps.getProductId());
			if(product.getAvailableUnit() < ps.getNumberOfUnit()) {
				throw new ApiException(HttpStatus.BAD_REQUEST, "Product [%s] is not enough in stock".formatted(product.getName()));
			}
		});
	}
	private void validate2(SaleDTO saleDTO) {

		  List<Long> productIds = saleDTO.getProducts().stream()
		 .map(ProductSoldDTO::getProductId)
		 .toList();
		  
		// validate product 
		productIds.forEach(productService::getById);
		
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));
		 

//		saleDTO.getProducts().stream()
//				.map(ProductSoldDTO::getProductId)
//				.forEach(productService::getById);

//				.forEach(productId->productService.getById(productId));

//				.forEach(productId->{
//					productService.getById(productId);			
//				});

		// validate stock
		
		saleDTO.getProducts()
		       .forEach(ps->{
		    	   Product product=productMap.get(ps.getProductId());
		    	   if(product.getAvailableUnit() < ps.getNumberOfUnit()) {
						throw new ApiException(HttpStatus.BAD_REQUEST, "Product [%s] is not enough in stock".formatted(product.getName()));

		    	   }
		       });

	}

	@Override
	public void cancelSale(Long saleId) {
		// update sale status
		Sale sale = getById(saleId);
		sale.setActive(false);
		saleRepository.save(sale);
		
		// update stock
		List<SaleDetail> saleDetails = saleDetailRepository.findBySaleId(saleId);
       
		List<Long> productIds = saleDetails.stream()
				.map(sd -> sd.getProduct().getId())
				.toList();
		
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
			.collect(Collectors.toMap(Product::getId, Function.identity()));
		
		saleDetails.forEach(sd ->{
			 Product product = productMap.get(sd.getProduct().getId());
			 product.setAvailableUnit(product.getAvailableUnit() + sd.getUnit());
			 productRepository.save(product);
		});
		
		
	}

	@Override
	public Sale getById(Long saleId) {
		return saleRepository.findById(saleId)
				.orElseThrow(()-> new ResourceNotFoundException("Sale", saleId));
	}

}
