package test.intellect.merchantguide.core;

import test.intellect.merchantguide.exception.CurrencyNotDefinedException;

public class GalacticCurrencyToDecimalCurrencyConverter {

    private GalacticCurrencyToDecimalCurrencyConverter() {}

    private static GalacticCurrencyToDecimalCurrencyConverter CONVERTER = null;

    private GalacticCurrencyToRomanCurrencyConverter toRomanCurrencyConverter =
            new GalacticCurrencyToRomanCurrencyConverter();

    private RomanCurrencyToDecimalCurrencyConverter toDecimalCurrencyConverter =
            new RomanCurrencyToDecimalCurrencyConverter();

    public Double convert(String galacticCurrency) throws CurrencyNotDefinedException {
        return toDecimalCurrencyConverter.convert(
                toRomanCurrencyConverter.convert(galacticCurrency)
        );
    }

    public static GalacticCurrencyToDecimalCurrencyConverter getInstance() {
        if (CONVERTER == null) {
            CONVERTER = new GalacticCurrencyToDecimalCurrencyConverter();
        }
        return CONVERTER;
    }

}
