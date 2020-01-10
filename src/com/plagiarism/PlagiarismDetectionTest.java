package com.plagiarism;

import com.tuples.ITupleGenerator;
import com.tuples.TextTupleGenerator;

public class PlagiarismDetectionTest {

    public static void main(String[] args) {

        ITupleGenerator<String, String> generatorSize3 = new TextTupleGenerator(3);
        ITupleGenerator<String, String> generatorSize4 = new TextTupleGenerator(4);

        //Testing the stripSynonyms
        PlagiarismDetection detector = new PlagiarismDetection(new String[]{},
                                                               "Text to check",
                                                               "Text to match");
        assert detector.stripSynonyms("Text to check").equals("Text to check")
                : "Fail scenario 1, text should not change";

        PlagiarismDetection detector2 = new PlagiarismDetection(new String[]{"check", "match"},
                                                               "Text to check",
                                                               "Text to match");
        assert detector2.stripSynonyms("Text to {#}").equals("Text to {#}")
                : "Fail scenario 2, text replace synonyms";

        //Testing the stripSynonyms
        PlagiarismDetection detector3 = new PlagiarismDetection(new String[]{"check", "match"},
                                                               "Text to check",
                                                               "Text to match");
        assert detector3.execute(generatorSize3) == 100f : "Fail scenario 3, should match 100%";

        PlagiarismDetection detector4 = new PlagiarismDetection(new String[]{"check", "match"},
                                                                "Family likes to travel",
                                                                "friends likes to camp");
        assert detector4.execute(generatorSize3) == 0f : "Fail scenario 4, should match 0%";

        PlagiarismDetection detector5 = new PlagiarismDetection(new String[]{"Family", "friends"},
                                                                "Family likes to travel",
                                                                "friends likes to camp");
        assert detector5.execute(generatorSize3) == 50f : "Fail scenario 5, should match 50%";

        PlagiarismDetection detector6 = new PlagiarismDetection(new String[]{"Family", "friends"},
                                                                "Family likes to travel",
                                                                "friends likes to travel");
        assert detector6.execute(generatorSize4) == 100f : "Fail scenario 6, should match 100%";

        PlagiarismDetection detector7 = new PlagiarismDetection(new String[]{},
                                                                "Family likes to travel",
                                                                "Family likes to travel");
        assert detector7.execute(generatorSize4) == 100f : "Fail scenario 7, should match 100%";

        PlagiarismDetection detector8 = new PlagiarismDetection(new String[]{},
                                                                "Family likes to travel",
                                                                "Friend likes to travel");
        assert detector8.execute(generatorSize4) == 0f : "Fail scenario 8, should match 0%";

        PlagiarismDetection detector9 = new PlagiarismDetection(new String[]{},
                                                                "Family likes",
                                                                "Friend likes");
        assert detector9.execute(generatorSize4) == 0f : "Fail scenario 8, should match 0%";

        System.out.println("All (8) tests for PlagiarismDetectionTest successfully run.");
    }
}
