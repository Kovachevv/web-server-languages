package com.pu.warehouse.model.entity;

import com.pu.warehouse.model.enumaration.CategoryType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
