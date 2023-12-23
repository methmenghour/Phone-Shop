package com.menghour.java.school.phoneshopnight.service;

import java.util.List;

import com.menghour.java.school.phoneshopnight.entity.Model;

public interface ModelService {
	Model save(Model model);
	List<Model> getByBrand(Long brandId);

	Model getById(Long id);

}
