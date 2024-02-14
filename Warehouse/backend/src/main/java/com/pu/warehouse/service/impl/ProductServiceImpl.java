package com.pu.warehouse.service.impl;

import com.pu.warehouse.model.dto.ProductDTO;
import com.pu.warehouse.model.dto.ProductEditDTO;
import com.pu.warehouse.model.entity.Category;
import com.pu.warehouse.model.entity.Product;
import com.pu.warehouse.model.enumaration.CategoryType;
import com.pu.warehouse.repository.CategoryRepository;
import com.pu.warehouse.repository.ProductRepository;
import com.pu.warehouse.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    @Override
    public Page<Product> searchProducts(String searchTerm, String categoryName, Integer code, Pageable pageable) {
        if (code != null) {
            return productRepository.findByCode(code, pageable);
        } else if (searchTerm != null && !searchTerm.isEmpty() && categoryName != null && !categoryName.equals("All")) {
            CategoryType categoryType = CategoryType.fromDisplayName(categoryName);
            return productRepository.findByNameContainingIgnoreCaseAndCategoryType(searchTerm, categoryType, pageable);
        } else if (searchTerm != null && !searchTerm.isEmpty()) {
            return productRepository.findByNameContainingIgnoreCase(searchTerm, pageable);
        } else if (categoryName != null && !categoryName.equals("All")) {
            CategoryType categoryType = CategoryType.fromDisplayName(categoryName);
            return productRepository.findByCategoryType(categoryType, pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new InternalError("lol"));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {

       if(productRepository.existsByCode(productDTO.getCode())){
           logger.error("Duplicate product code.");
           throw new IllegalArgumentException("Duplicate product code: " + productDTO.getCode());
       }

        Category category = categoryRepository.findById(productDTO.getCategory()).orElseThrow(() -> new RuntimeException("Category Not found"));

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCode(productDTO.getCode());
        product.setQuantity(productDTO.getQuantity());
        product.setPurchasePrice(productDTO.getPurchasePrice());
        product.setSellingPrice(productDTO.getSellingPrice());
        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, ProductEditDTO productDTO) {

        Product product = getProductById(id);

        if(Objects.nonNull(productDTO.getCode())){
            if (product.getCode() != (productDTO.getCode()) && productRepository.existsByCode(productDTO.getCode())){
                throw new IllegalArgumentException("Duplicate product code: " + productDTO.getCode());
            }else{
                product.setCode(productDTO.getCode());
            }
        }

        if (Objects.nonNull(productDTO.getName())) {
            product.setName(productDTO.getName());
        }

        if (Objects.nonNull(productDTO.getPurchasePrice())) {
            product.setPurchasePrice(productDTO.getPurchasePrice());
        }

        if (Objects.nonNull(productDTO.getSellingPrice())) {
            product.setSellingPrice(productDTO.getSellingPrice());
        }

        if (Objects.nonNull(productDTO.getQuantity())) {
            product.setQuantity(productDTO.getQuantity());
        }

        productRepository.save(product);
    }
}
