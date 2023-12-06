package com.menghour.java.school.phoneshopnight.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.menghour.java.school.phoneshopnight.entity.Brand;
import com.menghour.java.school.phoneshopnight.exception.ResourceNotFoundException;
import com.menghour.java.school.phoneshopnight.repository.BrandRepository;
import com.menghour.java.school.phoneshopnight.service.BrandService;
import com.menghour.java.school.phoneshopnight.spec.BrandFilter;
import com.menghour.java.school.phoneshopnight.spec.BrandSpec;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}
	@Override
	public Brand getById(Integer id) {
		return brandRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Brand", id));
	}
	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName());
		return brandRepository.save(brand);
	}
	@Override
	public List<Brand> getBrands(String name) {
		return brandRepository.findByNameContaining(name);
	}
	@Override
	public List<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if(params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}

		BrandSpec brandSpec = new BrandSpec(brandFilter);

		return brandRepository.findAll(brandSpec);
	}
}
