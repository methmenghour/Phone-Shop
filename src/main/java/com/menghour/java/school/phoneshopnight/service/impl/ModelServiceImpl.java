package com.menghour.java.school.phoneshopnight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menghour.java.school.phoneshopnight.entity.Model;
import com.menghour.java.school.phoneshopnight.repository.ModelRepository;
import com.menghour.java.school.phoneshopnight.service.BrandService;
import com.menghour.java.school.phoneshopnight.service.ModelService;
/*
 
@Service
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private BrandService brandService;
	@Override
	public Model save(Model model) {
		Integer brandId = model.getBrand().getId();
		brandService.getById(brandId);
		return modelRepository.save(model);
	}

}
*/
@Service
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelRepository modelRepository;
	@Override
	public Model save(Model model) {

		return modelRepository.save(model);
	}

}