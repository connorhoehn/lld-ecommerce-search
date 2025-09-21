package com.llddbtool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.llddbtool.expressions.And;
import com.llddbtool.expressions.BoolExpression;
import com.llddbtool.expressions.Leaf;
import com.llddbtool.expressions.Or;
import com.llddbtool.filters.FilterItem;
import com.llddbtool.filters.RangeFilterItemData;
import com.llddbtool.filters.StringFilterItemData;
import com.llddbtool.filters.StringFilterInput;
import com.llddbtool.models.Inventory;
import com.llddbtool.models.Product;
import com.llddbtool.service.FilterService;
import com.llddbtool.utilities.Range;
import com.llddbtool.utilities.StringMatching;

public class Main {

    public static void main(String[] args) {

        Product productOne = new Product("0", "iphone", 130,"electronics");
        Product productTwo = new Product("1", "television", 130,"electronics");
        Product productThree = new Product("2", "new phone", 130,"electronics");

        Inventory inventory = new Inventory();
        inventory.setProducts(new ArrayList<>(Arrays.asList(productOne, productTwo, productThree)));
        
        // FilterItem simpleStringFilter = new FilterItem("name", 
        //     new StringFilterItemData(
        //         new StringFilterInput("phone", StringMatching.CONTAINS)
        //     )
        // );

        // FilterItem simpleEqualsFilter = new FilterItem("name", 
        //     new StringFilterItemData(
        //         new StringFilterInput("iphone", StringMatching.EQUALS)
        //     )
        // );
        
        // FilterItem simplePriceRangeFilter = new FilterItem("price", 
        //     new RangeFilterItemData(new Range(0, 135)));
        

        BoolExpression expr =
            new Or(List.of(
                new And(List.of(
                    new Leaf(new FilterItem(
                        "name",
                        new StringFilterItemData(
                            new StringFilterInput("iphone", StringMatching.EQUALS)
                        )
                    )),
                    new Leaf(new FilterItem(
                        "price",
                        new RangeFilterItemData(new Range(0, 135))
                    ))
                )),
                new Leaf(new FilterItem(
                    "name",
                    new StringFilterItemData(
                        new StringFilterInput("phone", StringMatching.CONTAINS)
                    )
                ))
            ));



        FilterService filterer = new FilterService(inventory);
        List<Product> filteredByExpr = filterer.filter(expr);

        System.out.println("Products after expr filtering: " + filteredByExpr.size());


        // List<Product> filteredProducts = filterer.filter(Arrays.asList(simpleStringFilter,simplePriceRangeFilter, simpleEqualsFilter));
        // // List<Product> filteredProducts = filterer.filter(Arrays.asList(simplePriceRangeFilter));

        // System.out.println("Number of products in inventory: " + inventory.getAllProducts().size());
        // System.out.println("Number of products after filtering: " + filteredProducts.size());
    }
}

