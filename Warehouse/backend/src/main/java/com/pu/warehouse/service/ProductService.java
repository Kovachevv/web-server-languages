package com.pu.warehouse.service;

import com.pu.warehouse.model.dto.ProductDTO;
import com.pu.warehouse.model.dto.ProductEditDTO;
import com.pu.warehouse.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Page<Product> getAllProducts(Pageable pageable);
    Page<Product> searchProducts(String searchTerm, String category, Integer code, Pageable pageable);
    Product getProductById(Long id);
    void deleteProduct(Long id);

    void saveProduct(ProductDTO product);

    void updateProduct(Long id, ProductEditDTO productDTO);
}
