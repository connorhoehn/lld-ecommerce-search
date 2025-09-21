package com.llddbtool.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
public class StringFilterItemData implements IFilterItemData {
    @Getter
    private StringFilterInput data;    
}
