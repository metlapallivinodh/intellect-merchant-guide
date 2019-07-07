package test.intellect.merchantguide.output;

public class ConsoleWriterOutputProcessor implements OutputProcessor {

    @Override
    public void process(String output) {
        System.out.println(output);
    }
}
