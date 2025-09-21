package com.llddbtool.utilities;

public class RangeHelper {

    public static boolean doesLieInRange(Range range, Integer price) {
        return range.getMin() < price && range.getMax() > price;
    }
}

