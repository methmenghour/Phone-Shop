package com.menghour.java.school.phoneshopnight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menghour.java.school.phoneshopnight.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
	//List<Brand> findByName(String name);
	//List<Brand> findByNameIgnoreCase(String name);
	//List<Brand> findByNameLike(String name);
	List<Brand> findByNameContaining(String name);



}
