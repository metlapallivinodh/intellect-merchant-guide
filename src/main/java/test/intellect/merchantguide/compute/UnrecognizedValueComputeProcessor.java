package test.intellect.merchantguide.compute;

import test.intellect.merchantguide.output.ConsoleWriterOutputProcessor;
import test.intellect.merchantguide.output.OutputProcessor;

import java.util.List;

class UnrecognizedValueComputeProcessor implements ComputeProcessor {

    private final OutputProcessor outputProcessor;

    public UnrecognizedValueComputeProcessor(OutputProcessor outputProcessor) {
        this.outputProcessor = outputProcessor;
    }

    public UnrecognizedValueComputeProcessor() {
        this(new ConsoleWriterOutputProcessor());
    }

    public void process(List<String> inputList) {
        if (!inputList.isEmpty()) {
            inputList.forEach(l -> outputProcessor.process("I have no idea what you are talking about"));
        }
    }
}
