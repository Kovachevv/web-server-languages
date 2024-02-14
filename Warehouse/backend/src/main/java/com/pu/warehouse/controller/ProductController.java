package com.pu.warehouse.controller;

import com.pu.warehouse.model.dto.ProductDTO;
import com.pu.warehouse.model.dto.ProductEditDTO;
import com.pu.warehouse.model.dto.ProductViewDTO;
import com.pu.warehouse.model.entity.Product;
import com.pu.warehouse.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService inventoryService) {
        this.productService = inventoryService;
    }

    @GetMapping("/inventory")
    public String viewInventoryPage(@RequestParam(required = false) String searchTerm,
                                    @RequestParam(required = false) String category,
                                    @RequestParam(required = false) Integer code,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    Model model) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> pageResult;
        if ((searchTerm != null && !searchTerm.isEmpty()) ||
                (category != null && !category.equals("All")) ||
                (code != null)) {
            pageResult = productService.searchProducts(searchTerm, category, code, pageable);
        } else {
            pageResult = productService.getAllProducts(pageable);
        }


        Page<ProductViewDTO> result = convertToProductViewDTOPage(pageResult);

        model.addAttribute("page", result);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("category", category);
        model.addAttribute("code", code);
        return "inventory";
    }

    @GetMapping("/add-product")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @GetMapping("/edit-product/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit-product";
    }


    @PostMapping("/add-product")
    public String saveProduct(@ModelAttribute ProductDTO product, BindingResult result, RedirectAttributes redirectAttributes) {
      try {
          productService.saveProduct(product);
          return "redirect:/inventory";
      }catch (IllegalArgumentException e){
          redirectAttributes.addFlashAttribute("errorMessage", "Product code must be unique.");
          return "redirect:/add-product";
      }
    }

    @PostMapping("/edit-product/{id}")
    public String updateProduct(@PathVariable Long id,
                                @ModelAttribute ProductEditDTO productDTO){

        productService.updateProduct(id, productDTO);
        return "redirect:/inventory";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    public Page<ProductViewDTO> convertToProductViewDTOPage(Page<Product> productsPage) {
        return productsPage.map(this::convertToProductViewDTO);
    }

    private ProductViewDTO convertToProductViewDTO(Product product) {
        ProductViewDTO dto = new ProductViewDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCode(product.getCode());
        dto.setDescription(product.getDescription());
        dto.setQuantity(product.getQuantity());
        dto.setPurchasePrice(product.getPurchasePrice());
        dto.setSellingPrice(product.getSellingPrice());
        dto.setCategory(product.getCategory().getName().getName());
        return dto;
    }
}