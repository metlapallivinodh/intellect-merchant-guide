package test.intellect.merchantguide.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.intellect.merchantguide.model.RomanCurrency;

import java.util.Arrays;

@DisplayName("While converting Roman to Decimal")
class RomanCurrencyToDecimalGalacticCurrencyToDecimalCurrencyConverterTest {

    @Test
    @DisplayName("given input MDCCXXXII")
    void testSynthesisWithInputMDCCXXXII() {
        RomanCurrencyToDecimalCurrencyConverter romanCurrencyToDecimalCurrencyConverter = new RomanCurrencyToDecimalCurrencyConverter();
        final Double total = romanCurrencyToDecimalCurrencyConverter.convert(Arrays.asList(
                RomanCurrency.M,
                RomanCurrency.D,
                RomanCurrency.C,
                RomanCurrency.C,
                RomanCurrency.X,
                RomanCurrency.X,
                RomanCurrency.X,
                RomanCurrency.I,
                RomanCurrency.I
        ));
        Assertions.assertEquals(Double.valueOf(1732.0), total, "Expected value is 1732.0");
    }

    @Test
    @DisplayName("given input MMMM")
    void testSynthesisWithInputMMMM() {
        RomanCurrencyToDecimalCurrencyConverter romanCurrencyToDecimalCurrencyConverter = new RomanCurrencyToDecimalCurrencyConverter();
        final Double total = romanCurrencyToDecimalCurrencyConverter.convert(Arrays.asList(
                RomanCurrency.M,
                RomanCurrency.M,
                RomanCurrency.M,
                RomanCurrency.M
        ));
        Assertions.assertEquals(Double.valueOf(0), total, "Expected value is 0");
    }
}