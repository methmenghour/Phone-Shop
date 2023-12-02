package com.menghour.java.school.phoneshopnight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menghour.java.school.phoneshopnight.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
