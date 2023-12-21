package com.pu.warehouse.model.entity;

import com.pu.warehouse.model.enumaration.CategoryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "name")
    private CategoryType name;

    public CategoryType getName() {
        return name;
    }

    public Category setName(CategoryType name) {
        this.name = name;
        return this;
    }
}
