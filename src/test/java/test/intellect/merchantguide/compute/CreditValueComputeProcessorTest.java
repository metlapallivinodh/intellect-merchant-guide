package test.intellect.merchantguide.compute;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.intellect.merchantguide.exception.CurrencyNotDefinedException;
import test.intellect.merchantguide.model.GalacticCurrencies;
import test.intellect.merchantguide.model.Metals;
import test.intellect.merchantguide.model.RomanCurrency;
import test.intellect.merchantguide.output.OutputProcessor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

class CreditValueComputeProcessorTest {
    @BeforeAll
    static void setUp() {
        GalacticCurrencies.add("tegj", RomanCurrency.L);
        GalacticCurrencies.add("glob", RomanCurrency.I);
        GalacticCurrencies.add("prok", RomanCurrency.V);
        GalacticCurrencies.add("pish", RomanCurrency.X);

        Metals.add("Silver", 17d);
        Metals.add("Gold", 14450d);
    }

    @Test
    void testProcessWithCorrectInput() throws Exception {
        OutputProcessor outputProcessor = mock(OutputProcessor.class);
        List<String> input = new ArrayList<>(5);
        input.add("how many Credits is glob prok Silver ?");
        input.add("how many Credits is glob prok Gold ?");
        ComputeProcessor processor = new CreditValueComputeProcessor(outputProcessor);
        processor.process(input);
        Mockito.verify(outputProcessor, Mockito.times(1)).process("glob prok Silver is 68 Credits");
        Mockito.verify(outputProcessor, Mockito.times(1)).process("glob prok Gold is 57800 Credits");
    }

    @Test
    void testProcessWithInCorrectInput() throws Exception {
        List<String> input = new ArrayList<>(5);
        input.add("how many Credits is xxxx prok Silver ?");
        ComputeProcessor processor = new CreditValueComputeProcessor();
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