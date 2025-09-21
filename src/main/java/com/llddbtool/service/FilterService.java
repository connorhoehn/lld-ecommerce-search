package com.llddbtool.service;

import java.util.*;

import com.llddbtool.expressions.BoolExpression;
import com.llddbtool.expressions.Spec;
import com.llddbtool.expressions.SpecBuilder;
import com.llddbtool.filters.*;
import com.llddbtool.strategies.*;


import com.llddbtool.models.Inventory;
import com.llddbtool.models.Product;

public class FilterService {

    private Inventory inventory;
    private Map<String, IFilterStrategy> filterStrategiesMap = new HashMap<>(Map.of("name", new NameFilterStrategy(),"category", new CategoryFilterStrategy(), "price", new PriceFilterStrategy()));

    /**
	 * filterItems:[
	 * 		{property: "name",
	 * 		 stringValue: {
	 	* 		value: "iphone",
	 	* 		matching: "EQUALS"
	 * 		 }}
	 * , 
	 * {}]
 	*/

    public FilterService (Inventory inventory) {
        this.inventory = inventory;
    }
    
    public List<Product> filter(List<FilterItem> filterItems) {
        List<Product> allProducts = inventory.getAllProducts();

        List<Product> filteredProducts = new ArrayList<Product>();
        for (Product product: allProducts) {
            boolean isFilteredOut = false;

            for (FilterItem item: filterItems) {
                IFilterStrategy filterStrategy = filterStrategiesMap.get(item.getProperty());
                if (!filterStrategy.isMatching(product, item)) {
                    isFilteredOut = true;
                }
            }
            if (!isFilteredOut) {
                filteredProducts.add(product);
            }

        }

        return filteredProducts;
    }

    public List<Product> filter(BoolExpression exp) {
        SpecBuilder builder = new SpecBuilder(filterStrategiesMap);
        Spec<Product> spec = builder.build(exp);

        List<Product> result = new ArrayList<>();
        for (Product p: inventory.getAllProducts()) {
            if (spec.test(p)) {
                result.add(p);
            }
        }
        return result;
    }

    
}
