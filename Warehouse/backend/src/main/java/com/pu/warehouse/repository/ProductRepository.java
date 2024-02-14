package com.pu.warehouse.repository;

import com.pu.warehouse.model.entity.Product;
import com.pu.warehouse.model.enumaration.CategoryType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCode(int code, Pageable pageable);

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(concat('%', :searchTerm, '%')) AND p.category.name = :categoryType")
    Page<Product> findByNameContainingIgnoreCaseAndCategoryType(@Param("searchTerm") String searchTerm, @Param("categoryType") CategoryType categoryType, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.category.name = :categoryType")
    Page<Product> findByCategoryType(CategoryType categoryType, Pageable pageable);

    boolean existsByCode(Integer code);
}
