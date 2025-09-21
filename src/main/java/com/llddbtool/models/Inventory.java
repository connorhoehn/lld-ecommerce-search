package com.llddbtool.models;

import java.util.List;

import lombok.Setter;

public class Inventory {
    @Setter
    private List<Product> products;

    public List<Product> getAllProducts() {
        return products;
    }
}
