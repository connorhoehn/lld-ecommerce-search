package com.llddbtool.expressions;

import java.util.List;

import lombok.Getter;

public class And implements BoolExpression {
    @Getter
    private List<BoolExpression> children;
    
    public And(List<BoolExpression> children) {
        this.children = List.copyOf(children);
    }
}

