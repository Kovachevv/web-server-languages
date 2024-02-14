package com.pu.warehouse.config;

import com.pu.warehouse.model.dto.ProductDTO;
import com.pu.warehouse.model.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    public static ModelMapper configure(){

        final ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Product.class, ProductDTO.class)
                .addMapping(Product::getName, ProductDTO::setName)
                .addMapping(Product::getDescription, ProductDTO::setDescription)
                .addMapping(Product::getQuantity, ProductDTO::setQuantity)
                .addMapping(Product::getCode, ProductDTO::setCode);

        return modelMapper;
    }




    @Bean
    public ModelMapper modelMapper(){
        return ModelMapperConfig.configure();
    }
}
