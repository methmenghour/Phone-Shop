package com.menghour.java.school.phoneshopnight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menghour.java.school.phoneshopnight.dto.ModelDTO;
import com.menghour.java.school.phoneshopnight.entity.Model;
import com.menghour.java.school.phoneshopnight.mapper.ModelMapper;
import com.menghour.java.school.phoneshopnight.service.BrandService;
import com.menghour.java.school.phoneshopnight.service.ModelService;
import lombok.RequiredArgsConstructor;
/*
@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	
	private final ModelService modelService;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
		Model model = ModelMapper.INSTANCE.toModel(modelDTO);
	    model=modelService.save(model);
		return ResponseEntity.ok(model);
	}
}
*/
@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	
	private final ModelService modelService;
	private final ModelMapper modelMapper;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
		Model model = modelMapper.toModel(modelDTO);
		model = modelService.save(model);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}
}
