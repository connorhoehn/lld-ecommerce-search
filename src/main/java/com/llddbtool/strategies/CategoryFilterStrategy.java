package com.llddbtool.strategies;

import java.util.HashMap;
import java.util.Map;

import com.llddbtool.evaluators.ContainsStringMatchingEvaluator;
import com.llddbtool.evaluators.EqualsStringMatchingEvaluator;
import com.llddbtool.evaluators.IStringFilterItemEvaluator;
import com.llddbtool.filters.FilterItem;
import com.llddbtool.filters.StringFilterInput;
import com.llddbtool.models.*;
import com.llddbtool.utilities.StringMatching;

public class CategoryFilterStrategy implements IFilterStrategy {
    Map<StringMatching, IStringFilterItemEvaluator> evaluatorMap = new HashMap<>(Map.of(StringMatching.EQUALS, new EqualsStringMatchingEvaluator(), StringMatching.CONTAINS, new ContainsStringMatchingEvaluator()));

    public boolean isMatching(Product p, FilterItem item) {
        StringFilterInput input = ((StringFilterInput) item.getFilterData());
        if (input == null) {
            return true;
        }

        return evaluatorMap.get(input.getMatching()).matches(input.getValue(), p.getCategory());
    }
}
