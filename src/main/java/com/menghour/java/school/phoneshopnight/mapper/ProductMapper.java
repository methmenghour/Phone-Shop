package com.menghour.java.school.phoneshopnight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.menghour.java.school.phoneshopnight.dto.ProductDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;
import com.menghour.java.school.phoneshopnight.service.ColorService;
import com.menghour.java.school.phoneshopnight.service.ModelService;



@Mapper(componentModel = "spring", 
	uses = {ModelService.class, ColorService.class})
public interface ProductMapper {

	@Mapping(target = "model", source = "modelId")
	@Mapping(target = "color", source = "colorId")
	Product toProduct(ProductDTO productDTO);
	
}
