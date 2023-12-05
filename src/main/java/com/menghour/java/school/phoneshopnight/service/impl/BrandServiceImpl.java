package com.menghour.java.school.phoneshopnight.service.impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.menghour.java.school.phoneshopnight.entity.Brand;
import com.menghour.java.school.phoneshopnight.exception.ApiException;
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
//		Optional<Brand> brandOptional = brandRepository.findById(id);
//		if(brandOptional.isPresent()) {
//			return brandOptional.get();
//		}else {
//		 //throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id="+id+" not found");
//		 throw new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("Brand with id= %d not found",id));
//
//		}
		return brandRepository.findById(id)
				// create global Exception with GlobalExceptionHandler class
				//.orElseThrow(()-> new ApiException(HttpStatus.NOT_FOUND,String.format("Brand with id= %d not found",id)));
				// customize error message by Create ResourceNotFoundException
				.orElseThrow(()->new ResourceNotFoundException("Brand", id));
	}
	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName());
		return brandRepository.save(brand);
	}
}
