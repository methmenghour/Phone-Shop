package com.menghour.java.school.phoneshopnight.service;

import com.menghour.java.school.phoneshopnight.entity.Color;

public interface ColorService {
	Color create(Color color);
	Color getById(Long id);
}
