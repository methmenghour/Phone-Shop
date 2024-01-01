package com.menghour.java.school.phoneshopnight.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.menghour.java.school.phoneshopnight.entity.Sale;
import com.menghour.java.school.phoneshopnight.projection.ProductSold;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>
{	
	//Query Include Cancel Sale Data
	
	@Query(value ="SELECT p.id AS productId, p.name productName,SUM(sd.unit) unit,SUM(sd.unit * sd.sold_amount) totalAmount \r\n"
			+ "  FROM sale_details sd\r\n"
			+ "  INNER JOIN sales s ON sd.sale_id = s.sale_id\r\n"
			+ "	 INNER JOIN products p on p.id = sd.product_id\r\n"
			+ "	 WHERE  date(s.sold_date) >= :startDate and date(s.sold_date) <= :endDate \r\n"
			+ "	 GROUP BY p.id,p.name\r\n"
			+ "",nativeQuery = true)
	List<ProductSold> findProductSold(LocalDate startDate, LocalDate endDate);
}