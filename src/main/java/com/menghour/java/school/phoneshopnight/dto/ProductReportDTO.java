package com.menghour.java.school.phoneshopnight.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductReportDTO {
	private Long productId;
	private String productName;
	private Integer unit;
	private BigDecimal totalAmount;
}
