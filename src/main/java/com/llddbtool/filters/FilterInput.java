package com.llddbtool.filters;

import com.llddbtool.utilities.*;

import lombok.Getter;

@Getter
public class FilterInput {
    private Range price;
    private StringFilterInput category;
    private StringFilterInput name;
}
