package test.intellect.merchantguide.core;

import test.intellect.merchantguide.exception.CurrencyNotDefinedException;
import test.intellect.merchantguide.model.GalacticCurrencies;
import test.intellect.merchantguide.model.RomanCurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GalacticCurrencyToRomanCurrencyConverter {

    List<RomanCurrency> convert(String galacticCurrencyString) throws CurrencyNotDefinedException {
        if (galacticCurrencyString != null && !galacticCurrencyString.isEmpty()) {
            List<RomanCurrency> romanCurrencies = new ArrayList<>();
            for (String s : galacticCurrencyString.split("\\s+")) {
                final RomanCurrency romanCurrency = GalacticCurrencies.getRomanCurrency(s);
                if (romanCurrency == null) {
                    throw new CurrencyNotDefinedException("RomanCurrency mapping not defined for: " + s);
                }
                romanCurrencies.add(romanCurrency);
            }
            return romanCurrencies;
        }
        return Collections.emptyList();
    }

}
