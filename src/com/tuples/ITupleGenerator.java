package com.tuples;

import java.util.List;

public interface ITupleGenerator<T, O> {
    List<T> generateTuples(O origin);
}