package com.llddbtool.evaluators;

import com.llddbtool.utilities.*;

public interface IStringFilterItemEvaluator {
    boolean isApplicable(StringMatching how);
    boolean matches(String str1, String str2);
}
