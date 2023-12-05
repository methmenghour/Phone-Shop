package com.menghour.java.school.phoneshopnight.service;
import java.util.List;

import com.menghour.java.school.phoneshopnight.entity.Brand;
public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand brandUpdate);
	List<Brand> getBrands();
	List<Brand> getBrands(String name);

}
