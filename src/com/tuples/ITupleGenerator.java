package com.tuples;

import java.util.List;

//We could use a list of Dtos or Domain as return, when having a JSON/XML as origin.
public interface ITupleGenerator<T, O> {
    List<T> generateTuples(O origin);
}