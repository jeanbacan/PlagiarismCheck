package com.plagiarism;

import com.tuples.ITupleGenerator;
import com.tuples.TextTupleGenerator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class PlagiarismDetection {
    private static final int DEFAULT_TUPLES_SIZE = 3;
    private final String[] synonyms;
    private final String textToBeChecked;
    private final String textToMatch;

    public PlagiarismDetection(String[] synonyms, String text1, String text2){
        this.synonyms = synonyms;
        this.textToBeChecked = stripSynonyms(text1);
        this.textToMatch = stripSynonyms(text2);
    }

    public float execute(ITupleGenerator<String, String> generator){
        List<String> generateTuples = generator.generateTuples(textToBeChecked);
        if (generateTuples.size() == 0)
            return 0;

        int matchedTuples = 0;

        for (String tuple : generateTuples){
            matchedTuples += textToMatch.contains(tuple) ? 1 : 0;
        }
        return matchedTuples * 100 / generateTuples.size();
    }

    protected String stripSynonyms(String textToReplace){
        for (String syn : synonyms){
            textToReplace = textToReplace.replace(syn, "{#}");
        }
        return textToReplace;
    }

    public static void main(String[] args) throws FileNotFoundException{
        if (args.length < 3){
            throw new IllegalArgumentException(
                    "Provide at least 3 files:\n" +
                            "1) File with list of Synonyms\n" +
                            "2) Input file 1\n" +
                            "3) Input file 2\n" +
                            "4) (Optional) Tuple size, default is 3");
        }
        Scanner scSynonyms = new Scanner(new FileReader(args[0]));
        Scanner scFile1 = new Scanner(new FileReader(args[1]));
        Scanner scFile2 = new Scanner(new FileReader(args[2]));

        PlagiarismDetection plagiarismDetection = new PlagiarismDetection(scSynonyms.nextLine().split(" "),
                                                                          scFile1.nextLine(),
                                                                          scFile2.nextLine());
        int tupleSize = args.length == 4 ? new Integer(args[3]) : DEFAULT_TUPLES_SIZE;
        float matched = plagiarismDetection.execute(new TextTupleGenerator(tupleSize));

        System.out.println(String.format("%.0f%%", matched));
    }
}