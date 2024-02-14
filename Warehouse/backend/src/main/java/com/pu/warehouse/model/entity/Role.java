package com.pu.warehouse.model.entity;

import com.pu.warehouse.model.enumaration.RoleEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
