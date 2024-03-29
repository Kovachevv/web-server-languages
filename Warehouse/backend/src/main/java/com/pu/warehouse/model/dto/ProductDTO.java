package com.pu.warehouse.model.dto;


import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private long category;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal sellingPrice;
    private int quantity;
    private int code;

    public ProductDTO(String name, long category, String description, BigDecimal purchasePrice, BigDecimal sellingPrice, int quantity, int code) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public long getCategory() {
        return category;
    }

    public ProductDTO setCategory(long category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public ProductDTO setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public ProductDTO setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ProductDTO setCode(int code) {
        this.code = code;
        return this;
    }
}
