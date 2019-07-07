package test.intellect.merchantguide.input.processor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class InputProcessorChain {

    private final Enumeration<InputProcessor> chain;

    public InputProcessorChain(Enumeration<InputProcessor> chain) {
        this.chain = chain;
    }

    public InputProcessorChain() {
        this.chain = Collections.enumeration(
                Arrays.asList(
                        new GalacticCurrencyInputProcessor(),
                        new MetalCreditInputProcessor()
                )
        );
    }

    public void execute(List<String> inputLines) throws Exception {
        while (chain.hasMoreElements()) {
            chain.nextElement().process(inputLines);
        }
    }

}
