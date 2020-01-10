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

        //Decided to use empty space as split in this implementation, easy to move from this.
        List<String> splitParagraph = Arrays.asList(paragraph.split(" "));

        int from = 0;
        int to = size;

        while (to <= splitParagraph.size()){
           tuples.add(String.join(" ", splitParagraph.subList(from++, to++)));
        }

        //Choose to return size 0 when no tuples generated, instead of exception when size > than words.
        return tuples;
    }
}
