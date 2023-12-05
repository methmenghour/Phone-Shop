package com.menghour.java.school.phoneshopnight.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {
	public ResourceNotFoundException(String resourceName, Integer id) {
		super(HttpStatus.NOT_FOUND, String.format("%s With id = %d not found",resourceName,id ));
	}

}
