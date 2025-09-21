package com.llddbtool.evaluators;

import com.llddbtool.utilities.StringMatching;

public class PrefixStringMatchingEvaluator implements IStringFilterItemEvaluator {
    public boolean isApplicable(StringMatching how) {
        return how.equals(StringMatching.PREFIX);
    }
    public boolean matches(String str1, String str2) {
        return str2.startsWith(str1);
    }

}
