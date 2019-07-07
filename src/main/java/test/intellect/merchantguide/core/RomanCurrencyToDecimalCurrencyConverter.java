package test.intellect.merchantguide.core;

import test.intellect.merchantguide.model.RomanCurrency;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

class RomanCurrencyToDecimalCurrencyConverter {

    private static final String REGEX_ROMAN_VALIDATOR = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private static final Pattern romanValidator = Pattern.compile(REGEX_ROMAN_VALIDATOR);

    Double convert(List<RomanCurrency> romanCurrencies) {
        double total = 0;
        if (romanCurrencies != null && !romanCurrencies.isEmpty() && romanValidator(romanCurrencies)) {
            for (int i = 0; i < romanCurrencies.size();) {
                double first = romanCurrencies.get(i).getValue();
                double second = i + 1 == romanCurrencies.size() ? 0 : romanCurrencies.get(i + 1).getValue();
                if (second > first) {
                    total += (second - first);
                    i = i + 2;
                } else {
                    total += first;
                    i++;
                }
            }
        }
        return total;
    }

    private boolean romanValidator(List<RomanCurrency> romanCurrencies) {
        final Optional<String> reducesRoman = romanCurrencies.stream()
                .map(c -> c.name())
                .reduce((first, second) -> first + second);
        if (reducesRoman.isPresent()) {
            return romanValidator.matcher(reducesRoman.get()).matches();
        }
        return false;
    }
}
