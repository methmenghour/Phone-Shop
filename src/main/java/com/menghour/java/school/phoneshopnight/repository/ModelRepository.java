package com.menghour.java.school.phoneshopnight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.menghour.java.school.phoneshopnight.entity.Model;

public interface ModelRepository extends JpaRepository<Model,Long> {
    List<Model> findByBrandId(Long brandId);	
	List<Model> findByBrandIdAndName(Long brandId, String name);

}
