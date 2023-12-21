package com.pu.warehouse.model.entity;

import com.pu.warehouse.model.enumaration.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleEnum name;

    public RoleEnum getName() {
        return name;
    }

    public Role setName(RoleEnum name) {
        this.name = name;
        return this;
    }
}
