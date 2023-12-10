package com.menghour.java.school.phoneshopnight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.menghour.java.school.phoneshopnight.dto.ModelDTO;
import com.menghour.java.school.phoneshopnight.entity.Brand;
import com.menghour.java.school.phoneshopnight.entity.Model;
import com.menghour.java.school.phoneshopnight.service.BrandService;

/*
@Mapper
public interface ModelMapper {
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	@Mapping(target = "brand",source = "brandId")
	Model toModel(ModelDTO dto);
	
	default Brand toBrand(Integer brId) {
		Brand brand=new Brand();
		brand.setId(brId);
		return brand;
	}
}
*/
@Mapper(componentModel = "spring",uses = {BrandService.class})
public interface ModelMapper {
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	@Mapping(target = "brand",source = "brandId")
	Model toModel(ModelDTO dto);

	@Mapping(target = "brandId", source = "brand.id")
	ModelDTO toModelDTO(Model model);
	
	
}
