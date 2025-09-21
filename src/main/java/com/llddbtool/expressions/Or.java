package com.llddbtool.expressions;

import java.util.List;

import lombok.Getter;

public class Or implements BoolExpression {
    @Getter
    private List<BoolExpression> children;
    
    public Or(List<BoolExpression> children) {
        this.children = List.copyOf(children);
    }
}

