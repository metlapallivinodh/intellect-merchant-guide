package test.intellect.merchantguide.compute;


import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class ComputeProcessorChain {

    private final Enumeration<ComputeProcessor> chain;

    public ComputeProcessorChain(Enumeration<ComputeProcessor> chain) {
        this.chain = chain;
    }

    public ComputeProcessorChain() {
        this.chain = Collections.enumeration(
                Arrays.asList(
                        new TotalValueComputeProcessor(),
                        new CreditValueComputeProcessor(),
                        new UnrecognizedValueComputeProcessor()
                )
        );
    }

    public void execute(List<String> inputLines) throws Exception {
        while (chain.hasMoreElements()) {
            chain.nextElement().process(inputLines);
        }
    }

}
