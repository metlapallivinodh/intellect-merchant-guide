package test.intellect.merchantguide.input.processor;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class InputProcessorChainTest {

    @Test
    void execute() throws Exception {
        InputProcessor c1 = Mockito.mock(GalacticCurrencyInputProcessor.class);
        InputProcessor c2 = Mockito.mock(MetalCreditInputProcessor.class);
        InputProcessorChain chain = new InputProcessorChain(
                Collections.enumeration(
                        Arrays.asList(c1, c2)
                )
        );
        final List<String> inputLines = Arrays.asList("a");
        chain.execute(inputLines);
        Mockito.verify(c1, Mockito.times(1)).process(inputLines);
        Mockito.verify(c2, Mockito.times(1)).process(inputLines);
    }
}