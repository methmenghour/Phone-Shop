package com.menghour.java.school.phoneshopnight.service.util;

import com.menghour.java.school.phoneshopnight.dto.BrandDTO;
import com.menghour.java.school.phoneshopnight.entity.Brand;

public class Mapper {
	public static Brand toBrand(BrandDTO dto) {
		Brand brand=new Brand();
		//brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
	}
	public static BrandDTO toBrandDTO(Brand brand) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setName(brand.getName());
		return brandDTO;
	}
}
