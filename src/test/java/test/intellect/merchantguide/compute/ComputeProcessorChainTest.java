package test.intellect.merchantguide.compute;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputeProcessorChainTest {

    @Test
    void execute() throws Exception {
        ComputeProcessor c1 = Mockito.mock(TotalValueComputeProcessor.class);
        ComputeProcessor c2 = Mockito.mock(CreditValueComputeProcessor.class);
        ComputeProcessor c3 = Mockito.mock(UnrecognizedValueComputeProcessor.class);
        ComputeProcessorChain chain = new ComputeProcessorChain(
                Collections.enumeration(
                        Arrays.asList(c1, c2, c3)
                )
        );
        final List<String> inputLines = Arrays.asList("a");
        chain.execute(inputLines);
        Mockito.verify(c1, Mockito.times(1)).process(inputLines);
        Mockito.verify(c2, Mockito.times(1)).process(inputLines);
        Mockito.verify(c3, Mockito.times(1)).process(inputLines);
    }
}