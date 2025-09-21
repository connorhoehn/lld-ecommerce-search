package com.llddbtool.expressions;

import com.llddbtool.filters.FilterItem;

import lombok.Getter;

public class Leaf implements BoolExpression {
    @Getter
    private final FilterItem item;

    public Leaf(FilterItem filterItem) {
        this.item = filterItem;
    }
}
