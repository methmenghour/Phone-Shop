package com.menghour.java.school.phoneshopnight.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.menghour.java.school.phoneshopnight.entity.Brand;
import com.menghour.java.school.phoneshopnight.exception.ResourceNotFoundException;
import com.menghour.java.school.phoneshopnight.repository.BrandRepository;
import com.menghour.java.school.phoneshopnight.service.impl.BrandServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

	@Mock
	private BrandRepository brandRepository;
    private BrandService brandService;
    
    @BeforeEach
    public void setUp() {
    	brandService=new BrandServiceImpl(brandRepository);
    }
//	@Test
//	public void testCreate() {
//		//Give
//		Brand brand = new Brand();
//		brand.setName("Apple");
//		brand.setId(1);
//		//When
//		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
//		Brand brandReturn = brandService.create(new Brand()); 
//		//Then		
//		assertEquals(1,brandReturn.getId());
//		assertEquals("Apple",brandReturn.getName());
//
//	}
    @Test
	public void testCreate() {
    	//Give
    	Brand brand=new Brand();
    	brand.setName("Samsung");
    	//When
    	brandService.create(brand);
    	//Then
    	verify(brandRepository, times(1)).save(brand);
    	//verify(brandRepository, times(1)).delete(brand);
    }
    @Test
	public void testGetByIdSuccess() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1);
		
		//when
		when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
		Brand brandReturn = brandService.getById(1);
		//then
		
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
		
	}
	
	@Test
	public void testGetByIdThrow() {
		//given
		
		//when
		when(brandRepository.findById(2)).thenReturn(Optional.empty());
		//brandService.getById(2);
		assertThatThrownBy(() -> brandService.getById(2))
			.isInstanceOf(ResourceNotFoundException.class)
			.hasMessage("Brand With id = 2 not found");// succes
			//.hasMessage("Error"); fail//Expecting message to be: "Error" but was: "Brand With id = 2 not found"
			//.hasMessage(String.format("%s With id = %d not found","Brand",2 ));
			//.hasMessageEndingWith("not found");
		//then
	}

	
}
