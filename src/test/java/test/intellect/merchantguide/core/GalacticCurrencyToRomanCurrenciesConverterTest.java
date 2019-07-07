package test.intellect.merchantguide.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.intellect.merchantguide.exception.CurrencyNotDefinedException;
import test.intellect.merchantguide.model.GalacticCurrencies;
import test.intellect.merchantguide.model.RomanCurrency;

import java.util.Arrays;

@DisplayName("While converting GalacticCurrencies to RomanCurrency")
class GalacticCurrencyToRomanCurrenciesConverterTest {

    @BeforeAll
    static void setUp() {
        GalacticCurrencies.add("tegj", RomanCurrency.L);
        GalacticCurrencies.add("glob", RomanCurrency.I);
        GalacticCurrencies.add("prok", RomanCurrency.V);
        GalacticCurrencies.add("pish", RomanCurrency.X);
    }

    @Test
    @DisplayName("given correct inputs")
    void testConvertWithCorrectInputs() throws CurrencyNotDefinedException {
        GalacticCurrencyToRomanCurrencyConverter converter = new GalacticCurrencyToRomanCurrencyConverter();
        Assertions.assertEquals(
                Arrays.asList(RomanCurrency.I, RomanCurrency.L, RomanCurrency.X),
                converter.convert(
                    "glob tegj pish"
                ),
                "Expected Roman currencies are I, L, X"
        );
    }

    @Test
    @DisplayName("given undefined currency inputs")
    void testConvertWithUndefinedCurrencyInputs() throws CurrencyNotDefinedException {
        GalacticCurrencyToRomanCurrencyConverter converter = new GalacticCurrencyToRomanCurrencyConverter();
        Assertions.assertThrows(
                CurrencyNotDefinedException.class,
                () -> converter.convert(
                        "glob xxxx"
                ),
                "Expecting CurrencyNotDefinedException"
        );
    }

    @AfterAll
    static void tearDown() {
        GalacticCurrencies.clearAll();
    }
}