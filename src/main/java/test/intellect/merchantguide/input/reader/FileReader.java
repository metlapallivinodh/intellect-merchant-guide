package test.intellect.merchantguide.input.reader;

import java.util.List;

public interface FileReader {

    List<String> read(String fileName) throws Exception;

}
