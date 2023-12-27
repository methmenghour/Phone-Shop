package com.menghour.java.school.phoneshopnight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menghour.java.school.phoneshopnight.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>
{
	
}