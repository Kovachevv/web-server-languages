package com.pu.warehouse.service;

import com.pu.warehouse.model.dto.ProductCreateDTO;
import com.pu.warehouse.model.dto.ProductDTO;
import com.pu.warehouse.model.dto.ProductUpdateDTO;
import com.pu.warehouse.model.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Page<Product> getAll();

    List<ProductDTO> searchProduct(Long categoryId, String searchTerm, int pageNumber, int pageSize);

    void deleteProduct(Long productId);

    void updateProduct(ProductUpdateDTO productUpdateDTO, long productId);

    void createProduct(ProductCreateDTO productCreateDTO);
}
