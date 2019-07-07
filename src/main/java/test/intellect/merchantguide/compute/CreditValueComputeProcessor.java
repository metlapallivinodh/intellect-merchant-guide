package test.intellect.merchantguide.compute;

import test.intellect.merchantguide.core.GalacticCurrencyToDecimalCurrencyConverter;
import test.intellect.merchantguide.exception.CurrencyNotDefinedException;
import test.intellect.merchantguide.model.Metals;
import test.intellect.merchantguide.output.ConsoleWriterOutputProcessor;
import test.intellect.merchantguide.output.OutputProcessor;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CreditValueComputeProcessor implements ComputeProcessor {

    private static final String filterRegex = "^[h|H]ow many ([c|C]redits) is ([A-Za-z\\s]+) ([A-Za-z]+)\\s*\\?$";

    private final Pattern pattern;

    private final OutputProcessor outputProcessor;


    public CreditValueComputeProcessor(String filterRegex, OutputProcessor outputProcessor) {
        this.pattern = Pattern.compile(filterRegex);
        this.outputProcessor = outputProcessor;
    }

    public CreditValueComputeProcessor(OutputProcessor outputProcessor) {
        this(filterRegex, outputProcessor);
    }

    public CreditValueComputeProcessor() {
        this(filterRegex, new ConsoleWriterOutputProcessor());
    }

    public void process(List<String> inputLines) throws CurrencyNotDefinedException {
        final ListIterator<String> inputListIterator = inputLines.listIterator();
        while (inputListIterator.hasNext()){
            final String inputLine = inputListIterator.next();
            final Matcher matcher = pattern.matcher(inputLine);
            if(matcher.matches()) {
                Double currencyValue = GalacticCurrencyToDecimalCurrencyConverter.getInstance().convert(matcher.group(2));
                Double computedCredit = currencyValue * Metals.getUnitValue(matcher.group(3));
                String output = String.join(" ", matcher.group(2), matcher.group(3), "is", String.format("%.0f", computedCredit), matcher.group(1));
                outputProcessor.process(output);
                inputListIterator.remove();
            }
        }
    }

}
