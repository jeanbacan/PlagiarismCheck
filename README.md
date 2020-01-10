## Running
1) Add all your desired files in the /resources folder inside the PlagiarismCheck. 
2) From /src folder, execute:

Compiling the needed classes:
```bash
javac com/plagiarism/*.java com/tuples/*.java
```

Runnning Application
```bash
java com/plagiarism/PlagiarismDetection "../resources/synonyms.txt" "../resources/file1.txt" "../resources/file2.txt"
or
java com/plagiarism/PlagiarismDetection "../resources/synonyms.txt" "../resources/file1.txt" "../resources/file2.txt" 4
```


## Testing (Unit)
Although not required to run or compile the Application, this test file proof to be helpful during development when testing
different texts without the need of executing the Main application with different files. Also did not print the success scenarios for simplicity.

```bash
java -ea com/tuples/TupleGeneratorTest
java -ea com/plagiarism/PlagiarismDetectionTest
```

