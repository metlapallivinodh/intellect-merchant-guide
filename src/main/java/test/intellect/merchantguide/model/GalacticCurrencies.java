package test.intellect.merchantguide.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class GalacticCurrencies {

    private GalacticCurrencies() {}

    private static final Map<String, RomanCurrency> GALACTIC_CURRENCIES = new HashMap<>();

    public static void add(String name, RomanCurrency romanCurrency) {
        GALACTIC_CURRENCIES.put(name, romanCurrency);
    }

    public static RomanCurrency getRomanCurrency(String galacticCurrencyName) {
        return GALACTIC_CURRENCIES.get(galacticCurrencyName);
    }

    public static void clearAll() {
        GALACTIC_CURRENCIES.clear();
    }

    public static Map<String, RomanCurrency> getAvailableCurrencies() {
        return Collections.unmodifiableMap(GALACTIC_CURRENCIES);
    }

}
