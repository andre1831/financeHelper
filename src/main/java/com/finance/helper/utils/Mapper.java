package com.finance.helper.utils;

public interface Mapper<I, O> {
    O map(I target);
}
