package com.menghour.java.school.phoneshopnight.service;

import java.time.LocalDate;
import java.util.List;

import com.menghour.java.school.phoneshopnight.dto.ProductReportDTO;
import com.menghour.java.school.phoneshopnight.dto.report.ExpenseReportDTO;
import com.menghour.java.school.phoneshopnight.projection.ProductSold;

public interface ReportService {
	List<ProductSold> getProductSold(LocalDate startDate, LocalDate endDate);
	List<ProductReportDTO> getProductReport(LocalDate startDate, LocalDate endDate);
	List<ExpenseReportDTO> getExpenseReport(LocalDate startDate, LocalDate endDate);
	}
