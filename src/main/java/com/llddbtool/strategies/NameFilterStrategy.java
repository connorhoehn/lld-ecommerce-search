package com.llddbtool.strategies;

import java.util.HashMap;
import java.util.Map;

import com.llddbtool.evaluators.ContainsStringMatchingEvaluator;
import com.llddbtool.evaluators.EqualsStringMatchingEvaluator;
import com.llddbtool.evaluators.IStringFilterItemEvaluator;
import com.llddbtool.filters.FilterItem;
import com.llddbtool.filters.StringFilterInput;
import com.llddbtool.filters.StringFilterItemData;
import com.llddbtool.models.*;
import com.llddbtool.utilities.StringMatching;

public class NameFilterStrategy implements IFilterStrategy {
    Map<StringMatching, IStringFilterItemEvaluator> evaluatorMap = new HashMap<>(Map.of(StringMatching.EQUALS, new EqualsStringMatchingEvaluator(), StringMatching.CONTAINS, new ContainsStringMatchingEvaluator()));

    public boolean isMatching(Product p, FilterItem item) {
        StringFilterItemData data = (StringFilterItemData) item.getFilterData();
        if (data == null) {
            return true;
        }

        StringFilterInput inputData = data.getData();

        return evaluatorMap.get(inputData.getMatching()).matches(inputData.getValue(), p.getName());
    }
}
