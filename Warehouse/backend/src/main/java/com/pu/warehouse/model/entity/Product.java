package com.pu.warehouse.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Category category;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "buy_price")
    private BigDecimal purchasePrice;

    @NotNull
    @Column(name = "sell_price")
    private BigDecimal sellingPrice;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @NotNull
    @Column(name = "code")
    private int code;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public Product setPurchasePrice(BigDecimal buyPrice) {
        this.purchasePrice = buyPrice;
        return this;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public Product setSellingPrice(BigDecimal sellPrice) {
        this.sellingPrice = sellPrice;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Product setCode(int code) {
        this.code = code;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }
}
