package com.llddbtool.filters;

import com.llddbtool.utilities.StringMatching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class StringFilterInput {
    private String value;
	private StringMatching matching;
}
