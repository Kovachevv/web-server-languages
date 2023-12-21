package com.pu.warehouse.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
    private BigDecimal buyPrice;

    @NotNull
    @Column(name = "sell_price")
    private BigDecimal sellPrice;

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

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public Product setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
        return this;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public Product setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
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
