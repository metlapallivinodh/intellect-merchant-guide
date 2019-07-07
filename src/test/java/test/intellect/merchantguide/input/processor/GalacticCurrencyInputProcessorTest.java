package test.intellect.merchantguide.input.processor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.intellect.merchantguide.exception.NoSuchRomanCurrencyException;
import test.intellect.merchantguide.model.GalacticCurrencies;
import test.intellect.merchantguide.model.RomanCurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("While testing GalacticCurrencyInputProcessor")
class GalacticCurrencyInputProcessorTest {

    @Test
    void testProcessWithCorrectInput() throws Exception {
        List<String> input = new ArrayList<>(5);
        input.add("glob is I");
        input.add("prok is V");
        InputProcessor inputProcessor = new GalacticCurrencyInputProcessor();
        inputProcessor.process(input);
        Assertions.assertEquals(2, GalacticCurrencies.getAvailableCurrencies().size(), "Size should be 2");
        Assertions.assertEquals(RomanCurrency.I, GalacticCurrencies.getRomanCurrency("glob"), "Should be I");
        Assertions.assertEquals(RomanCurrency.V, GalacticCurrencies.getRomanCurrency("prok"), "Should be V");
        Assertions.assertNull(GalacticCurrencies.getRomanCurrency("xxxx"), "Should be null");
    }

    @AfterEach
    void clean() {
        GalacticCurrencies.clearAll();
    }
}