package com.llddbtool.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.llddbtool.filters.FilterItem;
import com.llddbtool.models.*;
import com.llddbtool.strategies.*;

import lombok.AllArgsConstructor;
import lombok.Getter;;

@AllArgsConstructor
public class SpecBuilder {

    @Getter
    private Map<String, IFilterStrategy> strategies;

    public Spec<Product> build(BoolExpression expression) {
        if (expression instanceof Leaf l) {
            return buildLeaf(l.getItem());
        } else if (expression instanceof And a) {
            return buildAnd(a.getChildren());
        } else if (expression instanceof Or o) {
            return buildOr(o.getChildren());
        } else{
            throw new IllegalAccessError();
        }
    }

    private Spec<Product> buildAnd(List<BoolExpression> children) {
        if (children.isEmpty()) {
            return Spec.alwaysPass();
        } else {
            List<Spec<Product>> products = new ArrayList<>();
            for (BoolExpression child: children) {
                products.add(this.build(child));
            }
            return new Spec<Product>(p -> {
                for (Spec<Product> productSpec: products) {
                    if (!productSpec.test(p)) {
                        return false;
                    }
                }
                return true;
            });
        }
    }

    private Spec<Product> buildOr(List<BoolExpression> children) {
        if (children.isEmpty()) {
            return Spec.alwaysFail();
        } else {
            List<Spec<Product>> products = new ArrayList<>();
            for (BoolExpression child: children) {
                products.add(this.build(child));
            }
            return new Spec<Product>(p -> {
                for (Spec<Product> productSpec: products) {
                    if (productSpec.test(p)) {
                        return true;
                    }
                }
                return false;
            });
        }
    }

    private Spec<Product> buildLeaf(FilterItem item) {
        IFilterStrategy strategy = strategies.get(item.getProperty());

        if (strategy == null) {
            throw new IllegalAccessError();
        }

        return new Spec<>(p -> strategy.isMatching(p, item));
    }
}
