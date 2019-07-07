package test.intellect.merchantguide.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.intellect.merchantguide.exception.CurrencyNotDefinedException;
import test.intellect.merchantguide.model.GalacticCurrencies;
import test.intellect.merchantguide.model.RomanCurrency;

@DisplayName("While converting GalacticCurrency To DecimalCurrency")
class GalacticCurrencyToDecimalCurrencyConverterTest {

    @BeforeAll
    static void setUp() {
        GalacticCurrencies.add("tegj", RomanCurrency.L);
        GalacticCurrencies.add("glob", RomanCurrency.I);
        GalacticCurrencies.add("prok", RomanCurrency.V);
        GalacticCurrencies.add("pish", RomanCurrency.X);
    }

    @Test
    @DisplayName("I should get 42 when I pass galactic currencies 'pish tegj glob glob'")
    void convert() throws CurrencyNotDefinedException {
        GalacticCurrencyToDecimalCurrencyConverter converter = GalacticCurrencyToDecimalCurrencyConverter.getInstance();
        Double total = converter.convert("pish tegj glob glob");
        Assertions.assertEquals(Double.valueOf(42), total, "Output should be 42");
    }

    @Test
    @DisplayName("I should get only one instance of the converter")
    void getInstance() {
        GalacticCurrencyToDecimalCurrencyConverter g1 = GalacticCurrencyToDecimalCurrencyConverter.getInstance();
        GalacticCurrencyToDecimalCurrencyConverter g2 = GalacticCurrencyToDecimalCurrencyConverter.getInstance();
        Assertions.assertEquals(g1, g2, "Should be equal because its singleton");
    }

    @AfterAll
    static void tearDown() {
        GalacticCurrencies.clearAll();
    }
}