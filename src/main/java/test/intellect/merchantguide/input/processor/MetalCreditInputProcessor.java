package test.intellect.merchantguide.input.processor;

import test.intellect.merchantguide.core.GalacticCurrencyToDecimalCurrencyConverter;
import test.intellect.merchantguide.exception.CurrencyNotDefinedException;
import test.intellect.merchantguide.model.Metals;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MetalCreditInputProcessor implements InputProcessor {

    private static final String filterRegex = "^([A-Za-z\\s]+) ([A-Za-z]+) is ([0-9]+) ([c|C]redits)$";

    private final Pattern pattern;

    public MetalCreditInputProcessor(String filterRegex) {
        this.pattern = Pattern.compile(filterRegex);
    }

    public MetalCreditInputProcessor() {
        this(filterRegex);
    }

    public void process(List<String> inputLines) throws CurrencyNotDefinedException {
        final ListIterator<String> inputListIterator = inputLines.listIterator();
        while (inputListIterator.hasNext()){
            final Matcher matcher = pattern.matcher(inputListIterator.next());
            if(matcher.matches()) {
                Double credit = Double.valueOf(matcher.group(3));
                Metals.add(
                    matcher.group(2),
                    credit / GalacticCurrencyToDecimalCurrencyConverter.getInstance().convert(matcher.group(1))
                );
                inputListIterator.remove();
            }
        }
    }

}
