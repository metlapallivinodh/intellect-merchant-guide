package test.intellect.merchantguide.input.processor;

import java.util.List;

public interface InputProcessor {
    void process(List<String> inputLines) throws Exception;
}
