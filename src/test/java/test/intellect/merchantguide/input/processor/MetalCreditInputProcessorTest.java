package test.intellect.merchantguide.input.processor;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.intellect.merchantguide.exception.CurrencyNotDefinedException;
import test.intellect.merchantguide.model.GalacticCurrencies;
import test.intellect.merchantguide.model.Metals;
import test.intellect.merchantguide.model.RomanCurrency;

import java.util.ArrayList;
import java.util.List;

@DisplayName("While testing MetalCreditInputProcessor")
class MetalCreditInputProcessorTest {

    @BeforeAll
    static void setUp() {
        GalacticCurrencies.add("tegj", RomanCurrency.L);
        GalacticCurrencies.add("glob", RomanCurrency.I);
        GalacticCurrencies.add("prok", RomanCurrency.V);
        GalacticCurrencies.add("pish", RomanCurrency.X);
    }

    @Test
    void testProcessWithCorrectInput() throws Exception {
        List<String> input = new ArrayList<>(5);
        input.add("glob glob Silver is 34 Credits");
        input.add("glob prok Gold is 57800 Credits");
        InputProcessor processor = new MetalCreditInputProcessor();
        processor.process(input);
        Assertions.assertEquals(2, Metals.getAvailableMetals().size(), "Size should be 2");
        Assertions.assertEquals(Double.valueOf(17.0), Metals.getUnitValue("Silver"), "Should be 17.0");
        Assertions.assertEquals(Double.valueOf(14450), Metals.getUnitValue("Gold"), "Should be 17.0");
        Assertions.assertNull(Metals.getUnitValue("XXXX"), "Should be null");

    }

    @Test
    void testProcessWithInCorrectInput() throws Exception {
        List<String> input = new ArrayList<>(5);
        input.add("xxxx xxxx Silver is 34 Credits");
        InputProcessor processor = new MetalCreditInputProcessor();
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