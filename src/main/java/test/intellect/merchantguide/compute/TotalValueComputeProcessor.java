package test.intellect.merchantguide.compute;

import test.intellect.merchantguide.core.GalacticCurrencyToDecimalCurrencyConverter;
import test.intellect.merchantguide.exception.CurrencyNotDefinedException;
import test.intellect.merchantguide.output.ConsoleWriterOutputProcessor;
import test.intellect.merchantguide.output.OutputProcessor;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TotalValueComputeProcessor implements ComputeProcessor {

    private static final String filterRegex = "[h|H]ow much is (([A-Za-z\\s])+)\\s\\?$";

    private final Pattern pattern;

    private final OutputProcessor outputProcessor;

    public TotalValueComputeProcessor(String filterRegex, OutputProcessor outputProcessor) {
        this.pattern = Pattern.compile(filterRegex);
        this.outputProcessor = outputProcessor;
    }

    public TotalValueComputeProcessor(OutputProcessor outputProcessor) {
        this(filterRegex, outputProcessor);
    }

    public TotalValueComputeProcessor() {
        this(filterRegex, new ConsoleWriterOutputProcessor());
    }

    public void process(List<String> inputLines) throws CurrencyNotDefinedException {
        final ListIterator<String> inputListIterator = inputLines.listIterator();
        while (inputListIterator.hasNext()){
            final String inputLine = inputListIterator.next();
            final Matcher matcher = pattern.matcher(inputLine);
            if(matcher.matches()) {
                Double currencyValue = GalacticCurrencyToDecimalCurrencyConverter.getInstance().convert(matcher.group(1));
                String output = String.join(" ", matcher.group(1), "is", String.format("%.0f", currencyValue));
                outputProcessor.process(output);
                inputListIterator.remove();
            }
        }
    }

}
