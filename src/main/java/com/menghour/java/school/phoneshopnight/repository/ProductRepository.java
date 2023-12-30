package com.menghour.java.school.phoneshopnight.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.menghour.java.school.phoneshopnight.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>
{
	Optional<Product> findByModelIdAndColorId(Long modelId, Long colorId);
}