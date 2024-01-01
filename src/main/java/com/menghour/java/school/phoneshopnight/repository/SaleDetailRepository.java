package com.menghour.java.school.phoneshopnight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menghour.java.school.phoneshopnight.entity.SaleDetail;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long>
{
	List<SaleDetail> findBySaleId(Long saleId);

}