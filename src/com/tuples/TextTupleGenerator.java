package com.tuples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextTupleGenerator implements ITupleGenerator<String, String> {
    private final int size;

    public TextTupleGenerator(int size){
        this.size = size;
    }

    @Override
    public List<String> generateTuples(String paragraph){
        List<String> tuples = new ArrayList<>();
        List<String> splitParagraph = Arrays.asList(paragraph.split(" "));

        int from = 0;
        int to = size;

        while (to <= splitParagraph.size()){
           tuples.add(String.join(" ", splitParagraph.subList(from++, to++)));
        }
        return tuples;
    }
}
