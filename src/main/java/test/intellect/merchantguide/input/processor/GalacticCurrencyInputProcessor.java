package test.intellect.merchantguide.input.processor;

import test.intellect.merchantguide.exception.NoSuchRomanCurrencyException;
import test.intellect.merchantguide.model.GalacticCurrencies;
import test.intellect.merchantguide.model.RomanCurrency;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GalacticCurrencyInputProcessor implements InputProcessor {

    private static final String filterRegex = "^([A-Za-z]+) is ([I|V|X|L|C|D|M])$";

    private final Pattern pattern;

    public GalacticCurrencyInputProcessor(String filterRegex) {
        this.pattern = Pattern.compile(filterRegex);
    }

    public GalacticCurrencyInputProcessor() {
        this(filterRegex);
    }

    public void process(List<String> inputLines) throws NoSuchRomanCurrencyException {
        final ListIterator<String> inputListIterator = inputLines.listIterator();
        while (inputListIterator.hasNext()){
            final String eachLine = inputListIterator.next();
            final Matcher matcher = pattern.matcher(eachLine);
            if(matcher.matches()) {
                GalacticCurrencies.add(
                        matcher.group(1),
                        RomanCurrency.valueOf(matcher.group(2))
                );
                inputListIterator.remove();
            }
        }
    }
}
