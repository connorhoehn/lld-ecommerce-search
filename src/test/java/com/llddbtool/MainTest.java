package com.llddbtool;

import org.junit.jupiter.api.Test;

import com.llddbtool.filters.FilterItem;
import com.llddbtool.filters.RangeFilterItemData;
import com.llddbtool.filters.StringFilterInput;
import com.llddbtool.filters.StringFilterItemData;
import com.llddbtool.models.Inventory;
import com.llddbtool.models.Product;
import com.llddbtool.service.FilterService;
import com.llddbtool.utilities.Range;
import com.llddbtool.utilities.StringMatching;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

    @Test
    void generaBehavior() {
                Product productOne = new Product("0", "iphone", 130,"electronics");
        Product productTwo = new Product("1", "television", 130,"electronics");
        Product productThree = new Product("2", "new phone", 130,"electronics");

        Inventory inventory = new Inventory();
        inventory.setProducts(new ArrayList<>(Arrays.asList(productOne, productTwo, productThree)));

        FilterService filterer = new FilterService(inventory);
        
        FilterItem simpleStringFilter = new FilterItem("name", 
            new StringFilterItemData(
                new StringFilterInput("phone", StringMatching.CONTAINS)
            )
        );

        FilterItem simpleEqualsFilter = new FilterItem("name", 
            new StringFilterItemData(
                new StringFilterInput("iphone", StringMatching.EQUALS)
            )
        );

        FilterItem simplePriceRangeFilter = new FilterItem("price", 
            new RangeFilterItemData(new Range(0, 135)));

        List<Product> filteredProducts = filterer.filter(Arrays.asList(simpleStringFilter,simplePriceRangeFilter, simpleEqualsFilter));
        // List<Product> filteredProducts = filterer.filter(Arrays.asList(simplePriceRangeFilter));

        assertNotEquals(inventory.getAllProducts().size(), filteredProducts.size());
    }
}

