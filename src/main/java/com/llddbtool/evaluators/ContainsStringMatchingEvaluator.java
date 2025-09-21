package com.llddbtool.evaluators;

import com.llddbtool.utilities.StringMatching;

public class ContainsStringMatchingEvaluator implements IStringFilterItemEvaluator {
    public boolean isApplicable(StringMatching how) {
        return how.equals(StringMatching.CONTAINS);
    }
    public boolean matches(String str1, String str2) {
        return str2.contains(str1);
    }

}
