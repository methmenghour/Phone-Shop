package com.menghour.java.school.phoneshopnight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.menghour.java.school.phoneshopnight.entity.Model;

public interface ModelRepository extends JpaRepository<Model,Integer> {
    List<Model> findByBrandId(Integer brandId);	
	List<Model> findByBrandIdAndName(Integer brandId, String name);

}
