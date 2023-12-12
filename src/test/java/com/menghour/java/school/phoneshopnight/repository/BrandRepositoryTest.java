package com.menghour.java.school.phoneshopnight.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.menghour.java.school.phoneshopnight.entity.Brand;

@DataJpaTest
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;
   // @Test
	public void testFindByNameLike() {
    	//given
		Brand brand = new Brand();
		brand.setName("Apple");
		
		Brand brand2 = new Brand();
		brand2.setName("Samsung");
		
		brandRepository.save(brand);
		brandRepository.save(brand2);
		
		//when
		List<Brand> brands = brandRepository.findByNameLike("%A%");
		
		//then
		assertEquals(1, brands.size());
		assertEquals("Apple", brands.get(0).getName());
		assertEquals(3, brands.get(0).getId());
		
	}
   // @Test
	public void testFindByNameContaining() {
    	//given
		Brand brand = new Brand();
		brand.setName("Apple");
		
		Brand brand2 = new Brand();
		brand2.setName("Samsung");
		
		brandRepository.save(brand);
		brandRepository.save(brand2);
		
		//when
		List<Brand> brands = brandRepository.findByNameContaining("Samsung");
		
		//then
		assertEquals(1, brands.size());
		assertEquals("Samsung", brands.get(0).getName());
		assertEquals(2, brands.get(0).getId());
		
	}
}
