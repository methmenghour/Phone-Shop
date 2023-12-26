package com.menghour.java.school.phoneshopnight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menghour.java.school.phoneshopnight.entity.ProductImportHistory;

//@Repository
/*
I would suggest as a good practice to annotate with @Repository class you are implementing.
 
It is indeed not necessary to put the @Repository annotation 
on interfaces that extend JpaRepository; Spring recognizes the repositories 
by the fact that they extend one of the predefined Repository interfaces
 */
public interface ProductImportHistoryRepository extends JpaRepository<ProductImportHistory, Long>{

}
