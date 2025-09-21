package com.llddbtool.filters;

import com.llddbtool.utilities.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RangeFilterItemData implements IFilterItemData {
    private Range value;    
}
