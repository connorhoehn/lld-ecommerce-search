package com.llddbtool.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    String id;
    String name;
    Integer price;
    String category;
}
