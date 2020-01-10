package com.tuples;

public class TupleGeneratorTest {

    public static void main(String[] args) {

        //Testing for Default size 3 tuples
        ITupleGenerator<String, String> generator1 = new TextTupleGenerator(3);
        assert generator1.generateTuples("go for a run").size() == 2
                : "Test case 1, when size default, fail.";

        ITupleGenerator<String, String> generator2 = new TextTupleGenerator(3);
        assert generator2.generateTuples("my family love to travel in summer").size() == 5
                : "Test case 2, when size default, fail.";

        ITupleGenerator<String, String> generator3 = new TextTupleGenerator(3);
        assert generator3.generateTuples("great home").size() == 0
                : "Test case 3, when size default, fail.";

        //Testing for Default size N tuples
        ITupleGenerator<String, String> generator4 = new TextTupleGenerator(5);
        assert generator4.generateTuples("go for a run with my friends").size() == 3
                : "Test case 4, when size 5, fail.";

        ITupleGenerator<String, String> generator5 = new TextTupleGenerator(4);
        assert generator5.generateTuples("my family love to travel in summer").size() == 4
                : "Test case 5, when size 4, fail.";

        ITupleGenerator<String, String> generator6 = new TextTupleGenerator(4);
        assert generator6.generateTuples("great home").size() == 0
                : "Test case 6, when size 4, fail.";

        System.out.println("All (6) tests for TupleGenerator successfully run.");
    }
}
