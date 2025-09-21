package com.llddbtool.strategies;

import com.llddbtool.models.*;
import com.llddbtool.utilities.*;
import com.llddbtool.filters.*;

public class PriceFilterStrategy implements IFilterStrategy {
    
    public boolean isMatching(Product p, FilterItem item) {
        Range priceRange = ((RangeFilterItemData) item.getFilterData()).getValue();

        return priceRange == null || RangeHelper.doesLieInRange(priceRange, p.getPrice());
    }
}
