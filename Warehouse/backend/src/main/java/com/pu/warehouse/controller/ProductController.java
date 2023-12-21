package com.pu.warehouse.controller;

import com.pu.warehouse.model.dto.ProductCreateDTO;
import com.pu.warehouse.model.dto.ProductDTO;
import com.pu.warehouse.model.dto.ProductUpdateDTO;
import com.pu.warehouse.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
//
//    @GetMapping("/products")
//    public ResponseEntity<List<ProductDTO>> getAllProducts(){
//        Page<Product> products = productService.getAll();
//
//    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {

        productService.deleteProduct(productId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<List<ProductDTO>> search(@PathVariable Long categoryId,
                                                   @RequestParam String searchTerm,
                                                   @RequestParam(required = false, defaultValue = "1") int pageNumber,
                                                   @RequestParam(required = false, defaultValue = "8") int pageSize){

        List<ProductDTO> products = productService.searchProduct(categoryId, searchTerm, pageNumber, pageSize);

        return ResponseEntity.ok(products);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable long productId,
                                              @RequestBody ProductUpdateDTO productUpdateDTO){


        productService.updateProduct(productUpdateDTO, productId);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateDTO productCreateDTO){


        productService.createProduct(productCreateDTO);

        return ResponseEntity.ok().build();

    }



}
