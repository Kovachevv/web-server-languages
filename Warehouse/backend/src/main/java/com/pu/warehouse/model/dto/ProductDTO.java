package com.pu.warehouse.model.dto;


import java.math.BigDecimal;

public class ProductDTO {
    private long id;
    private String name;
    private String category;
    private String description;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
    private int quantity;
    private int code;

    public long getId() {
        return id;
    }

    public ProductDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductDTO setCategory(String category) {
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

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public ProductDTO setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
        return this;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public ProductDTO setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
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
