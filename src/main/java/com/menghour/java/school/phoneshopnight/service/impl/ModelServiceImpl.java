package com.menghour.java.school.phoneshopnight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menghour.java.school.phoneshopnight.entity.Model;
import com.menghour.java.school.phoneshopnight.exception.ResourceNotFoundException;
import com.menghour.java.school.phoneshopnight.repository.ModelRepository;
import com.menghour.java.school.phoneshopnight.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelRepository modelRepository;
	@Override
	public Model save(Model model) {

		return modelRepository.save(model);
	}

	@Override
	public List<Model> getByBrand(Long brandId) {
		return modelRepository.findByBrandId(brandId);
	}

	@Override
	public Model getById(Long id) {
		return modelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Model", id));
	}

}