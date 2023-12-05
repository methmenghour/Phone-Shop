package com.menghour.java.school.phoneshopnight.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.menghour.java.school.phoneshopnight.entity.Brand;
import com.menghour.java.school.phoneshopnight.exception.ResourceNotFoundException;
import com.menghour.java.school.phoneshopnight.repository.BrandRepository;
import com.menghour.java.school.phoneshopnight.service.BrandService;

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
	public List<Brand> getBrands() {
		return brandRepository.findAll();
	}
	@Override
	public List<Brand> getBrands(String name) {
		//return brandRepository.findByName(name);
		//return brandRepository.findByNameLike("%"+name + "%");
		return brandRepository.findByNameContaining(name);
	}
}
