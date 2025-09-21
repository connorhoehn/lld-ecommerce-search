package com.llddbtool.evaluators;

import com.llddbtool.utilities.StringMatching;

public class EqualsStringMatchingEvaluator implements IStringFilterItemEvaluator {
    public boolean isApplicable(StringMatching how) {
        return how.equals(StringMatching.EQUALS);
    }
    public boolean matches(String str1, String str2) {
        return str2.equals(str1);
    }

}
