package com.menghour.java.school.phoneshopnight.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.menghour.java.school.phoneshopnight.dto.report.ExpenseReportDTO;
import com.menghour.java.school.phoneshopnight.entity.Product;
import com.menghour.java.school.phoneshopnight.entity.ProductImportHistory;
import com.menghour.java.school.phoneshopnight.repository.ProductImportHistoryRepository;
import com.menghour.java.school.phoneshopnight.repository.ProductRepository;
import com.menghour.java.school.phoneshopnight.repository.SaleDetailRepository;
import com.menghour.java.school.phoneshopnight.repository.SaleRepository;
import com.menghour.java.school.phoneshopnight.service.impl.ReportServiceImpl;
import com.menghour.java.school.phoneshopnight.spec.ProductImportHistorySpec;
import com.menghour.java.school.phoneshopnight.util.ReportTestHelper;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {
	
	@Mock
	private SaleRepository saleRepository;
	@Mock
	private SaleDetailRepository saleDetailRepository;
	@Mock
	private ProductRepository productRepository;
	@Mock
	private ProductImportHistoryRepository productImportHistoryRepository;

	private ReportService reportService;

	@BeforeEach
	public void setup() {
		reportService = new ReportServiceImpl(saleRepository, saleDetailRepository, productRepository,
				productImportHistoryRepository);
	}

	@Test
	public void testGetExpenseReport() {
		// give
		List<ProductImportHistory> importHistories = ReportTestHelper.getProductImportHistories();
		List<Product> products = ReportTestHelper.getProducts();
		// when
		when(productImportHistoryRepository.findAll(Mockito.any(ProductImportHistorySpec.class)))
		.thenReturn(importHistories);
		when(productRepository.findAllById(anySet())).thenReturn(products);
		//then
		List<ExpenseReportDTO> expenseReports =reportService.getExpenseReport(LocalDate.of(2023, 1, 1),LocalDate.of(2023,2, 5));
		
		//List<ExpenseReportDTO> expenseReports = reportService.getExpenseReport(LocalDate.now().minusMonths(1), LocalDate.now());
		
		assertEquals(2, expenseReports.size());
		ExpenseReportDTO expense1 = expenseReports.get(0);
		assertEquals(1, expense1.getProductId());
		assertEquals("iphone 14 pro", expense1.getProductName());
		assertEquals(15, expense1.getTotalUnit());
		assertEquals(18250d, expense1.getTotalAmount().doubleValue());
		
		ExpenseReportDTO expense2 = expenseReports.get(1);
		assertEquals("iphone 13 pro max", expense2.getProductName());

	}
}
