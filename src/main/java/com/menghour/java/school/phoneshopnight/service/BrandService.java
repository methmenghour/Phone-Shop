package com.menghour.java.school.phoneshopnight.service;
import com.menghour.java.school.phoneshopnight.entity.Brand;
public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand brandUpdate);

}
