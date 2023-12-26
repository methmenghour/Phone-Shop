package com.menghour.java.school.phoneshopnight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.menghour.java.school.phoneshopnight.dto.ProductDTO;
import com.menghour.java.school.phoneshopnight.dto.ProductImportDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;
import com.menghour.java.school.phoneshopnight.entity.ProductImportHistory;
import com.menghour.java.school.phoneshopnight.service.ColorService;
import com.menghour.java.school.phoneshopnight.service.ModelService;



@Mapper(componentModel = "spring", 
	uses = {ModelService.class, ColorService.class})
public interface ProductMapper {

	@Mapping(target = "model", source = "modelId")
	@Mapping(target = "color", source = "colorId")
	Product toProduct(ProductDTO productDTO);
	
	/*
	 @Mapping(target = "dateImport", source = "importDate")
	 @Mapping(target = "pricePerUnit", source = "importPrice")
	 ProductImportHistory toProductImportHistory(ProductImportDTO importDTO);
	 */
	@Mapping(target = "dateImport", source = "importDTO.importDate")
	@Mapping(target = "pricePerUnit", source = "importDTO.importPrice")
	@Mapping(target = "product", source = "product")
	@Mapping(target = "id", ignore = true)
	ProductImportHistory toProductImportHistory(ProductImportDTO importDTO, Product product);
	
}
