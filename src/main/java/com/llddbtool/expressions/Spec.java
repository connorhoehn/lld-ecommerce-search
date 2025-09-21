package com.llddbtool.expressions;

import java.util.function.Predicate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Spec<T> {
    private Predicate<T> predicate;

    public boolean test(T t) {
        return predicate.test(t);
    }

    public Spec<T> and(Spec<T> other) {
        return new Spec<>(t -> this.test(t) && other.test(t));
    }
    
    public Spec<T> or(Spec<T> other) {
        return new Spec<>(t -> this.test(t) || other.test(t));
    }

    public static <T> Spec<T> alwaysPass() {
        return new Spec<>(t -> true);
    }
    public static <T> Spec<T> alwaysFail() {
        return new Spec<>(t -> false);
    }

}