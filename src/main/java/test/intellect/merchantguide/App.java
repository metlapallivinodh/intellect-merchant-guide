package test.intellect.merchantguide;

import test.intellect.merchantguide.compute.ComputeProcessorChain;
import test.intellect.merchantguide.input.processor.InputProcessorChain;
import test.intellect.merchantguide.input.reader.FileReader;
import test.intellect.merchantguide.input.reader.TextFileReader;

import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        FileReader fileReader = new TextFileReader();
        final List<String> inputLines = fileReader.read("data.txt");

        InputProcessorChain inputProcessorChain = new InputProcessorChain();
        inputProcessorChain.execute(inputLines);

        ComputeProcessorChain computeProcessorChain = new ComputeProcessorChain();
        computeProcessorChain.execute(inputLines);

    }

}
