package com.llddbtool.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FilterItem {
    private String property; // name, price, category
    private IFilterItemData filterData;
}
