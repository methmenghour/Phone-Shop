package com.menghour.java.school.phoneshopnight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.menghour.java.school.phoneshopnight.dto.BrandDTO;
import com.menghour.java.school.phoneshopnight.entity.Brand;

@Mapper
public interface BrandMapper {
	//@Mapping(target = "version",source = "vs")
	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	Brand toBrand(BrandDTO dto);
	BrandDTO toBrandDTO(Brand entity);
}
