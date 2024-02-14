package com.pu.warehouse.model.enumaration;

import java.util.Arrays;

public enum CategoryType {

    GROCERIES("Groceries"),OFFICE_SUPPLIES("Office supplies"), BUILDING_MATERIAL("Building materials");

    private final String name;

    CategoryType(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }


    public static CategoryType fromDisplayName(String displayName) {
        return Arrays.stream(CategoryType.values())
                .filter(e -> e.getName().equalsIgnoreCase(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown display name: " + displayName));
    }
}
