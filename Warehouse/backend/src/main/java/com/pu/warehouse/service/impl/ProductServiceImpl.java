package com.pu.warehouse.service.impl;

import com.pu.warehouse.model.dto.ProductCreateDTO;
import com.pu.warehouse.model.dto.ProductDTO;
import com.pu.warehouse.model.dto.ProductUpdateDTO;
import com.pu.warehouse.model.entity.Product;
import com.pu.warehouse.repository.ProductRepository;
import com.pu.warehouse.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<Product> getAll() {
        return null;
    }

    @Override
    public List<ProductDTO> searchProduct(Long categoryId, String searchTerm, int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Product> productPage = productRepository.findAllByCategoryIdAndName(categoryId, searchTerm, pageable);
        List<ProductDTO> products = productPage.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();

        return products;
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = findById(productId);
        productRepository.delete(product);
    }

    @Override
    public void updateProduct(ProductUpdateDTO productUpdateDTO, long productId) {
        Product product = findById(productId);

    }

    @Override
    public void createProduct(ProductCreateDTO productCreateDTO) {

    }

    private Product findById(Long productId){
       return productRepository.findById(productId)
               .orElseThrow(() -> new InternalError("hehe"));
    }
}
