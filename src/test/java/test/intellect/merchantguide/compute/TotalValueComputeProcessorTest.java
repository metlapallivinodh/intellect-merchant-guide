package test.intellect.merchantguide.compute;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.intellect.merchantguide.exception.CurrencyNotDefinedException;
import test.intellect.merchantguide.model.GalacticCurrencies;
import test.intellect.merchantguide.model.RomanCurrency;
import test.intellect.merchantguide.output.OutputProcessor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

class TotalValueComputeProcessorTest {

    @BeforeAll
    static void setUp() {
        GalacticCurrencies.add("tegj", RomanCurrency.L);
        GalacticCurrencies.add("glob", RomanCurrency.I);
        GalacticCurrencies.add("prok", RomanCurrency.V);
        GalacticCurrencies.add("pish", RomanCurrency.X);
    }

    @Test
    void testProcessWithCorrectInput() throws Exception {
        OutputProcessor outputProcessor = mock(OutputProcessor.class);
        List<String> input = new ArrayList<>(5);
        input.add("how much is pish tegj glob glob ?");
        ComputeProcessor processor = new TotalValueComputeProcessor(outputProcessor);
        processor.process(input);
        Mockito.verify(outputProcessor, Mockito.times(1)).process("pish tegj glob glob is 42");
    }

    @Test
    void testProcessWithInCorrectInput() throws Exception {
        List<String> input = new ArrayList<>(5);
        input.add("how much is pish tegj xxxx glob ?");
        ComputeProcessor processor = new TotalValueComputeProcessor();
        Assertions.assertThrows(
                CurrencyNotDefinedException.class,
                () -> processor.process(input),
                "Should throw CurrencyNotDefinedException"
        );
    }

    @AfterAll
    static void tearDown() {
        GalacticCurrencies.clearAll();
    }
}