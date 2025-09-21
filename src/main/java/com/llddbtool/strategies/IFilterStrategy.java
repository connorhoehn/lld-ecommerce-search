package com.llddbtool.strategies;

import com.llddbtool.filters.FilterItem;
import com.llddbtool.models.Product;

public interface IFilterStrategy {
    boolean isMatching(Product p, FilterItem item);
}
