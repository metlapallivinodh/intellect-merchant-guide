package test.intellect.merchantguide.compute;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.intellect.merchantguide.output.OutputProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UnrecognizedValueComputeProcessorTest {

    @Test
    void testProcessWithEmptyInputInput() throws Exception {
        OutputProcessor outputProcessor = mock(OutputProcessor.class);
        ComputeProcessor processor = new UnrecognizedValueComputeProcessor(outputProcessor);
        processor.process(new ArrayList<>());
        Mockito.verify(outputProcessor, Mockito.times(0)).process("I have no idea what you are talking about");
    }

    @Test
    void testProcessWith2Input() throws Exception {
        OutputProcessor outputProcessor = mock(OutputProcessor.class);
        ComputeProcessor processor = new UnrecognizedValueComputeProcessor(outputProcessor);
        processor.process(Arrays.asList("a", "b"));
        Mockito.verify(outputProcessor, Mockito.times(2)).process("I have no idea what you are talking about");
    }
}