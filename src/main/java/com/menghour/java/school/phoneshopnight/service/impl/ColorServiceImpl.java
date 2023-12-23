package com.menghour.java.school.phoneshopnight.service.impl;

import org.springframework.stereotype.Service;

import com.menghour.java.school.phoneshopnight.entity.Color;
import com.menghour.java.school.phoneshopnight.exception.ResourceNotFoundException;
import com.menghour.java.school.phoneshopnight.repository.ColorRepository;
import com.menghour.java.school.phoneshopnight.service.ColorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

	private final ColorRepository colorRepository;
	@Override
	public Color create(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getById(Long id) {
		return colorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Color", id));
	}
}
